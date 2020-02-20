package com.quadfour.service;

import java.util.ArrayList;
import java.util.List;

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
	 * @return
	 */
	@Override
	public boolean save(TaskDTO taskDTO) {
        return true;
    }

	/**
	 * Save New Task
	 * @param searchTerm
	 */
	@Override
	public List<TaskDTO> fetchTasks(String searchTerm) {

		List<TaskDTO> matchingTasks = new ArrayList<TaskDTO>();

		if (searchTerm.contains("mportant") || searchTerm.contains("rgent")) {
			TaskDTO task = new TaskDTO();

			task.setTaskText("An important and urgent task");
			task.setIsHighImportance(true);
			task.setIsHighUrgency(true);
			matchingTasks.add(task);

		}
		return matchingTasks;
	}

}
