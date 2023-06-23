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
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "window_id")
    private Long windowId;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "announce_content")
    private String announceContent;

    @Column(name = "announce_date")
    private Timestamp announceDate;

    @Column(name = "expiry_date")
    private Timestamp expiryDate;


    
}
