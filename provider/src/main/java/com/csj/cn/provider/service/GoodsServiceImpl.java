package com.csj.cn.provider.service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.csj.cn.common.dto.Goods;
import com.csj.cn.common.dto.GoodsExample;
import com.csj.cn.common.service.GoodsService;
import com.csj.cn.common.utils.PageUtils;
import com.csj.cn.common.vo.GoodsVo;
import com.csj.cn.provider.mapper.GoodsMapper;
import com.google.common.collect.Maps;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/711:40
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

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
    public List<Goods> showGoodsList(String searchStr, int pageNo, int pageSize) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setLimit(pageNo);
        goodsExample.setOffset(pageSize);
        //模糊查询
        if (StringUtils.isNotEmpty(searchStr)) {
            goodsExample.createCriteria().andNameLike('%' + searchStr + '%');
        }
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        return goodsList;
    }

    @Override
    public Map showGoodsListMap(String searchStr, int pageNo, int pageSize) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setLimit(pageNo);
        goodsExample.setOffset(pageSize);
        //模糊查询
        if (StringUtils.isNotEmpty(searchStr)) {
            goodsExample.createCriteria().andNameLike('%' + searchStr + '%');
        }
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        long counts = goodsMapper.countByExample(goodsExample);
        Map<String, Object> goodsListMap = Maps.newHashMap();
        goodsListMap.put("currentList", goodsList);
        goodsListMap.put("totalCount", counts);
        return goodsListMap;
    }

    @Override
    public Goods selectByPrimaryKey(String goodId) {
        try {
            return goodsMapper.selectByPrimaryKey(goodId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
