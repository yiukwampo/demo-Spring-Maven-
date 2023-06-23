package com.noticeboard.demo.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.noticeboard.demo.entity.Blog;
import com.noticeboard.demo.repository.BlogRepository;


@Service
public class BlogService {

     //private BlogRepository blogRepository;
//
     //public BlogService(BlogRepository _blogRepository) { 
     //   this.blogRepository = _blogRepository;
     //}

     @Autowired
     BlogRepository blogRepository;

     public Optional<Blog> findContentByWindowId(Long windowId) {
        Optional<Blog> BlogOp = blogRepository.findById(windowId);
        return BlogOp;
     }

}
    