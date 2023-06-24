package com.noticeboard.demo.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.noticeboard.demo.entity.User;
import com.noticeboard.demo.service.UserService;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getUserByUserId/{userId}")
    public ResponseEntity<User> getUserByUserId(@PathVariable Long userId) {
        Optional<User> userOp = userService.getUserByUserId(userId);
        if (userOp.isPresent()) {
            return ResponseEntity.ok(userOp.get());
        }
        return ResponseEntity.ok(null);
    }
    
}
