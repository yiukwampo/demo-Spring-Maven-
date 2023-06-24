package com.noticeboard.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.noticeboard.demo.entity.Blog;
import com.noticeboard.demo.service.BlogService;
import org.springframework.context.annotation.Bean;

@CrossOrigin
@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping("/hello")
    public String hello() {

        return "Spring Boot 碩網資訊世界";

    }

   @RequestMapping("/getAllBlogMessage")
   public ResponseEntity<Iterable<Blog>> getAllBlogMessage() {
        return ResponseEntity.ok(blogService.getAllBlogMessage());
   }

   @RequestMapping("/getContentByMessageId/{messageId}")
   public ResponseEntity<Blog> getContentByMessageId(@PathVariable Long messageId) {
       Optional<Blog> blogOp = blogService.findContentByMessageId(messageId);
       if (blogOp.isPresent()) {
           return ResponseEntity.ok(blogOp.get());
       }
       return ResponseEntity.ok(null);
   }

   @PostMapping("/createBlogMessage")
   private ResponseEntity<Boolean> createBlogMessage(@RequestBody Blog blog) {
       Blog savedBlog = blogService.createBlogMessage(blog);
       return ResponseEntity.ok(savedBlog.getMessageId() != null);
   }

   @PostMapping("/updateBlogMessage")
   private ResponseEntity<Boolean> updateBlogMessage(@RequestBody Blog blog) {
       Blog savedBlog = blogService.updateBlogMessage(blog);
       return ResponseEntity.ok(savedBlog.getMessageId() != null);
   }
    
}
