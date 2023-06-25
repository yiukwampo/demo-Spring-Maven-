package com.noticeboard.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class UserDropdownListDto {

    private Long userId;

    private String userPost;
    
}
