package com.csj.cn.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUser implements Serializable {
    private static final long serialVersionUID = 4903584473786182136L;
    private Long id;
    private String name;
    private String password;
    private String phone;
    private Integer sex;
    private Long score;

    private String openid;
    private String nickname;
    private String city;
    private String province;
    private String country;
    private String headimgurl;
}
