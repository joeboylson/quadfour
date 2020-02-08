package com.quadfour.service;
import com.quadfour.dto.TaskDTO;

/**
 * CRUD OPERATIONS FOR TASKS
 * @author JOE
 */

public interface ITaskService {

	/**
	 * Fetch By Id
	 * @param id
	 * @return taskDTO
	 */
	TaskDTO fetchById(int id);

	/**
	 * Save New Task
	 * @param taskDTO
	 */
	void save(TaskDTO taskDTO);

}