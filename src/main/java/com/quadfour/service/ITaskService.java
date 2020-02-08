package com.quadfour.service;
import org.springframework.stereotype.Service;
import com.quadfour.dto.TaskDTO;

/**
 * CRUD OPERATIONS FOR TASKS
 * @author JOE
 */

@Service
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