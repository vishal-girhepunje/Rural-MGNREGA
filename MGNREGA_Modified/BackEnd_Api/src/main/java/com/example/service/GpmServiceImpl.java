package com.example.service;

import com.example.exception.GpmException;
import com.example.exception.ProjectException;
import com.example.exception.WorkerException;
import com.example.model.GPM;
import com.example.model.Project;
import com.example.model.Worker;
import com.example.model.dto.WorkerDTO;
import com.example.model.dto.WorkerWagesDTO;
import com.example.repository.GpmRepository;
import com.example.repository.ProjectRepository;
import com.example.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class GpmServiceImpl implements GpmService{

    @Autowired
    private GpmRepository gpmRepository;

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private ProjectRepository projectRepository;

    /**
     * @param email
     * @return
     * @throws GpmException
     */
    @Override
    public GPM getGpmDetailsByEmail(String email) throws GpmException {
//        return gpmRepository.findByEmail(email).orElseThrow(() -> new GpmException("GPM not found with Email: " + email));
        Optional<GPM> opt = gpmRepository.findByEmail(email);
        if(opt.isPresent()) return opt.get();
        else throw new GpmException("GPM not found with Email: " + email);
    }

    /**
     *
     * @param workerDTO
     * @param gpmID
     * @return
     * @throws WorkerException
     * @throws GpmException
     */
    @Override
    public String createWorker(WorkerDTO workerDTO, Integer gpmID) throws WorkerException, GpmException {

        GPM gpm = gpmRepository.findById(gpmID).orElseThrow(() -> new GpmException("Not found any GPM with id: " + gpmID));
        if(workerDTO == null) throw new WorkerException("Not found any worker!");

        Worker newWorker = new Worker();
        newWorker.setWorkerName(workerDTO.getWorkerName());
        newWorker.setAadhaar(workerDTO.getAadhaar());
        newWorker.setDob(workerDTO.getDob());
        newWorker.setGender(workerDTO.getGender());
        newWorker.setGpName(workerDTO.getGpName());
        newWorker.setWorkStartDate(workerDTO.getWorkStartDate());
        newWorker.setDistrict(workerDTO.getDistrict());
        newWorker.setState(workerDTO.getState());
        newWorker.setGpm(gpm);

        workerRepository.save(newWorker);
        return "Worker created successfully!";
    }

    /**
     *
     * @param workerDTO
     * @param workerId
     * @return
     * @throws WorkerException
     */
    @Override
    public String updateWorker(WorkerDTO workerDTO, Integer workerId) throws WorkerException {

        Worker worker = workerRepository.findById(workerId).orElseThrow(() -> new WorkerException("Not found any worker with id: " + workerId));

        if(workerDTO.getWorkerName() != null) worker.setWorkerName(workerDTO.getWorkerName());
        if(workerDTO.getWorkStartDate() != null) worker.setWorkStartDate(workerDTO.getWorkStartDate());

        workerRepository.save(worker);
        return "Worker updated successfully!";
    }

    /**
     *
     * @param workerId
     * @param gpmID
     * @return
     * @throws WorkerException
     * @throws GpmException
     */
    @Override
    public String deleteWorker(Integer workerId, Integer gpmID) throws WorkerException, GpmException {

        GPM gpm = gpmRepository.findById(gpmID).orElseThrow(() -> new GpmException("Not found any GPM with id: " + gpmID));
        Worker worker = workerRepository.findById(workerId).orElseThrow(() -> new WorkerException("Not found any worker with id: " + workerId));

        gpm.getWorkers().remove(workerId);
        workerRepository.delete(worker);

        return "Worker deleted successfully!";
    }

    /**
     *
     * @param gpmID
     * @return
     * @throws GpmException
     */
    @Override
    public List<Project> showAllProjectOfGPM(Integer gpmID) throws GpmException {

        GPM gpm = gpmRepository.findById(gpmID).orElseThrow(() -> new GpmException("Not found any GPM with id: " + gpmID));

        List<Project> list = gpm.getProjects();
        return list;
    }

    /**
     *
     * @param gpmID
     * @return
     * @throws WorkerException
     * @throws GpmException
     */
    @Override
    public List<Worker> showAllWorkerOfGPM(Integer gpmID) throws WorkerException, GpmException {

        GPM gpm = gpmRepository.findById(gpmID).orElseThrow(() -> new GpmException("Not found any GPM with id: " + gpmID));

        List<Worker> list = gpm.getWorkers();
        return list;
    }

    /**
     *
     * @param aadhaar
     * @return
     * @throws WorkerException
     */
    @Override
    public Worker searchWorkerByAadhaar(String aadhaar) throws WorkerException {

        Optional<Worker> opt = workerRepository.findByAadhaar(aadhaar);

        if(opt.isEmpty()) throw new WorkerException("Worker not found with Aadhaar: " + aadhaar);
        return opt.get();
    }

    /**
     *
     * @param projectID
     * @param workerID
     * @return
     * @throws ProjectException
     * @throws WorkerException
     */
    @Override
    public String assignProjectToWorker(Integer projectID, Integer workerID) throws ProjectException, WorkerException {

        Worker worker = workerRepository.findById(workerID).orElseThrow(() -> new WorkerException("Not found any worker with id: " + workerID));
        Project project = projectRepository.findById(projectID).orElseThrow(() -> new ProjectException("Not found any project with id "+ projectID));

        worker.setProject(project);
        workerRepository.save(worker);

        return "Project assigned to worker successfully";
    }

    /**
     *
     * @param workerID
     * @return
     * @throws WorkerException
     */
    @Override
    public WorkerWagesDTO getWorkerWorkingDaysAndWages(Integer workerID) throws WorkerException {
        Worker worker = workerRepository.findById(workerID).orElseThrow(() -> new WorkerException("Not found any worker with id: " + workerID));
        return calculateTotalDaysWorkedAndWages(worker);
    }

    /**
     *
     * @param worker
     * @return
     */
    private WorkerWagesDTO calculateTotalDaysWorkedAndWages(Worker worker) {

        Integer projectID = null;
        Integer workingDays = null;
        Integer wages = null;

        if (worker.getProject() != null && worker.getWorkStartDate() != null) {
            LocalDate startDate = worker.getWorkStartDate();
            LocalDate endDate = LocalDate.now();
            workingDays = (int) ChronoUnit.DAYS.between(startDate, endDate);
            wages = workingDays * worker.getProject().getWagesPerDay();
            projectID = worker.getProject().getId();
        }

        WorkerWagesDTO wagesDTO = new WorkerWagesDTO();
        wagesDTO.setId(worker.getId());
        wagesDTO.setName(worker.getWorkerName());
        wagesDTO.setWorkingDays(workingDays);
        wagesDTO.setWages(wages);
        wagesDTO.setProjectID(projectID);

        return wagesDTO;
    }


}
