package com.quadfour.dao;

import com.quadfour.dto.CategorizedTasksDTO;

public interface ICategorizedTasksDOA {
    CategorizedTasksDTO getCategorizedTasks(int userId);
}
