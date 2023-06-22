package com.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "blog")
public class Blog {

    @Id
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
