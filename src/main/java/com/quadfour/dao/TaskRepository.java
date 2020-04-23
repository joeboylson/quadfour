package com.quadfour.dao;

import com.quadfour.dto.TaskDTO;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskDTO, Integer> {
    Iterable<TaskDTO> findAllByUserId(Integer userId);
}
