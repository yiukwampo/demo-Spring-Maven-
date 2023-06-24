package com.noticeboard.demo.entity;
import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_post")
    private String userPost;

    @Column(name = "surname_chi")
    private String surnameChi;

    @Column(name = "firstname_chi")
    private String firstnameChi;

    @Column(name = "create_user")
    private String createUser;
    
    @Column(name = "create_date")
    private Timestamp createDate;
 
    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_date")
    private Timestamp updateDate;
    
}
