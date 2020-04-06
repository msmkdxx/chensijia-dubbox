package com.csj.cn.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginUser implements Serializable {
    private static final long serialVersionUID = 4903584473786182136L;
    private Long id;
    private String name;
    private String password;
    private String phone;
    private String nickname;
    private Long score;
    private Date createtime;
}
