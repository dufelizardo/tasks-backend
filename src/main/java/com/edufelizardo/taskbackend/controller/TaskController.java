package com.edufelizardo.taskbackend.controller;

import com.edufelizardo.taskbackend.model.Task;
import com.edufelizardo.taskbackend.repo.TaskRepo;
import com.edufelizardo.taskbackend.utils.DateUtils;
import com.edufelizardo.taskbackend.utils.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/todo")
public class TaskController {

	@Autowired
	private TaskRepo todoRepo;
	
	@GetMapping
	public List<Task> findAll() {
		return todoRepo.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Task> save(@RequestBody Task todo) throws ValidationException {
		if(todo.getTask() == null || todo.getTask() == "") {
			throw new ValidationException("Fill the task description");
		}
		if(todo.getDueDate() == null) {
			throw new ValidationException("Fill the due date");
		}
		if(!DateUtils.isEqualOrFutureDate(todo.getDueDate())) {
			throw new ValidationException("Due date must not be in past");
		}
		Task saved = todoRepo.save(todo);
		return new ResponseEntity<Task>(saved, HttpStatus.CREATED);
	}
}