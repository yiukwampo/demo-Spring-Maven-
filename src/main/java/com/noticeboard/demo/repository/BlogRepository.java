package com.noticeboard.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.noticeboard.demo.entity.Blog;

public interface BlogRepository extends CrudRepository<Blog, Long> {

    
}
