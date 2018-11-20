package com.codingdojo.loginreg.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.codingdojo.loginreg.models.Task;
import com.codingdojo.loginreg.repositories.TaskRepository;

@Service
public class TaskService{
	private TaskRepository tR;
	
	public TaskService(TaskRepository tR){
		this.tR = tR;
	}

	public Task create(Task task){
		return tR.save(task);
	}
	
	public ArrayList<Task> findAll(){
		return (ArrayList<Task>) tR.findAll();
	}
	
	public Task findById(Long id){
		return tR.findById(id).get();
	}
	
	public Task update(Task task){
		return tR.save(task);
	}
	
	public void destroy(Long id) {
		tR.deleteById(id);
	}
}















