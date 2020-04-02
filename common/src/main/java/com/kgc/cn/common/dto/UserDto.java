package com.kgc.cn.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = -1954697001025353271L;
    private int id;
    private String name;
    private int sex;
}
