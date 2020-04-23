package com.quadfour.dao;

import com.quadfour.dto.UserDTO;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <UserDTO, Long> {
    UserDTO findByUsername(String username);
    UserDTO findByUserId(int userId);
}
