package com.quadfour.dao;

import com.quadfour.dto.TaskDTO;
import com.quadfour.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TaskDAO implements ITaskDAO {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public TaskDTO save(TaskDTO taskDTO) throws Exception {
        TaskDTO savedTask = taskRepository.save(taskDTO);
        return savedTask;
    }

    @Override
    public Iterable<TaskDTO> fetchAll() throws Exception {
        return null;
    }

    @Override
    public TaskDTO fetchTaskByTaskId(int id) {
        Optional<TaskDTO> fetchedTask = taskRepository.findById(id);
        return fetchedTask.orElse(null);
    }

    @Override
    public void deleteTaskByTaskId(int id) {
       taskRepository.deleteById(id);
    }

}
