package com.example.repository;

import com.example.model.Project;
import com.example.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("select w from Worker w where w.project.id = ?1")
    public List<Worker> findWorkersByProjectId(Integer projectId);

}
