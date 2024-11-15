package com.todoWithMongo.todoWithMongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
@Autowired

private TodoRepository todoRepo;
@GetMapping("/")
public String home() {
	return "hello ";
}
@GetMapping("/todos")
public ResponseEntity getAllTodos() {
	List<TodoDTO> todos=todoRepo.findAll()	;
	if(todos.size()>0) {
		todos.forEach(todo -> System.out.println(todo));
		return new ResponseEntity<List<TodoDTO>>(todos,HttpStatus.OK);
	}
	else {
		return new ResponseEntity("no todo found",HttpStatus.NOT_FOUND);
	}
}
}