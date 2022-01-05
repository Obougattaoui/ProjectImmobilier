package com.example.immob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.immob.dao.TaskRepository;
import com.example.immob.entities.Task;

@RestController
public class TaskRestController {
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	//une methode qui permet de consulter les taches:
	@GetMapping("/tasks")
	public List<Task> listTasks(){
		return taskRepository.findAll();
	}
	
	@PostMapping("/tasks")
	public Task save(@RequestBody Task t) {
		return taskRepository.save(t);
	}
	
	
}
