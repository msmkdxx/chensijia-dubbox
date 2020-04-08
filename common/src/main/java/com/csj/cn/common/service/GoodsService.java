package com.csj.cn.common.service;

import com.csj.cn.common.dto.Goods;
import com.csj.cn.common.utils.PageUtils;
import com.csj.cn.common.vo.GoodsVo;

import java.util.List;

public interface GoodsService {
    /**
     * 查看商品是否有库存
     * @param goodId
     * @return
     */
    boolean selectCount(Long goodId);
    /**
     * 添加商品
     * @param goodsVo
     * @return
     */
    boolean addGoods(GoodsVo goodsVo);

    /**
     * 查询商品列表
     * @param searchStr
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageUtils selectGoods(String searchStr, int pageNo, int pageSize);

    /**
     * 查询商品详情
     * @param goodId
     * @return
     */
    Goods selectByPrimaryKey(Long goodId);

}
