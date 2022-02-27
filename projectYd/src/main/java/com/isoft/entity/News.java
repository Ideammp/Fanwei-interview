package com.isoft.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
public class News implements Serializable {

    private Integer id , typeid;
    private String title, content;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM--dd HH:mm:ss" , timezone = "Asia/Shanghai")
    private Date publishdt;
    private String comefrom;
    private Integer addTop;

}
