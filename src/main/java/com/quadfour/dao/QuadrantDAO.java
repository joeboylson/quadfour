package com.quadfour.dao;

import com.quadfour.dto.QuadrantDTO;
import com.quadfour.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuadrantDAO implements IQuadrantDAO {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public QuadrantDTO getQuadrant(boolean isImportant, boolean isUrgent) {

        Iterable<TaskDTO> allTasks = taskRepository.findAll();
        QuadrantDTO quadrantTasks = new QuadrantDTO(){{ setIsHighUrgency(isUrgent); setIsHighImportance(isImportant);}};

        allTasks.forEach(task -> {

            boolean important = task.getIsHighImportance();
            boolean urgent = task.getIsHighUrgency();

            if (important == isImportant && urgent == isUrgent) {
                quadrantTasks.addTask(task);
            }

        });

        return quadrantTasks;
    }
}