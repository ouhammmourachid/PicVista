package com.picvista.clientui.beans;

import lombok.Data;

import java.util.Date;

@Data
public class LikeBean {

    private Long id;
    private int userId;
    private int imageId;
    private Date date;
}
