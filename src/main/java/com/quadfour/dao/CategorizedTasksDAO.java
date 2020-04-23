package com.quadfour.dao;

import com.quadfour.dto.CategorizedTasksDTO;
import com.quadfour.dto.QuadrantDTO;
import com.quadfour.dto.TaskDTO;
import com.quadfour.dto.UserDTO;
import com.quadfour.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategorizedTasksDAO implements ICategorizedTasksDOA {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public CategorizedTasksDTO getCategorizedTasks(int userId) {

        UserDTO user = userRepository.findByUserId(userId);
        List<TaskDTO> allTasks = user.getUserTasks();

        QuadrantDTO importantUrgent = new QuadrantDTO(){{ setIsHighImportance(true); setIsHighUrgency(true);}};
        QuadrantDTO importantNotUrgent = new QuadrantDTO(){{ setIsHighImportance(true); }};
        QuadrantDTO notImportantUrgent = new QuadrantDTO(){{ setIsHighUrgency(true); }};
        QuadrantDTO notImportantNotUrgent = new QuadrantDTO();
        CategorizedTasksDTO categorizedTasks = new CategorizedTasksDTO();

        allTasks.forEach(task -> {

            boolean important = task.getIsHighImportance();
            boolean urgent = task.getIsHighUrgency();

            if (important) {
                if (urgent) {
                    importantUrgent.addTask(task);
                } else {
                    importantNotUrgent.addTask(task);
                }
            } else {
                if (urgent) {
                    notImportantUrgent.addTask(task);
                } else {
                    notImportantNotUrgent.addTask(task);
                }
            }

        });

        categorizedTasks.setImportantUrgent(importantUrgent);
        categorizedTasks.setImportantNotUrgent(importantNotUrgent);
        categorizedTasks.setNotImportantUrgent(notImportantUrgent);
        categorizedTasks.setNotImportantNotUrgent(notImportantNotUrgent);

        return categorizedTasks;
    }
}