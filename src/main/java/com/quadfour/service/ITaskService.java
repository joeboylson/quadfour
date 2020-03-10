package com.quadfour.service;
import org.springframework.stereotype.Service;

import com.quadfour.dto.TaskDTO;
import com.quadfour.dto.CategorizedTasksDTO;

import java.util.ArrayList;
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
	 */
	public CategorizedTasksDTO getCategorizedTasks();

	/**
	 * Save New Task
	 */
	public ArrayList<TaskDTO> getTasksByQuadrant(boolean important, boolean urgent);

	/**
	 * Save New Task
	 * @param searchTerm
	 */
	public List<TaskDTO> searchTasks(String searchTerm);

}