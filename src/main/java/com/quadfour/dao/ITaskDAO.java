package com.quadfour.dao;

import java.util.List;
import com.quadfour.dto.TaskDTO;

public interface ITaskDAO {
    // I know its nitpicky but this should probably be renamed to saveTask just to be clear what you are saving
    boolean saveTask(TaskDTO taskDTO) throws Exception;

    Iterable<TaskDTO> fetchAll() throws Exception;
    // you must have copy pasted this from the plant application and forgot to change the name and return type
    List<TaskDTO> fetchTaskByTaskId(int taskId);
}
