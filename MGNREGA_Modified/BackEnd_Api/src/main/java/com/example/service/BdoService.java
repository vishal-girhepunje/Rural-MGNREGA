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

import java.util.List;

public interface BdoService {
    public String createProject(ProjectDTO projectDTO) throws ProjectException;
    public List<ProjectDTO> showAllProjects() throws ProjectException;
    public String createGPM(GpmDTO gpmDTO) throws GpmException;
    public List<GpmDTO> showAllGPM() throws GpmException;
    public String assignProjectToGPM(Integer projectId, Integer gpmId) throws ProjectException, GpmException;
    public List<WorkerDTO> showAllWorkers() throws WorkerException;
    public List<WorkerDTO> showAllWorkersByGPMID(int gpmID) throws WorkerException, GpmException;
    public List<WorkerDTO> showAllWorkersByProjectID(int projectID) throws WorkerException, ProjectException;

}
