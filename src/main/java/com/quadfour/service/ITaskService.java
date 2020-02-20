package com.quadfour.service;
import org.springframework.stereotype.Service;
import com.quadfour.dto.TaskDTO;

import java.util.List;

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
	 * @return
	 */
	boolean save(TaskDTO taskDTO);

	/**
	 * Save New Task
	 * @param taskDTO
	 */
	public List<TaskDTO> fetchTasks(String searchTerm);

}