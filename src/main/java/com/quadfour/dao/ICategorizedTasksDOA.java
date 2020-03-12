package com.quadfour.dao;

import com.quadfour.dto.CategorizedTasksDTO;
import com.quadfour.dto.TaskDTO;

import java.util.ArrayList;

public interface ICategorizedTasksDOA {
    CategorizedTasksDTO getCategorizedTasks();
    ArrayList<TaskDTO> getTasksByQuadrant(boolean isImportant, boolean isUrgent);
}
