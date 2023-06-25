package com.noticeboard.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noticeboard.demo.dto.UserDropdownListDto;
import com.noticeboard.demo.entity.User;
import com.noticeboard.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getUserByUserId(Long userId) {
        Optional<User> userOp = userRepository.findById(userId);
        return userOp;
    }

    public Iterable<UserDropdownListDto> getUserDropdownList() {
        return userRepository.getUserDropdownList();
    }
    
}
