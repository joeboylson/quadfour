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
    public TaskDTO fetchById(int id, int userId) {
        TaskDTO fetchedTask = taskDAO.fetchTaskByTaskId(id);

        // make sure the user owns the task
        if ( fetchedTask == null || !(fetchedTask.getUserId() == userId)) {
            return null;
        }

        return fetchedTask;
    }

    @Override
    public TaskDTO save(TaskDTO taskDTO, int userId) throws Exception {
        taskDTO.setUserId(userId);
        TaskDTO savedTask = taskDAO.save(taskDTO);
        return savedTask;
    }

    @Override
    public void deleteById(int id, int userId) {

        TaskDTO toDeleteTask = taskDAO.fetchTaskByTaskId(id);

        // make sure the user owns the task
        if ( toDeleteTask == null || !(toDeleteTask.getUserId() == userId)) {
            return;
        }

        taskDAO.deleteTaskByTaskId(id);
    }

    @Override
    public List<TaskDTO> searchTasks(String searchTerm) {
        return null;
    }

}
