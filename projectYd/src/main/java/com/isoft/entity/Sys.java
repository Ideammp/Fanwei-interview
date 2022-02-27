package com.isoft.entity;

import lombok.Data;

@Data
public class Sys {


    private Integer id;
    private String name,password,photourl,mobile,email;
    private Integer role,state;


}
