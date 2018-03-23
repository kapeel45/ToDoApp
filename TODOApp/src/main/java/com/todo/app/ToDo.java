package com.todo.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="todo_task",columnDefinition="VARCHAR(200)")
	private String todoTask;
	
	@Column(name="todo_task_desc",columnDefinition="VARCHAR(200)")
	private String todoTaskDesc;

	@Column(name="todo_task_status",columnDefinition="VARCHAR(50)")
	private String todoTaskStatus = "PENDING";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTodoTask() {
		return todoTask;
	}

	public void setTodoTask(String todoTask) {
		this.todoTask = todoTask;
	}

	public String getTodoTaskDesc() {
		return todoTaskDesc;
	}

	public void setTodoTaskDesc(String todoTaskDesc) {
		this.todoTaskDesc = todoTaskDesc;
	}

	public String getTodoTaskStatus() {
		return todoTaskStatus;
	}

	public void setTodoTaskStatus(String todoTaskStatus) {
		this.todoTaskStatus = todoTaskStatus;
	}

}
