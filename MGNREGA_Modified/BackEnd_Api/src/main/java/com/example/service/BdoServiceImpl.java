package com.example.service;

import com.example.exception.GpmException;
import com.example.exception.ProjectException;
import com.example.exception.WorkerException;
import com.example.model.GPM;
import com.example.model.Project;
import com.example.model.Worker;
import com.example.model.dto.GpmDTO;
import com.example.model.dto.ProjectDTO;
import com.example.model.dto.WorkerDTO;
import com.example.repository.GpmRepository;
import com.example.repository.ProjectRepository;
import com.example.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BdoServiceImpl implements BdoService{

    @Autowired
    private GpmRepository gpmRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private WorkerRepository workerRepository;


    /**
     * @param projectDTO
     * @return
     * @throws ProjectException
     */
    @Override
    public String createProject(ProjectDTO projectDTO) throws ProjectException {
        if(projectDTO == null) throw new ProjectException("Invalid project details!");

        Project project = new Project();
        project.setProjectName(projectDTO.getProjectName());
        project.setStartDate(projectDTO.getStartDate());
        project.setEndDate(projectDTO.getEndDate());
        project.setWagesPerDay(projectDTO.getWagesPerDay());

        projectRepository.save(project);
        return "Project created successfully";
    }

    /**
     * @return
     * @throws ProjectException
     */
    @Override
    public List<ProjectDTO> showAllProjects() throws ProjectException {
        List<Project> projects = projectRepository.findAll();

        List<ProjectDTO> projectDTOs = projects.stream()
                .map(project -> {
                    ProjectDTO dto = new ProjectDTO();
                    dto.setId(project.getId());
                    dto.setProjectName(project.getProjectName());
                    dto.setStartDate(project.getStartDate());
                    dto.setEndDate(project.getEndDate());
                    dto.setWagesPerDay(project.getWagesPerDay());
                    dto.setNumberOfWorkers(project.getNumberOfWorkers());
                    return dto;
                })
                .collect(Collectors.toList());

        return projectDTOs;
    }

    /**
     * @param gpmDTO
     * @return
     * @throws GpmException
     */
    @Override
    public String createGPM(GpmDTO gpmDTO) throws GpmException {
        if(gpmDTO == null) throw new GpmException("Invalid GPM details!");

        GPM gpm = new GPM();
        gpm.setName(gpmDTO.getName());
        gpm.setAadhaar(gpmDTO.getAadhaar());
        gpm.setDob(gpmDTO.getDob());
        gpm.setGender(gpmDTO.getGender());
        gpm.setEmail(gpmDTO.getEmail());
        gpm.setPassword(gpmDTO.getPassword());
        gpm.setGpName(gpmDTO.getGpName());
        gpm.setDistrict(gpmDTO.getDistrict());
        gpm.setState(gpmDTO.getState());
        gpm.setRole("ROLE_GPM");

        gpmRepository.save(gpm);
        return "GPM created successfully";
    }

    /**
     * @return
     * @throws GpmException
     */
    @Override
    public List<GpmDTO> showAllGPM() throws GpmException {
        List<GPM> gpms = gpmRepository.findAll();

        List<GpmDTO> gpmDTOs = gpms.stream()
                .map(gpm -> {
                    GpmDTO dto = new GpmDTO();
                    dto.setId(gpm.getId());
                    dto.setName(gpm.getName());
                    dto.setAadhaar(gpm.getAadhaar());
                    dto.setDob(gpm.getDob());
                    dto.setGender(gpm.getGender());
                    dto.setEmail(gpm.getEmail());
                    dto.setPassword("********");
                    dto.setGpName(gpm.getGpName());
                    dto.setDistrict(gpm.getDistrict());
                    dto.setState(gpm.getState());
                    return dto;
                })
                .collect(Collectors.toList());

        return gpmDTOs;
    }

    /**
     * @param projectId
     * @param gpmId
     * @return
     * @throws ProjectException
     * @throws GpmException
     */
    @Override
    public String assignProjectToGPM(Integer projectId, Integer gpmId) throws ProjectException, GpmException {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new ProjectException("Project not found with ID: " + projectId));
        GPM gpm = gpmRepository.findById(gpmId).orElseThrow(() -> new GpmException("GPM not found with ID: " + gpmId));

        project.setGpm(gpm);
        projectRepository.save(project);

        return "Project assigned to GPM successfully";
    }

    /**
     * @return
     * @throws WorkerException
     */
    @Override
    public List<WorkerDTO> showAllWorkers() throws WorkerException {
        List<Worker> workers = workerRepository.findAll();

        List<WorkerDTO> workerDTOs = workers.stream()
                .map(worker -> {
                    WorkerDTO dto = new WorkerDTO();
                    dto.setId(worker.getId());
                    dto.setWorkerName(worker.getWorkerName());
                    dto.setAadhaar(worker.getAadhaar());
                    dto.setDob(worker.getDob());
                    dto.setGender(worker.getGender());
                    dto.setGpName(worker.getGpName());
                    dto.setWorkStartDate(worker.getWorkStartDate());
                    dto.setDistrict(worker.getDistrict());
                    dto.setState(worker.getState());
                    return dto;
                })
                .collect(Collectors.toList());

        return workerDTOs;
    }

    /**
     * @param gpmID
     * @return
     * @throws WorkerException
     * @throws GpmException
     */
    @Override
    public List<WorkerDTO> showAllWorkersByGPMID(int gpmID) throws WorkerException, GpmException {

        GPM gpm = gpmRepository.findById(gpmID).orElseThrow(() -> new GpmException("GPM not found with ID: " + gpmID));
        List<Worker> workers = gpm.getWorkers();

        List<WorkerDTO> workerDTOs = workers.stream()
                .map(worker -> {
                    WorkerDTO dto = new WorkerDTO();
                    dto.setId(worker.getId());
                    dto.setWorkerName(worker.getWorkerName());
                    dto.setAadhaar(worker.getAadhaar());
                    dto.setDob(worker.getDob());
                    dto.setGender(worker.getGender());
                    dto.setGpName(worker.getGpName());
                    dto.setWorkStartDate(worker.getWorkStartDate());
                    dto.setDistrict(worker.getDistrict());
                    dto.setState(worker.getState());
                    return dto;
                })
                .collect(Collectors.toList());

        return workerDTOs;
    }

    /**
     * @param projectID
     * @return
     * @throws WorkerException
     * @throws ProjectException
     */
    @Override
    public List<WorkerDTO> showAllWorkersByProjectID(int projectID) throws WorkerException, ProjectException {

        Project project = projectRepository.findById(projectID).orElseThrow(() -> new ProjectException("Project not found with ID: " + projectID));
        List<Worker> workers = projectRepository.findWorkersByProjectId(projectID);

        List<WorkerDTO> workerDTOs = workers.stream()
                .map(worker -> {
                    WorkerDTO dto = new WorkerDTO();
                    dto.setId(worker.getId());
                    dto.setWorkerName(worker.getWorkerName());
                    dto.setAadhaar(worker.getAadhaar());
                    dto.setDob(worker.getDob());
                    dto.setGender(worker.getGender());
                    dto.setGpName(worker.getGpName());
                    dto.setWorkStartDate(worker.getWorkStartDate());
                    dto.setDistrict(worker.getDistrict());
                    dto.setState(worker.getState());
                    return dto;
                })
                .collect(Collectors.toList());

        return workerDTOs;
    }
}
