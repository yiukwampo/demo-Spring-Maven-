package com.noticeboard.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.noticeboard.demo.entity.User;


public interface UserRepository extends CrudRepository<User, Long> {
    
}
