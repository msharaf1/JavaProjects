package com.codingdojo.loginreg.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.loginreg.models.Task;

public interface TaskRepository extends CrudRepository<Task,Long>{
}
