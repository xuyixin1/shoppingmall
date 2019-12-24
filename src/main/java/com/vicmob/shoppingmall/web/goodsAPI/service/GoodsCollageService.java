package com.vicmob.shoppingmall.web.goodsAPI.service;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vicmob.shoppingmall.web.goods.entity.GoodsDetail;
import com.vicmob.shoppingmall.web.goods.entity.Order;
import com.vicmob.shoppingmall.web.goodsAPI.dao.*;
import com.vicmob.shoppingmall.web.goodsAPI.entity.*;
import com.vicmob.shoppingmall.web.goodsAPI.model.*;
import com.vicmob.shoppingmall.web.goodsAPI.wxclient.WXPayClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class GoodsCollageService {

    @Autowired
    private MallGoodsMapper mallGoodsMapper;
    @Autowired
    private MallGoodsCollageActivityMapper mallGoodsCollageActivityMapper;
    @Autowired
    private MallGoodsCollageMapper mallGoodsCollageMapper;
    @Autowired
    private MallGoodsClassifyMapper mallGoodsClassifyMapper;
    @Autowired
    private MallGoodsSecondClassifyMapper mallGoodsSecondClassifyMapper;
    @Autowired
    @Lazy
    private WXPayClient wXPayClient;
    @Autowired
    private MallOrderMapper mallOrderMapper;
    @Autowired
    @Lazy
    private GoodsOrderService goodsOrderService;
    @Autowired
    private MallSpecificationMapper mallSpecificationMapper;
    @Autowired
    private MallCustomerLimitpurchaseMapper mallCustomerLimitpurchaseMapper;


    public List<MallGoodsClassify> getAllClassify(ClassifyIdQueryVO vo) {
        return mallGoodsClassifyMapper.getAllClassify(vo.getMinaId());
    }

    public List<MallGoodsSecondClassify> getAllSecondClassifyByClassifyId(ClassifyIdQueryVO vo) {
        return mallGoodsSecondClassifyMapper.getAllSecondClassifyByClassifyId(vo.getMinaId(),vo.getClassifyId());
    }

    public List<MallGoods> getAllGoodsList(ClassifyIdQueryVO vo) {
        return mallGoodsMapper.getAllGoodsList(vo.getMinaId(),vo.getSecondClassifyId());
    }

    public List<MallGoodsClassify> getAllClassifyByEdit(ClassifyIdQueryVO vo) {
        return mallGoodsClassifyMapper.getAllClassifyByEdit(vo.getMinaId());
    }

    public List<MallGoodsSecondClassify> getAllSecondClassifyByEdit(ClassifyIdQueryVO vo) {
        return mallGoodsSecondClassifyMapper.getAllSecondClassifyByEdit(vo.getMinaId(),vo.getClassifyId());
    }

    public List<MallGoods> getAllGoodsListByEdit(ClassifyIdQueryVO vo) {
        return mallGoodsMapper.getAllGoodsListByEdit(vo.getMinaId(),vo.getSecondClassifyId());
    }

    public List<MallSpecification> getAllSpecificationByGoodsId(Integer minaId,Integer goodsId){
        return mallGoodsMapper.getAllSpecificationByGoodsId(minaId,goodsId);
    }

    public int addCollageActivity(MallGoodsCollageActivityAddVO vo) {
        int result = 0;
        MallGoodsCollageActivity activity = Convert.convert(MallGoodsCollageActivity.class,vo);
        activity.setCollageactivityid(String.valueOf(System.currentTimeMillis()));
        activity.setCreatedate(new Date());
        if (new Date().compareTo(activity.getActivitystartdate()) == -1) {
            activity.setCollageactivitystatus(0);
        }
        if (new Date().compareTo(activity.getActivityenddate()) == 1) {
            activity.setCollageactivitystatus(2);
        }
        if (new Date().compareTo(activity.getActivitystartdate()) > -1 && new Date().compareTo(activity.getActivityenddate()) < 1) {
            activity.setCollageactivitystatus(1);
            mallGoodsMapper.updateCollageFlag(vo.getGoodsid());
        }
        activity.setDeleteflag(0);
        for (MallGoodsCollageActivityParamVO paramVO : vo.getMallGoodsCollageVOList()) {
            activity.setSpecid(paramVO.getSpecId());
            activity.setCollageactivityprice(paramVO.getCollageActivityPrice());
            result += mallGoodsCollageActivityMapper.insertSelective(activity);
        }
        return result;
    }

    public int updateCollageActivity(MallGoodsCollageActivityAddVO vo) {
        int result = 0;
        MallGoodsCollageActivity activity = Convert.convert(MallGoodsCollageActivity.class,vo);
        activity.setCreatedate(new Date());
        if (new Date().compareTo(activity.getActivitystartdate()) == -1) {
            activity.setCollageactivitystatus(0);
        }
        if (new Date().compareTo(activity.getActivityenddate()) == 1) {
            activity.setCollageactivitystatus(2);
        }
        if (new Date().compareTo(activity.getActivitystartdate()) > -1 && new Date().compareTo(activity.getActivityenddate()) < 1) {
            activity.setCollageactivitystatus(1);
        }
        for (MallGoodsCollageActivityParamVO paramVO : vo.getMallGoodsCollageVOList()) {
            activity.setCollageactivityprice(paramVO.getCollageActivityPrice());
            MallGoodsCollageActivityExample example = new MallGoodsCollageActivityExample();
            MallGoodsCollageActivityExample.Criteria criteria = example.createCriteria();
            criteria.andMinaidEqualTo(vo.getMinaid());
            criteria.andSpecidEqualTo(paramVO.getSpecId());
            criteria.andGoodsidEqualTo(vo.getGoodsid());
            criteria.andCollageactivitystatusEqualTo(0);
            criteria.andDeleteflagEqualTo(0);
            result += mallGoodsCollageActivityMapper.updateByExampleSelective(activity,example);
        }
        return result;
    }

    public List<MallGoodsCollageActivityVO> getCollageActivityList(MallGoodsCollageActivityQueryVO vo){
        PageHelper.startPage(vo.getPage().getPageIndex(), vo.getPage().getPageSize());
        Page<MallGoodsCollageActivityVO> list = mallGoodsCollageActivityMapper.getCollageActivityList(vo);
        if(vo.getPage()!= null) {
            vo.getPage().setTotal(list.getTotal());
        }
        return list.getResult();
    }

    public MallGoodsCollageActivityDetailVO getCollageActivityDetail(String collageActivityId){
          return mallGoodsCollageActivityMapper.getCollageActivityDetail(collageActivityId);
    }

    public int delCollageActivity(CollageActivityIdVO vo) {
        MallGoodsCollageActivity activity = new MallGoodsCollageActivity();
        activity.setDeleteflag(1);
        MallGoodsCollageActivityExample example = new MallGoodsCollageActivityExample();
        MallGoodsCollageActivityExample.Criteria criteria = example.createCriteria();
        criteria.andCollageactivityidEqualTo(vo.getCollageActivityId());
        int result = mallGoodsCollageActivityMapper.updateByExampleSelective(activity,example);
        return result;
    }

    public List<MallGoodsCollageVO> getCollageList(MallGoodsCollageQueryVO vo){
        PageHelper.startPage(vo.getPage().getPageIndex(), vo.getPage().getPageSize());
        Page<MallGoodsCollageVO> list = mallGoodsCollageMapper.getCollageList(vo);
        if(vo.getPage()!= null) {
            vo.getPage().setTotal(list.getTotal());
        }
        return list.getResult();
    }

    public MallGoodsCollage getMallGoodsCollageByNo(String collageNo){
        return mallGoodsCollageMapper.getMallGoodsCollageByNo(collageNo);
    }

    @Async("taskExecutor")
    public void updateGoodsCollage(MallGoodsCollage mallGoodsCollage,Order order){
        MallGoodsCollage record = new MallGoodsCollage();
        record.setCollageid(mallGoodsCollage.getCollageid());
        record.setCollagestatus(1);
        record.setAlcollagepeople(mallGoodsCollage.getAlcollagepeople()+1);
        MallGoodsCollageActivityExample example = new MallGoodsCollageActivityExample();
        MallGoodsCollageActivityExample.Criteria criteria = example.createCriteria();
        criteria.andMinaidEqualTo(mallGoodsCollage.getMinaid());
        criteria.andGoodsidEqualTo(mallGoodsCollage.getGoodsid());
        criteria.andCollageactivitystatusEqualTo(1);
        example.setDistinct(true);
        List<MallGoodsCollageActivity> list = mallGoodsCollageActivityMapper.selectByExample(example);
        if(list!=null&&!list.isEmpty()){
            if((list.get(0).getCollageactivitypeople()-mallGoodsCollage.getAlcollagepeople())==1){
                record.setCollagestatus(2);
            }
        }
       int result =  mallGoodsCollageMapper.updateByPrimaryKeySelective(record);
        if(result>0){
             if(record.getCollagestatus()==2){
                 goodsOrderService.addCollageSailed(mallGoodsCollage.getCollageno());
             }
            goodsOrderService.updateGoodsStock(order);
        }
    }

    @Async("taskExecutor")
    public void addCustomerLimit(MallGoodsCollage mallGoodsCollage,Order order){
        MallCustomerLimitpurchase record = new MallCustomerLimitpurchase();
        List<GoodsDetail> list = JSONObject.parseArray(order.getGoodsDetails(),GoodsDetail.class);
        MallCustomerLimitpurchase limitpurchase = mallCustomerLimitpurchaseMapper.selectCustomerLimit(mallGoodsCollage.getCollageno(),mallGoodsCollage.getMinaid(),list.get(0).getGoodsId(),order.getCustomerId());
        if(limitpurchase ==null){
            record.setCustomerid(order.getCustomerId());
            record.setCollageactivityid(mallGoodsCollage.getCollageactivityid());
            record.setGoodsid(mallGoodsCollage.getGoodsid());
            record.setMinaid(mallGoodsCollage.getMinaid());
            record.setCreatedate(new Date());
            MallGoodsCollageActivityDetailVO vo = getCollageActivityDetail(mallGoodsCollage.getCollageactivityid());
            record.setSurplusnum(vo.getLimitedPurchase()-list.get(0).getNum());
            mallCustomerLimitpurchaseMapper.insertSelective(record);
        }else{
            record.setLimitid(limitpurchase.getLimitid());
            record.setSurplusnum(limitpurchase.getSurplusnum()-list.get(0).getNum());
            record.setCreatedate(new Date());
            mallCustomerLimitpurchaseMapper.updateByPrimaryKeySelective(record);
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public int collageActivityLose(CollageActivityIdVO vo) {
        MallGoodsCollageActivity activity = new MallGoodsCollageActivity();
        activity.setCollageactivitystatus(3);
        MallGoodsCollageActivityExample example = new MallGoodsCollageActivityExample();
        MallGoodsCollageActivityExample.Criteria criteria = example.createCriteria();
        criteria.andCollageactivityidEqualTo(vo.getCollageActivityId());
        int result = mallGoodsCollageActivityMapper.updateByExampleSelective(activity, example);
        if (result > 0) {
            MallGoods goods = new MallGoods();
            goods.setGoodsid(vo.getGoodsId());
            goods.setCollageflag(0);
            mallGoodsMapper.updateByPrimaryKeySelective(goods);
            List<Order> orderList = mallOrderMapper.selectOrderByGoodsId(vo.getMinaId(), vo.getGoodsId());
            if (orderList != null && !orderList.isEmpty()) {
                for (Order order : orderList) {
                    try {
                        wXPayClient.refund(order);
                    } catch (Exception e) {
                        log.error("退款失败,订单编号:{},原因:{}", order.getOrderNumber(), e.getMessage());
                        return 0;
                    }
                    List<GoodsDetail> goodsDetailList = JSONObject.parseArray(order.getGoodsDetails(), GoodsDetail.class);
                    goodsDetailList.forEach(goodsDetail -> {
                        MallSpecification spcification = mallSpecificationMapper.selectByPrimaryKey(goodsDetail.getSpecId());
                        if (spcification != null && spcification.getStock() != -1) {
                            MallSpecification mallSpecification = new MallSpecification();
                            mallSpecification.setSpecid(goodsDetail.getSpecId());
                            mallSpecification.setStock(spcification.getStock() + goodsDetail.getNum());
                            mallSpecificationMapper.updateByPrimaryKeySelective(mallSpecification);
                        }
                        mallGoodsMapper.updateSailed(goodsDetail.getGoodsId(), goodsDetail.getNum());
                    });
                }
            }
            mallOrderMapper.updateByGoodsId(vo.getMinaId(), vo.getGoodsId());
            mallGoodsCollageMapper.updateCollageStatus(vo.getMinaId(), vo.getGoodsId());
        }
        return result;
    }

    public Integer checkCollageEnd(String collageNo,String orderNumber) {
        int total = mallGoodsCollageMapper.checkCollageComplete(collageNo);
        if(total > 0){
            mallOrderMapper.updateByOrderNumber(orderNumber,12);
            log.info("拼团已经完成");
            return 1;
        }
        int result = mallGoodsCollageMapper.checkCollageLose(collageNo);
        if(result > 0){
            mallOrderMapper.updateByOrderNumber(orderNumber,11);
            log.info("此拼团已经失败");
            return 2;
        }
        return 0;
    }

    public boolean checkCustomerLimit(String collageNo,Integer goodsId,Integer customerId,Integer minaId,Integer num){
            MallCustomerLimitpurchase total = mallCustomerLimitpurchaseMapper.selectCustomerLimit(collageNo,minaId, goodsId,customerId);
            if (total!= null && total.getSurplusnum() < num) {
                log.info("超过剩余限购数。。。。。");
                return false;
            }
        return true;
    }

    @Async("taskExecutor")
    @Transactional(rollbackFor = Exception.class)
    public void collageActivityOvertime() {
        List<MallGoodsCollageActivity> list = mallGoodsCollageActivityMapper.selectCollageActivityOvertime();
        if (list != null && !list.isEmpty()) {
            for (MallGoodsCollageActivity activity : list) {
                MallGoodsCollageActivity record = new MallGoodsCollageActivity();
                record.setCollageactivitystatus(2);
                MallGoodsCollageActivityExample example = new MallGoodsCollageActivityExample();
                MallGoodsCollageActivityExample.Criteria criteria = example.createCriteria();
                criteria.andGoodsidEqualTo(activity.getGoodsid());
                criteria.andMinaidEqualTo(activity.getMinaid());
                int result = mallGoodsCollageActivityMapper.updateByExampleSelective(record, example);
                if (result > 0) {
                    MallGoods goods = new MallGoods();
                    goods.setGoodsid(activity.getGoodsid());
                    goods.setCollageflag(0);
                    mallGoodsMapper.updateByPrimaryKeySelective(goods);
                    List<Order> orderList = mallOrderMapper.selectOrderByGoodsId(activity.getMinaid(), activity.getGoodsid());
                    if (orderList != null && !orderList.isEmpty()) {
                        for (Order order : orderList) {
                            try {
                                wXPayClient.refund(order);
                            } catch (Exception e) {
                                log.error("退款失败,订单编号:{},原因:{}", order.getOrderNumber(), e.getMessage());
                            }
                            List<GoodsDetail> goodsDetailList = JSONObject.parseArray(order.getGoodsDetails(), GoodsDetail.class);
                            goodsDetailList.forEach(goodsDetail -> {
                                MallSpecification spcification = mallSpecificationMapper.selectByPrimaryKey(goodsDetail.getSpecId());
                                if (spcification != null && spcification.getStock() != -1) {
                                    MallSpecification mallSpecification = new MallSpecification();
                                    mallSpecification.setSpecid(goodsDetail.getSpecId());
                                    mallSpecification.setStock(spcification.getStock() + goodsDetail.getNum());
                                    mallSpecificationMapper.updateByPrimaryKeySelective(mallSpecification);
                                }
                                mallGoodsMapper.updateSailed(goodsDetail.getGoodsId(),goodsDetail.getNum());
                                mallCustomerLimitpurchaseMapper.updateSurplusNum(activity.getMinaid(),activity.getGoodsid(),activity.getCollageactivityid(),order.getCustomerId(),goodsDetail.getNum());
                            });
                        }
                    }
                    mallOrderMapper.updateByGoodsId(activity.getMinaid(), activity.getGoodsid());
                    mallGoodsCollageMapper.updateCollageStatus(activity.getMinaid(),activity.getGoodsid());
                }
            }
        }
    }

    @Async("taskExecutor")
    public void collageActivityUnStart(){
        List<MallGoodsCollageActivity> list =mallGoodsCollageActivityMapper.selectAllUnStart();
        if(list!=null&&!list.isEmpty()){
            for(MallGoodsCollageActivity activity:list){
                mallGoodsMapper.updateCollageFlagUnStart(activity.getGoodsid());
                mallGoodsCollageActivityMapper.updateCollageActivityUnStart(activity.getGoodsid(),activity.getMinaid());
            }
        }
    }

    @Async("taskExecutor")
    @Transactional(rollbackFor = Exception.class)
    public void collageOvertime() {
        List<MallGoodsCollage> list = mallGoodsCollageMapper.selectCollageOvertime();
        if (list != null && !list.isEmpty()) {
            for (MallGoodsCollage mallGoodsCollage : list) {
                MallGoodsCollage record = new MallGoodsCollage();
                record.setCollageid(mallGoodsCollage.getCollageid());
                record.setCollagestatus(3);
                int result = mallGoodsCollageMapper.updateByPrimaryKeySelective(record);
                if (result > 0) {
                    List<Order> orderList = mallOrderMapper.selectOrderByCollageNo(mallGoodsCollage.getCollageno());
                    if (orderList != null && !orderList.isEmpty()) {
                        for (Order order : orderList) {
                            try {
                                wXPayClient.refund(order);
                            } catch (Exception e) {
                                log.error("退款失败,订单编号:{},原因:{}", order.getOrderNumber(), e.getMessage());
                            }
                            List<GoodsDetail> goodsDetailList = JSONObject.parseArray(order.getGoodsDetails(), GoodsDetail.class);
                            goodsDetailList.forEach(goodsDetail -> {
                                MallSpecification spcification = mallSpecificationMapper.selectByPrimaryKey(goodsDetail.getSpecId());
                                if (spcification != null && spcification.getStock() != -1) {
                                    MallSpecification mallSpecification = new MallSpecification();
                                    mallSpecification.setSpecid(goodsDetail.getSpecId());
                                    mallSpecification.setStock(spcification.getStock() + goodsDetail.getNum());
                                    mallSpecificationMapper.updateByPrimaryKeySelective(mallSpecification);
                                }
                                mallCustomerLimitpurchaseMapper.updateSurplusNum(mallGoodsCollage.getMinaid(),mallGoodsCollage.getGoodsid(),mallGoodsCollage.getCollageactivityid(),order.getCustomerId(),goodsDetail.getNum());
                            });
                        }
                        mallOrderMapper.updateOrderByCollageNo(mallGoodsCollage.getCollageno(), 3);
                    }
                }
            }
        }
    }

    public int delCollageActivityBySpecId(List<Integer> specIds) {
        MallGoodsCollageActivity activity = new MallGoodsCollageActivity();
        activity.setDeleteflag(1);
        MallGoodsCollageActivityExample example = new MallGoodsCollageActivityExample();
        MallGoodsCollageActivityExample.Criteria criteria = example.createCriteria();
        criteria.andSpecidIn(specIds);
        List<Integer> values = new ArrayList<>();
        values.add(0);
        values.add(1);
        criteria.andCollageactivitystatusIn(values);
        criteria.andDeleteflagEqualTo(0);
        int result = mallGoodsCollageActivityMapper.updateByExampleSelective(activity,example);
        return result;
    }
}
