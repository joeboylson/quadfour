package com.quadfour.service;
import com.quadfour.dao.IUserDAO;
import com.quadfour.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Override
    public UserDTO findById(int userId) {
        return userDAO.findById(userId);
    }

    @Override
    public UserDTO findByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}
