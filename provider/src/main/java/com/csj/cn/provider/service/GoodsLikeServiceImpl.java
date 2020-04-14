package com.csj.cn.provider.service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.csj.cn.common.dto.Goods;
import com.csj.cn.common.dto.GoodsLike;
import com.csj.cn.common.dto.GoodsLikeExample;
import com.csj.cn.common.service.GoodsLikeService;
import com.csj.cn.common.utils.RedisUtils;
import com.csj.cn.provider.mapper.GoodsLikeMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/1416:24
 */
@Service
@Transactional
public class GoodsLikeServiceImpl implements GoodsLikeService {
    @Autowired
    private GoodsLikeMapper goodsLikeMapper;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean islike(long userId, String goodId) {
        GoodsLikeExample goodsLikeExample = new GoodsLikeExample();
        goodsLikeExample.createCriteria().andGoodIdEqualTo(goodId).andUserIdEqualTo(userId);
        List<GoodsLike> goodsLikeList = goodsLikeMapper.selectByExample(goodsLikeExample);
        if(CollectionUtils.isNotEmpty(goodsLikeList)){
            return goodsLikeList.stream().mapToInt(GoodsLike::getStatus).sum() > 0;
        }
        return false;
    }

    @Override
    public void insertGoodsLike(GoodsLike goodsLike) {
        goodsLikeMapper.truncateTable();
        goodsLikeMapper.insertSelective(goodsLike);
    }

}
