package com.quadfour.dao;

import com.quadfour.dto.TaskDTO;

public interface ITaskDAO {

    TaskDTO save(TaskDTO taskDTO) throws Exception;

    Iterable<TaskDTO> fetchAll() throws Exception;

    TaskDTO fetchTaskByTaskId(int id);

    void deleteTaskByTaskId(int id);
}
