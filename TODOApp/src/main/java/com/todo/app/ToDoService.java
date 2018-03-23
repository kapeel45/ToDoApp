package com.todo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

	@Autowired
	ToDoRepository todoRepo;
	
	public void createToDo(ToDo todo){
		todoRepo.save(todo);
	}

	public ToDo getToDo(String id){
		ToDo toDo = todoRepo.findOne(Long.parseLong(id));
		return toDo;
	}
	
	public void deleteToDo(String id){
		todoRepo.delete(Long.parseLong(id));
	}

	public List<ToDo> getAllToDos() {
		return (List<ToDo>) todoRepo.findAll();
	}

	public void updateToDoStatus(String id, ToDo todo) {
		
		System.out.println("Updating todo");
		ToDo todoUpdate = todoRepo.findOne(Long.parseLong(id));
		
		todoUpdate.setTodoTaskStatus(todo.getTodoTaskStatus());
		
		if(todoUpdate != null)
			todoRepo.save(todoUpdate);
	}
}

