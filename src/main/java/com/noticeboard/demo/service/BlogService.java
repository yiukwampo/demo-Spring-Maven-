package com.noticeboard.demo.service;

import java.util.Arrays;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.noticeboard.demo.entity.Blog;
import com.noticeboard.demo.repository.BlogRepository;

import io.micrometer.common.util.StringUtils;


@Service
public class BlogService {

     //private BlogRepository blogRepository;
//
     //public BlogService(BlogRepository _blogRepository) { 
     //   this.blogRepository = _blogRepository;
     //}
    private final Logger logger = LoggerFactory.getLogger(BlogService.class);

     @Autowired
     BlogRepository blogRepository;

     public Optional<Blog> findContentByMessageId(Long messageId) {
        Optional<Blog> BlogOp = blogRepository.findById(messageId);
        return BlogOp;
     }

     @Transactional
     public Iterable<Blog> getAllBlogMessage() {
          return blogRepository.findAll();
     }

     @Transactional
     public Blog createBlogMessage(Blog blog) {

          Blog blogNew = new Blog();
          blogNew.setTitle(blog.getTitle());  
          blogNew.setAnnounceContent(blog.getAnnounceContent());     
          if (blog.getAnnounceDateStr() != null) {
               LocalDate dt = LocalDate.parse(blog.getAnnounceDateStr(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
               blogNew.setAnnounceDate(dt);
          }
          if (blog.getExpiryDateStr() != null) {
               LocalDate dt = LocalDate.parse(blog.getExpiryDateStr(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
               blogNew.setExpiryDate(dt);
          }    
          Blog savedBlog = blogRepository.save(blogNew);
          return savedBlog;

	}

     @Transactional
	public Blog updateBlogMessage(Blog blog) {

		Optional<Blog> blogOp = blogRepository.findById(blog.getMessageId());
    	
          if(blogOp.isPresent()) {

               //BeanUtils.copyProperties(blog, blogOp, new String[] {"typeA", "typeB", "typeC" });
               blogOp.get().setTitle(blog.getTitle());
               blogOp.get().setAnnounceContent(blog.getAnnounceContent());       
               if (blog.getAnnounceDateStr() != null && !StringUtils.isEmpty(blog.getAnnounceDateStr())) {
                    try{
                         String s = blog.getAnnounceDateStr();
                         LocalDate dt = LocalDate.parse(String.valueOf(s), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                         blogOp.get().setAnnounceDate(dt);
                    } catch (Exception anyError) {
					 blogOp.get().setAnnounceDate(null);
				}
               } else if (StringUtils.isEmpty(blog.getAnnounceDateStr())) {
                    blogOp.get().setAnnounceDate(null);
               }
               if (blog.getExpiryDateStr() != null && !StringUtils.isEmpty(blog.getExpiryDateStr())) {
                    try{
                         LocalDate dt = LocalDate.parse(blog.getExpiryDateStr(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                         blogOp.get().setExpiryDate(dt);
                    } catch (Exception anyError) {
					 blogOp.get().setExpiryDate(null);
				}
               } else if (StringUtils.isEmpty(blog.getExpiryDateStr())) {
                    blogOp.get().setExpiryDate(null);
               }    
              Blog savedBlog = blogRepository.save(blogOp.get());
              return savedBlog;
          }
          return null;

	}

}
    