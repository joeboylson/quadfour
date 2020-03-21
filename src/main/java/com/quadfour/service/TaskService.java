package com.quadfour.service;

import com.quadfour.dao.ITaskDAO;
import com.quadfour.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskService implements ITaskService {

    @Autowired
    ITaskDAO taskDAO;

    @Override
    public TaskDTO fetchById(int id) {
        TaskDTO fetchedTask = taskDAO.fetchTaskByTaskId(id);
        return fetchedTask;
    }

    @Override
    public TaskDTO save(TaskDTO taskDTO) throws Exception {
        TaskDTO savedTask = taskDAO.save(taskDTO);
        return savedTask;
    }

    @Override
    public void deleteById(int id) {
        taskDAO.deleteTaskByTaskId(id);
    }

    @Override
    public List<TaskDTO> searchTasks(String searchTerm) {
        return null;
    }

}