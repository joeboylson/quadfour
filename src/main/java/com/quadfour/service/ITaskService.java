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
	TaskDTO fetchById(int id, int userId);

	/**
	 * Save New Task
	 * @param taskDTO
	 * @return
	 */
	TaskDTO save(TaskDTO taskDTO, int userId) throws Exception;

	/**
	 * Fetch By Id
	 * @param id
	 * @return taskDTO
	 */
	void deleteById(int id, int userId);

	/**
	 * Save New Task
	 * @param searchTerm
	 */
	public List<TaskDTO> searchTasks(String searchTerm);

}