package com.noticeboard.repository;

import org.springframework.data.repository.CrudRepository;

import com.entity.Blog;

public interface BlogRepository extends CrudRepository<Blog, Long> {
    
}
