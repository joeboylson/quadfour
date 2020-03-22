package com.quadfour.service;

import com.quadfour.dao.CategorizedTasksDAO;
import com.quadfour.dto.CategorizedTasksDTO;
import com.quadfour.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CategorizedTasksService implements ICategorizedTasksService {

    @Autowired
    CategorizedTasksDAO categorizedTasksDAO;

    @Override
    public CategorizedTasksDTO getCategorizedTasks() {
        CategorizedTasksDTO categorizedTasks = categorizedTasksDAO.getCategorizedTasks();
        return categorizedTasks;
    };
}
