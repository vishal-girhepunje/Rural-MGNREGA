package com.example.service;

import com.example.exception.GpmException;
import com.example.exception.ProjectException;
import com.example.exception.WorkerException;
import com.example.model.GPM;
import com.example.model.Project;
import com.example.model.Worker;
import com.example.model.dto.WorkerDTO;
import com.example.model.dto.WorkerWagesDTO;

import java.util.List;

public interface GpmService {
    public GPM getGpmDetailsByEmail(String email) throws GpmException;
    public String createWorker(WorkerDTO workerDTO, Integer gpmID) throws WorkerException, GpmException;
    public String updateWorker(WorkerDTO workerDTO, Integer workerId) throws WorkerException;
    public String deleteWorker(Integer workerId, Integer gpmID) throws WorkerException, GpmException;
    public List<Project> showAllProjectOfGPM(Integer gpmID) throws GpmException;
    public List<Worker> showAllWorkerOfGPM(Integer gpmID) throws WorkerException, GpmException;
    public Worker searchWorkerByAadhaar(String aadhaar) throws WorkerException;
    public String assignProjectToWorker(Integer projectID, Integer workerID) throws ProjectException, WorkerException;
    public WorkerWagesDTO getWorkerWorkingDaysAndWages(Integer workerID) throws WorkerException;
}
