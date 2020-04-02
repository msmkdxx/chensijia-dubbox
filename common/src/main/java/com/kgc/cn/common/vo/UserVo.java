package com.kgc.cn.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserVo implements Serializable {
    private static final long serialVersionUID = 8170641275090244395L;
    private Long id;
    private String name;
    private String password;
    private String phone;
    private String nickname;
    private Long score;
    private Date createtime;
}
