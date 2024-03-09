package com.example.repository;

import com.example.model.GPM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GpmRepository extends JpaRepository<GPM, Integer> {
    public Optional<GPM> findByEmail(String email);
}
