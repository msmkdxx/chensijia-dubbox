package com.csj.cn.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrdersVo implements Serializable {
    private static final long serialVersionUID = -7053496447027124821L;
    private String orderId;
    private Double num;
    private String phone;
    private String goodId;
    private Integer state;
    private Integer isPay;
    private Date createddate;
}