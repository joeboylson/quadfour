package com.quadfour.service;

import com.quadfour.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    UserDTO findByUsername(String username);
    UserDTO findById(int userId);
}