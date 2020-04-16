package com.csj.cn.common.service;

import com.csj.cn.common.dto.Goods;
import com.csj.cn.common.vo.GoodsVo;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    /**
     * 添加商品
     *
     * @param goodsVo
     * @return
     */
    boolean addGoods(GoodsVo goodsVo);

    /**
     * 查询商品列表
     *
     * @param searchStr
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Goods> showGoodsList(String searchStr, int pageNo, int pageSize);

    /**
     * 返回商品列表并封装为Map
     *
     * @param searchStr
     * @param pageNo
     * @param pageSize
     * @return
     */
    Map showGoodsListMap(String searchStr, int pageNo, int pageSize);

    /**
     * 查询商品详情
     *
     * @param goodId
     * @return
     */
    Goods selectByPrimaryKey(String goodId);

    Goods selectGood();

}
