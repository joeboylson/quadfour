package com.quadfour.service;

import org.springframework.stereotype.Service;
import com.quadfour.dto.TaskDTO;
import java.util.List;

@Service
public interface ITaskService {

	/**
	 * Fetch By Id
	 * @param id
	 * @return taskDTO
	 */
	TaskDTO fetchTaskById(int id);

	/**
	 * Save New Task
	 * @param taskDTO
	 * @return
	 */
	TaskDTO saveTask(TaskDTO taskDTO) throws Exception;

	/**
	 * Fetch By Id
	 * @param id
	 * @return taskDTO
	 */
	void deleteTaskById(int id);

	/**
	 * Save New Task
	 * @param searchTerm
	 */
	public List<TaskDTO> searchTasks(String searchTerm);

}