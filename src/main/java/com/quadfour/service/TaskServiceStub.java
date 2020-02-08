package com.quadfour.service;
import org.springframework.stereotype.Component;
import com.quadfour.dto.TaskDTO;

@Component
public class TaskServiceStub implements ITaskService {
	
	/*
	 * - when stub is all set up
	 * - right click anywhere in this file
	 * - refactor > extract interface > name interface
	 */
	
	/**
	 * Fetch By Id
	 * @param id
	 * @return taskDTO
	 */
	@Override
	public TaskDTO fetchById(int id) {
		System.out.println("::: FETCH TASK BY ID");
		TaskDTO taskDTO = new TaskDTO(); 
		taskDTO.setTaskId(55);
		return taskDTO;
	}
	
	/**
	 * Save New Task
	 * @param taskDTO
	 */
	@Override
	public void save(TaskDTO taskDTO) {
		System.out.println("::: SAVE TASK");
	}
	

}
