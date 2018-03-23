package com.todo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController {

	@Autowired
	ToDoService todoService; 
	
	@RequestMapping("/run")
	public void run(){
		System.out.println("Running...");
	}
	
	@RequestMapping("/todo/{id}")
	public ToDo getTopic(@PathVariable String id){
		return todoService.getToDo(id);
	}
	
	@RequestMapping("/todos")
	public List<ToDo> getAllToDos(){
		return todoService.getAllToDos(); 
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/todo")
	public void addToDo(@RequestBody ToDo todo){
		System.out.println("Adding todo");
		todoService.createToDo(todo);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updatetodostatus/{id}")
	public void updateToDoStatus(@RequestBody ToDo todo, @PathVariable String id){
		todoService.updateToDoStatus(id, todo);
	}

	@RequestMapping(value="/todo/{id}",method=RequestMethod.DELETE)
	public void deleteToDo(@PathVariable String id){
		todoService.deleteToDo(id);
	}
}

