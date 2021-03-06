package com.quadfour.service;

import com.quadfour.dto.CategorizedTasksDTO;
import com.quadfour.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ICategorizedTasksService {
    CategorizedTasksDTO getCategorizedTasks(int userid);
}
