package com.quadfour.dao;

import com.quadfour.dto.UserDTO;

public interface IUserDAO {
    UserDTO findByUsername(String username);
    UserDTO findById(int userId);
}
