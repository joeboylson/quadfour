package com.quadfour.dao;

import com.quadfour.dto.QuadrantDTO;
import com.quadfour.dto.TaskDTO;
import com.quadfour.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuadrantDAO implements IQuadrantDAO {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public QuadrantDTO getQuadrant(boolean isImportant, boolean isUrgent, int userId) {

        UserDTO user = userRepository.findByUserId(userId);
        List<TaskDTO> allTasks = user.getUserTasks();
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