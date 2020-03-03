package com.quadfour.dao;

import java.util.List;
import com.quadfour.dto.TaskDTO;

public interface ITaskDAO {

    boolean save(TaskDTO taskDTO) throws Exception;

    Iterable<TaskDTO> fetchAll() throws Exception;

    List<TaskDTO> fetchTaskByTaskId(int taskID);
}
