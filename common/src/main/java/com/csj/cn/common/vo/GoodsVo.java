package com.csj.cn.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/716:04
 */
@Data
public class GoodsVo implements Serializable {
    private Long goodId;
    private String name;
    private Double price;
    private String content;
    private Integer count;
}
