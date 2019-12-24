package com.vicmob.shoppingmall.web.goodsAPI.service;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.utils.DecryptUtils;
import com.vicmob.shoppingmall.web.distribution.entity.CommissionRecord;
import com.vicmob.shoppingmall.web.distribution.service.CommissionRecordService;
import com.vicmob.shoppingmall.web.goods.entity.*;
import com.vicmob.shoppingmall.web.goodsAPI.dao.*;
import com.vicmob.shoppingmall.web.goodsAPI.entity.*;
import com.vicmob.shoppingmall.web.goodsAPI.model.*;
import com.vicmob.shoppingmall.web.goodsAPI.wxclient.WXMessageClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class PersonCenterService {

    @Autowired
    private MallOrderMapper mallOrderMapper;
    @Autowired
    private MallOrderAddressMapper mallOrderAddressMapper;
    @Autowired
    private MallSpecificationMapper mallSpecificationMapper;
    @Autowired
    private WXMessageClient wxMessageClient;
    @Autowired
    private CommissionRecordService commissionRecordService;
    @Autowired
    private MallGoodsCollageMapper mallGoodsCollageMapper;

    public List<MallOrderVO> getOrderList(OrderQueryVO vo) {
        PageHelper.startPage(vo.getPage().getPageIndex(), vo.getPage().getPageSize());
        Page<MallOrderVO> list = mallOrderMapper.getOrderList(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())),vo.getCustomerId(),vo.getOrderstatus());
        if(vo.getPage()!= null) {
            vo.getPage().setTotal(list.getTotal());
        }
        return list.getResult();
    }

    public MallOrderVO getOrderDetail(Integer orderId) {
        return mallOrderMapper.getOrderDetail(orderId);
    }

    public Order getMallOrderDetail(Integer orderId) {
        return mallOrderMapper.getMallOrderDetail(orderId);
    }

    public int updateOrderStatus(OrderUpdateVO vo) {
        Order order = mallOrderMapper.getMallOrderDetail(vo.getOrderId());
        order.setOrderStatus(Constant.OrderType.getEnumOrderType(vo.getOrderstatus()));
        List<GoodsDetail> goodsDetailList = JSONObject.parseArray(order.getGoodsDetails(), GoodsDetail.class);
        MallOrderWithBLOBs record = new MallOrderWithBLOBs();
        switch (vo.getOrderstatus()){
            case 2:
                record.setOrderendtime(new Date());
                break;
            case 4:
                if(StringUtils.isNotEmpty(order.getCollageNo())){
                    mallGoodsCollageMapper.updateCollageStatusByCustomerId(order.getCollageNo(),order.getCustomerId());
                }
                if(StringUtils.isNotEmpty(vo.getCancelReason())) {
                    record.setCancelreason(vo.getCancelReason());
                }
                if(StringUtils.isEmpty(order.getCollageNo())) {
                    goodsDetailList.forEach(goodsDetail -> {
                        //更新库存
                        MallSpecification spcification = mallSpecificationMapper.selectByPrimaryKey(goodsDetail.getSpecId());
                        if (spcification != null && spcification.getStock() != -1) {
                            MallSpecification mallSpecification = new MallSpecification();
                            mallSpecification.setSpecid(goodsDetail.getSpecId());
                            mallSpecification.setStock(spcification.getStock() + goodsDetail.getNum());
                            mallSpecificationMapper.updateByPrimaryKeySelective(mallSpecification);
                        }
                    });
                }
                break;
            case 5:
                if(StringUtils.isNotEmpty(vo.getDrawbackReason())) {
                    record.setDrawbackreason(vo.getDrawbackReason());
                }
                record.setOrderrefundtime(new Date());
                break;
            default :
                break;
        }
        record.setOrderid(vo.getOrderId());
        record.setOrderstatus(vo.getOrderstatus());
        int result = mallOrderMapper.updateByPrimaryKeySelective(record);
        if(vo.getOrderstatus() == 2){
            commissionRecordService.updateCommissionRecord(order);
        }
        wxMessageClient.sendMessage(order);
        return result;
    }

    public int delOrder(OrderUpdateVO vo) {
        MallOrderWithBLOBs record = new MallOrderWithBLOBs();
        record.setOrderid(vo.getOrderId());
        record.setDeleteflag(1);
        int result = mallOrderMapper.updateByPrimaryKeySelective(record);
        return result;
    }

    public List<MallOrderAddress> getOrderAddressList(OrderQueryVO vo) {
        PageHelper.startPage(vo.getPage().getPageIndex(), vo.getPage().getPageSize());
        MallOrderAddressExample example = new MallOrderAddressExample();
        MallOrderAddressExample.Criteria criteria = example.createCriteria();
        criteria.andCustomeridEqualTo(vo.getCustomerId());
        criteria.andMinaidEqualTo(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        criteria.andDeleteflagEqualTo(0);
        example.setOrderByClause("isDefault desc,createDate desc");
        Page<MallOrderAddress> list =(Page<MallOrderAddress>) mallOrderAddressMapper.selectByExample(example);
        if(vo.getPage()!= null) {
            vo.getPage().setTotal(list.getTotal());
        }
        return list.getResult();
    }

    public MallOrderAddress getOrderAddressDetail(Integer addressId) {
        return mallOrderAddressMapper.getOrderAddressDetail(addressId);
    }

    public int setDefaultAddress(CustomerUpdateVO vo) {
        vo.setMinaId(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        return mallOrderAddressMapper.setDefaultAddress(vo);
    }

    public int addOrderAddress(MallOrderAddressVO vo) {
        MallOrderAddress address = Convert.convert(MallOrderAddress.class,vo);
        address.setDeleteflag(0);
        address.setCreatedate(new Date());
        address.setMinaid(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        return mallOrderAddressMapper.insertSelective(address);
    }

    public int editOrderAddress(MallOrderAddressVO vo) {
        MallOrderAddress address = Convert.convert(MallOrderAddress.class,vo);
        address.setMinaid(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        return mallOrderAddressMapper.updateByPrimaryKeySelective(address);
    }

    public int delOrderAddress(Integer addressId) {
        MallOrderAddress address = new MallOrderAddress();
        address.setAddressid(addressId);
        address.setDeleteflag(1);
        return mallOrderAddressMapper.updateByPrimaryKeySelective(address);
    }

    public MallOrderAddress getShowAddress(OrderQueryVO vo){
        MallOrderAddressExample example = new MallOrderAddressExample();
        MallOrderAddressExample.Criteria criteria = example.createCriteria();
        criteria.andCustomeridEqualTo(vo.getCustomerId());
        criteria.andMinaidEqualTo(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        criteria.andDeleteflagEqualTo(0);
        example.setOrderByClause("createDate desc");
        List<MallOrderAddress> list = mallOrderAddressMapper.selectByExample(example);
        if(list==null||list.isEmpty()){
            log.error("用户没有收货地址");
            return null;
        }else{
            for(int i=0;i<list.size();i++){
                if(list.get(i).getIsdefault()==1){
                    return list.get(i);
                }
            }
            return list.get(0);
        }
    }

}
