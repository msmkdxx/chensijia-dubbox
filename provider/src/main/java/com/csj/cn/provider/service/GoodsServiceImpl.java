package com.csj.cn.provider.service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.csj.cn.common.dto.Goods;
import com.csj.cn.common.dto.GoodsExample;
import com.csj.cn.common.service.GoodsService;
import com.csj.cn.common.utils.PageUtils;
import com.csj.cn.common.vo.GoodsVo;
import com.csj.cn.provider.mapper.GoodsMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/711:40
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public boolean selectCount(Long goodId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodId);
        if (goods.getCount() > 0) return true;

        return false;
    }

    @Override
    public boolean addGoods(GoodsVo goodsVo) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsVo, goods);
        try {
            goodsMapper.insertSelective(goods);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public PageUtils<List<Goods>> selectGoods(String searchStr, int pageNo, int pageSize) {
        GoodsExample goodsExample = new GoodsExample();
        PageUtils pageUtils = new PageUtils();
        pageUtils.setCurrentPage(pageNo);
        //将pageNo转为limit
        pageUtils.setPageNo(pageNo);
        goodsExample.setLimit(pageUtils.getPageNo());
        goodsExample.setOffset(pageSize);
        //模糊查询
        goodsExample.createCriteria().andNameLike(searchStr);
        try {
            List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
            if (CollectionUtils.isNotEmpty(goodsList)) {
                pageUtils.setCurrentList(goodsList);
                pageUtils.setTotalCount(goodsMapper.countByExample(goodsExample));
                return pageUtils;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
