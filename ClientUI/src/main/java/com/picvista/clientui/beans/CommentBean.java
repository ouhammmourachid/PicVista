package com.picvista.clientui.beans;

import lombok.Data;

import java.util.Date;


@Data
public class CommentBean {

    private Long commentId;
    private Long commentWriterId;
    private Long imageId;
    private Date commentDate;
    private String commentText;
}
