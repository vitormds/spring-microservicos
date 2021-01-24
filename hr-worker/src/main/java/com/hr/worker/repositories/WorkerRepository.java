package com.hr.worker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.worker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
