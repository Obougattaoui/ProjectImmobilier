package com.example.immob.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.immob.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
