package com.csj.cn.common.service;

import com.csj.cn.common.dto.GoodsLike;

public interface GoodsLikeService {

    /**
     * 是否点赞(数据库)
     *
     * @param userId
     * @param goodId
     * @return
     */
    boolean islike(long userId, String goodId);

    /**
     * 将redis中的点赞记录存入数据库
     *
     * @param goodsLike
     */
    void insertGoodsLike(GoodsLike goodsLike);
}
