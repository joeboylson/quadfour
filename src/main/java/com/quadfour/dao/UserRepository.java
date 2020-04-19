package com.quadfour.dao;

import com.quadfour.dto.UsersDTO;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <UsersDTO, Long> {
    UsersDTO findByUsername(String username);
}
