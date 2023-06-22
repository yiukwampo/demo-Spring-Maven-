package com.noticeboard.demo.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.PathVariable;

import com.entity.Blog;
import com.noticeboard.repository.BlogRepository;

@Service
public class BlogService {

    private final Logger logger = LoggerFactory.getLogger(BlogService.class);

    //private final BlogRepository blogRepository;

    //public BlogService(BlogRepository _blogRepository) {
    //    this.blogRepository = _blogRepository;
    //}

    //@Transactional(readOnly = true)
    //public Optional<Blog> findContentByWindowId(@PathVariable Long windowId) {
    //    return blogRepository.findById(windowId);
    //}
    
}
    