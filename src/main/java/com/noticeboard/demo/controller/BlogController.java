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

import com.entity.Blog;
import com.noticeboard.demo.service.BlogService;

@CrossOrigin
@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping("/hello")
    public String hello() {

        return "Spring Boot 緯創世界";

    }

   //@GetMapping("/getContentByWindowId/{windowId}")
   //public ResponseEntity<Blog> getContentByWindowId(@PathVariable Long windowId) {
   //    Optional<Blog> blogOp = blogService.findContentByWindowId(windowId);
   //    if (blogOp.isPresent()) {
   //        return ResponseEntity.ok(blogOp.get());
   //    }
   //    return ResponseEntity.ok(null);
   //}
    
}
