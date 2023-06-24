package com.noticeboard.demo.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "title")
    private String title;

    @Column(name = "announce_content")
    private String announceContent;

    @Column(name = "announce_date")
    private LocalDate announceDate;
    
    @Transient
    private String announceDateStr;
 
    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Transient
    private String expiryDateStr;
    
}
