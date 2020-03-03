package com.quadfour.service;

import java.util.ArrayList;
import java.util.List;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.stereotype.Component;
import com.quadfour.dto.TaskDTO;
import com.quadfour.dto.CategorizedTasksDTO;

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
	 * Fetch all tasks
	 */
	public CategorizedTasksDTO getCategorizedTasks() {

		String base_path = System.getProperty("user.dir");
		CategorizedTasksDTO categorizedTasks = new CategorizedTasksDTO();

		FileReader reader = null;

		try {
			reader = new FileReader(base_path + "/src/main/resources/assets/tasks.json");
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(reader);

			JSONArray taskList = (JSONArray) obj;

			System.out.println(taskList);

			taskList.forEach( t -> {

				System.out.println(t);

				JSONObject taskObj = (JSONObject) t;
				TaskDTO task = new TaskDTO();

				Long long_id = (Long) taskObj.get("taskId");
				Integer id = Math.toIntExact(long_id);
				String text = (String) taskObj.get("taskText");
				Boolean important = (Boolean) taskObj.get("isHighImportance");
				Boolean urgent = (Boolean) taskObj.get("isHighUrgency");

				task.setTaskId(id);
				task.setTaskText(text);
				task.setIsHighImportance(important);
				task.setIsHighUrgency(urgent);

				if (important) {
					if (urgent) {
						categorizedTasks.addImportantUrgent(task);
					}
					else {
						categorizedTasks.addImportantNotUrgent(task);
					}
				}
				else {
					if (urgent) {
						categorizedTasks.addNotImportantUrgent(task);
					}
					else {
						categorizedTasks.addNotImportantNotUrgent(task);
					}
				}

			});

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return categorizedTasks;
		} catch (ParseException e) {
			e.printStackTrace();
			return categorizedTasks;
		} catch (IOException e) {
			e.printStackTrace();
			return categorizedTasks;
		}

		return categorizedTasks;
	}

	/**
	 * Save New Task
	 * @param searchTerm
	 */
	public List<TaskDTO> searchTasks(String searchTerm) {

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
