package com.quadfour.dao;
import com.quadfour.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAO implements IUserDAO{

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO findById(int userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public UserDTO findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
