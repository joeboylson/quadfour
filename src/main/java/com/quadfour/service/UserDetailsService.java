package com.quadfour.service;

import com.quadfour.UserPrincipal;
import com.quadfour.dao.UserRepository;
import com.quadfour.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = this.userRepository.findByUsername(username);
        if(null==user) {
            throw new UsernameNotFoundException("Cannot find username: " + username);
        }
        return new UserPrincipal(user);
    }
}
