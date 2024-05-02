package com.example.controller;

import com.example.model.GPM;
import com.example.model.Project;
import com.example.model.Worker;
import com.example.model.dto.WorkerDTO;
import com.example.model.dto.WorkerWagesDTO;
import com.example.repository.GpmRepository;
import com.example.service.GpmService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GpmController {

    @Autowired
    private GpmService service;

    @GetMapping("/welcome")
    public String welcomeHandler() {
        return "Welcome to MGNRAGA application...";
    }

    @GetMapping("/signIn")
    public ResponseEntity<String> getLoggedInGpmDetailsHandler(Authentication auth){
        GPM gpm = service.getGpmDetailsByEmail(auth.getName());
        String msg = gpm.getName() + " logged In Successfully";
        System.out.println(msg);
        return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
    }

    @PostMapping("/gpm/{gpmID}/worker/register")
    public ResponseEntity<String> createWorkerHandler(@Valid @RequestBody WorkerDTO workerDTO, @PathVariable Integer gpmID){
        String msg = service.createWorker(workerDTO, gpmID);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @PutMapping("/gpm/{gpmID}/worker/{workerID}")
    public ResponseEntity<String> updateWorkerHandler(@RequestBody WorkerDTO workerDTO, @PathVariable Integer workerID){
        String msg = service.updateWorker(workerDTO, workerID);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("/gpm/{gpmID}/worker/{workerID}")
    public ResponseEntity<String> deleteWorkerHandler(@PathVariable Integer gpmID, @PathVariable Integer workerID){
        String msg = service.deleteWorker(workerID, gpmID);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/gpm/{gpmID}/projects")
    public ResponseEntity<List<Project>> showAllProjectsOfGPMHandler(@PathVariable Integer gpmID) {
        List<Project> projects = service.showAllProjectOfGPM(gpmID);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/gpm/{gpmID}/workers")
    public ResponseEntity<List<Worker>> showAllWorkersOfGPMHandler(@PathVariable Integer gpmID) {
        List<Worker> workers = service.showAllWorkerOfGPM(gpmID);
        return new ResponseEntity<>(workers, HttpStatus.OK);
    }

    @GetMapping("/gpm/workers/{aadhaar}")
    public ResponseEntity<Worker> getWorkerDetailsByAadhaarHandler(@PathVariable String aadhaar) {
        Worker worker = service.searchWorkerByAadhaar(aadhaar);
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @PostMapping("/gpm/assignProject")
    public ResponseEntity<String> assignProjectToWorkerHandler(@RequestParam Integer projectID, @RequestParam Integer workerID) {
        String message = service.assignProjectToWorker(projectID, workerID);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/gpm/worker/{workerID}/workingDaysAndWages")
    public ResponseEntity<WorkerWagesDTO> getWorkerWorkingDaysAndWagesHandler(@PathVariable Integer workerID){
        WorkerWagesDTO workerWagesDTO = service.getWorkerWorkingDaysAndWages(workerID);
        return new ResponseEntity<>(workerWagesDTO, HttpStatus.OK);
    }

    //    @Autowired
//    private GpmRepository repository;

//    @PostMapping("/add")
//    public ResponseEntity<GPM> addGPM(@RequestBody GPM gpm){
//        GPM createdGPM = repository.save(gpm);
//        return new ResponseEntity<>(createdGPM, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/gpm")
//    public ResponseEntity<List<GPM>> getGPM(){
//        List<GPM> gpms = repository.findAll();
//        return new ResponseEntity<>(gpms, HttpStatus.OK);
//    }

}
