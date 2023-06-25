package com.noticeboard.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.noticeboard.demo.dto.UserDropdownListDto;
import com.noticeboard.demo.entity.User;


public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT new com.noticeboard.demo.dto.UserDropdownListDto(b.userId, b.userPost)  " +
			       "FROM User b ")
	Iterable<UserDropdownListDto> getUserDropdownList();
    
}
