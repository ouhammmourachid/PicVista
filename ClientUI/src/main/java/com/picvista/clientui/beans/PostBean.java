package com.picvista.clientui.beans;

import lombok.Data;

import java.util.List;

@Data
public class PostBean {
    private Long ImageId;
    private String path;
    private List<String> comments;
    private Long Likes;
    private String userName;

}
