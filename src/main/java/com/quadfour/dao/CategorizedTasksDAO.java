package com.quadfour.dao;

import com.quadfour.dto.CategorizedTasksDTO;
import com.quadfour.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Component
public class CategorizedTasksDAO implements ICategorizedTasksDOA {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public CategorizedTasksDTO getCategorizedTasks() {

        Iterable<TaskDTO> allTasks = taskRepository.findAll();
        CategorizedTasksDTO categorizedTasks = new CategorizedTasksDTO();

        allTasks.forEach(task -> {

            boolean important = task.getIsHighImportance();
            boolean urgent = task.getIsHighUrgency();

            if (important) {
                if (urgent) {
                    categorizedTasks.addImportantUrgent(task);
                } else {
                    categorizedTasks.addImportantNotUrgent(task);
                }
            } else {
                if (urgent) {
                    categorizedTasks.addNotImportantUrgent(task);
                } else {
                    categorizedTasks.addNotImportantNotUrgent(task);
                }
            }

        });

        return categorizedTasks;
    }

    @Override
    public ArrayList<TaskDTO> getTasksByQuadrant(boolean isImportant, boolean isUrgent) {

        Iterable<TaskDTO> allTasks = taskRepository.findAll();
        ArrayList<TaskDTO> quadrantTasks = new ArrayList<TaskDTO>();

        allTasks.forEach(task -> {

            boolean important = task.getIsHighImportance();
            boolean urgent = task.getIsHighUrgency();

            if (important == isImportant && urgent == isUrgent) {
                quadrantTasks.add(task);
            }

        });

        return quadrantTasks;
    }
}