package com.example.controller;

import com.example.model.BDO;
import com.example.model.GPM;
import com.example.model.Project;
import com.example.model.dto.GpmDTO;
import com.example.model.dto.ProjectDTO;
import com.example.model.dto.WorkerDTO;
import com.example.repository.BdoRepository;
import com.example.repository.ProjectRepository;
import com.example.service.BdoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BdoController {

    @Autowired
    private BdoService bdoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/bdo/project")
    public ResponseEntity<String> createProjectHandler(@Valid @RequestBody ProjectDTO projectDTO) {
        String msg = bdoService.createProject(projectDTO);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping("/bdo/projects")
    public ResponseEntity<List<ProjectDTO>> showAllProjectsHandler() {
        List<ProjectDTO> projects = bdoService.showAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping("/bdo/gpm")
    public ResponseEntity<String> createGpmHandler(@Valid @RequestBody GpmDTO gpmDTO) {
//        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
//        customer.setRole("ROLE_" + customer.getRole().toUpperCase());
        gpmDTO.setPassword(passwordEncoder.encode(gpmDTO.getPassword()));
        String msg = bdoService.createGPM(gpmDTO);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping("/bdo/gpms")
    public ResponseEntity<List<GpmDTO>> showAllGpmHandler() {
        List<GpmDTO> gpms = bdoService.showAllGPM();
        return new ResponseEntity<>(gpms, HttpStatus.OK);
    }

    @PostMapping("/bdo/assignProject")
    public ResponseEntity<String> assignProjectToGpmHandler(@RequestParam Integer projectId, @RequestParam Integer gpmId) {
        String message = bdoService.assignProjectToGPM(projectId, gpmId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/bdo/workers")
    public ResponseEntity<List<WorkerDTO>> showAllWorkersHandler() {
        List<WorkerDTO> workers = bdoService.showAllWorkers();
        return new ResponseEntity<>(workers, HttpStatus.OK);
    }

    @GetMapping("/bdo/gpm/{gpmID}/workers")
    public ResponseEntity<List<WorkerDTO>> showAllWorkersByGpmHandler(@PathVariable Integer gpmID) {
        List<WorkerDTO> workers = bdoService.showAllWorkersByGPMID(gpmID);
        return new ResponseEntity<>(workers, HttpStatus.OK);
    }

    @GetMapping("/bdo/project/{projectID}/workers")
    public ResponseEntity<List<WorkerDTO>> showAllWorkersByProjectHandler(@PathVariable Integer projectID){
        List<WorkerDTO> workers = bdoService.showAllWorkersByProjectID(projectID);
        return new ResponseEntity<>(workers, HttpStatus.OK);
    }

//    @Autowired
//    private ProjectRepository projectRepository;

//    @Autowired
//    private BdoRepository repository;

//    @PostMapping("/bdo/add")
//    public ResponseEntity<BDO> addBDO(@RequestBody BDO bdo){
//        BDO createdBDO = repository.save(bdo);
//        return new ResponseEntity<>(createdBDO, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/bdo/all")
//    public ResponseEntity<List<BDO>> getBDO() {
//        List<BDO> bdos = repository.findAll();
//        return new ResponseEntity<>(bdos, HttpStatus.OK);
//    }

//    @PostMapping("/bdo/project/add")
//    public ResponseEntity<Project> addProject(@RequestBody Project project){
//        Project createdProject = projectRepository.save(project);
//        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/bdo/project/all")
//    public ResponseEntity<List<Project>> getProject(){
//        List<Project> projects = projectRepository.findAll();
//        return new ResponseEntity<>(projects, HttpStatus.CREATED);
//    }

}
