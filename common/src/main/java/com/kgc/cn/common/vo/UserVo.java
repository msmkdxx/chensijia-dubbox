package com.kgc.cn.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {
    private static final long serialVersionUID = 8170641275090244395L;
    private int id;
    private String name;
    private int sex;
}
