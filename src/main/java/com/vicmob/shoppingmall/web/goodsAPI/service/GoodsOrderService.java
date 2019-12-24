package com.vicmob.shoppingmall.web.goodsAPI.service;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.*;
import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.utils.*;
import com.vicmob.shoppingmall.web.goods.entity.GoodsDetail;
import com.vicmob.shoppingmall.web.goods.entity.Order;
import com.vicmob.shoppingmall.web.goods.service.OrderService;
import com.vicmob.shoppingmall.web.goodsAPI.dao.*;
import com.vicmob.shoppingmall.web.goodsAPI.entity.*;
import com.vicmob.shoppingmall.web.goodsAPI.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class GoodsOrderService {

    @Autowired
    private MallSpecificationMapper mallSpecificationMapper;
    @Autowired
    private MallGoodsMapper mallGoodsMapper;
    @Autowired
    private MallEvaluateMapper mallEvaluateMapper;
    @Autowired
    private MallOrderMapper mallOrderMapper;
    @Autowired
    private MallGoodsCartMapper mallGoodsCartMapper;
    @Autowired
    private MallGoodsCollageMapper mallGoodsCollageMapper;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${qrcode.url}")
    private String url;

    public MallGoodsVO getGoodsDetail(GoodsIdVO vo){
        MallGoodsVO mallGoodVO = mallGoodsMapper.queryGoodsByKey(vo.getGoodsId(),vo.getCustomerId());
        if(mallGoodVO==null){
            log.error("未查询到相关商品！");
            return null;
        }
        String qrCode =  RestTemplateUtil.post(new HttpHeaders(),JacksonUtil.objToJson(new EmployIdVO(vo.getGoodsId(),vo.getEmployeeId(),vo.getCustomerId())),url,restTemplate);
        if(StringUtils.isNotEmpty(qrCode)) {
            mallGoodVO.setQrCode(qrCode);
        }
        List<MallEvaluateVO> mallEvaluateVOList = mallEvaluateMapper.selectMallEvaluateList(vo.getGoodsId(),Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())),vo.getCustomerId());
        if(mallEvaluateVOList!=null&&!mallEvaluateVOList.isEmpty()) {
            mallGoodVO.setMallEvaluateNum(mallEvaluateVOList.size());
            mallGoodVO.setMallEvaluate(mallEvaluateVOList.get(0));
        }
        List<MallGoodsCollageParamVO> mallGoodsCollageParamVOList = mallGoodsCollageMapper.getCollageByGoodsId(vo.getGoodsId(),Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        if(mallGoodsCollageParamVOList!=null&&!mallGoodsCollageParamVOList.isEmpty()) {
            mallGoodVO.setMallGoodsCollageParamVOList(mallGoodsCollageParamVOList);
        }
        return mallGoodVO;
    }

    public MallGoodsCollageDetailVO getGoodsCollageDetail(Integer collageId){
      return  mallGoodsCollageMapper.getGoodsCollageDetail(collageId);
    }


    public GoodsSpecsListVO getGoodsSpecs(GoodsIdVO vo) {
        GoodsSpecsListVO goodsSpecsListVO = new GoodsSpecsListVO();
        List<AttributeId1VO> attributeId1VOList = mallSpecificationMapper.selectGoodsSpecs1(vo.getGoodsId(),Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        List<AttributeId2VO> attributeId2VOList = mallSpecificationMapper.selectGoodsSpecs2(vo.getGoodsId(),Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        if(attributeId1VOList!=null&&!attributeId1VOList.isEmpty()){
            goodsSpecsListVO.setAttributeId1VOList(attributeId1VOList);
        }else{
            goodsSpecsListVO.setAttributeId1VOList(new ArrayList<>());
        }
        if(attributeId2VOList!=null&&!attributeId2VOList.isEmpty()){
            goodsSpecsListVO.setAttributeId2VOList(attributeId2VOList);
        }else{
            goodsSpecsListVO.setAttributeId2VOList(new ArrayList<>());
        }
        return goodsSpecsListVO;
    }


    public GoodsSpecsVO getGoodsStock(GoodsSpecsQueryVO vo) {
        GoodsSpecsVO goodsSpecsVO = mallSpecificationMapper.getGoodsSpecs(vo.getGoodsId(),Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())),vo.getAttributeValueName1(),vo.getAttributeValueName2(),vo.getCollageFlag());
        if(goodsSpecsVO==null){
            goodsSpecsVO = new GoodsSpecsVO();
        }
        MallSpecificationExample example = new MallSpecificationExample();
        MallSpecificationExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsidEqualTo(vo.getGoodsId());
        criteria.andMinaidEqualTo(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        if(StringUtils.isNotEmpty(vo.getAttributeValueName1())){
            criteria.andAttributevaluename1EqualTo(vo.getAttributeValueName1());
        }
        if(StringUtils.isNotEmpty(vo.getAttributeValueName2())){
            criteria.andAttributevaluename2EqualTo(vo.getAttributeValueName2());
        }
        List<MallSpecification> list = mallSpecificationMapper.selectByExample(example);
        if(list!=null&&!list.isEmpty()){
            goodsSpecsVO.setMallSpecificationList(list);
        }else{
            goodsSpecsVO.setMallSpecificationList(new ArrayList<>());
        }
        return goodsSpecsVO;
    }


    public Integer checkMallGoods(GoodsIdVO vo){
        MallGoods goods = mallGoodsMapper.selectByPrimaryKey(vo.getGoodsId());
         if(goods.getSaleflag()==0){
             log.error("商品已经下架！！！");
             return 1;
         }
         if(goods.getDeleteflag()==1){
             log.error("商品已经删除！！！");
             return 2;
         }
         return 0;
    }


    public int checkCollageUsed(Integer goodsId,Integer customerId){
        return mallGoodsMapper.checkCollageUsed(goodsId,customerId);
    }

    public MallEvaluateAllVO getGoodsAllEvaluate(GoodsIdVO vo){
        MallEvaluateAllVO mallEvaluateAllVO = new MallEvaluateAllVO();
        MallEvaluateNumVO evluateNum = mallEvaluateMapper.selectEvaluateNum(vo.getGoodsId(),Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())),vo.getCustomerId());
        mallEvaluateAllVO.setEvluateNum(evluateNum);
        PageHelper.startPage(vo.getPage().getPageIndex(), vo.getPage().getPageSize());
        Page<MallEvaluateVO> mallEvaluateVOList =  mallEvaluateMapper.selectMallEvaluateListByType(vo.getGoodsId(),Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())),vo.getEvaluateType(),vo.getCustomerId());
        if(vo.getPage()!= null) {
            vo.getPage().setTotal(mallEvaluateVOList.getTotal());
        }
        mallEvaluateAllVO.setPage(vo.getPage());
        mallEvaluateAllVO.setMallEvaluateVOlist(mallEvaluateVOList);
        return mallEvaluateAllVO;
    }

    public int evaluateOrder(MallEvaluateAddVO vo){
        int result=0;
        for(MallEvaluateParamsVO mallEvaluateParamsVO:vo.getMallEvaluateParamsVOList()){
            MallEvaluate evaluate = mallGoodsMapper.getgoodsInfoByOrerId(mallEvaluateParamsVO.getGoodsid());
            evaluate.setSpecid(mallEvaluateParamsVO.getSpecId());
            evaluate.setCustomerid(vo.getCustomerId());
            evaluate.setEvalcontent(mallEvaluateParamsVO.getEvalcontent());
            evaluate.setEvallevel(mallEvaluateParamsVO.getEvallevel());
            evaluate.setEvalpic(mallEvaluateParamsVO.getEvalpic());
            evaluate.setEvaltime(new Date());
            evaluate.setDeleteflag(0);
            evaluate.setOrderid(vo.getOrderid());
            evaluate.setIsanonymous(mallEvaluateParamsVO.getIsanonymous());
            result+= mallEvaluateMapper.insertSelective(evaluate);
        };
        if(result>0){
            log.info("订单商品评价成功！");
            MallOrderWithBLOBs record = new MallOrderWithBLOBs();
            record.setOrderid(vo.getOrderid());
            record.setIsevaluate(1);
            mallOrderMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer CreateOrder(PayOrderVO vo){
        List<GoodsDetail> list = JSONObject.parseArray(vo.getGoodsDetails(), GoodsDetail.class);
        MallOrderWithBLOBs record = new MallOrderWithBLOBs();
        record.setOrdernumber(vo.getOrderNumber());
        record.setCustomerid(vo.getCustomerId());
        record.setMinaid(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        record.setPaytype(0);
        record.setOrderstatus(0);
        record.setIsevaluate(0);
        record.setDeleteflag(0);
        record.setDistributionuser(vo.getDistributionUser());
        record.setDeliverymoney(vo.getDeliveryMoney());
        record.setAddressdetails(vo.getAddressDetails());
        record.setGoodsdetails(vo.getGoodsDetails());
        record.setTotalmoney(vo.getTotalMoney());
        record.setRemarks(vo.getRemarks());
        record.setOrderstarttime(new Date());
        record.setEmployeeid(vo.getEmployeeId());
        record.setFormid(vo.getFormId());
        if(vo.getCollageFlag()==1) {
            if(StringUtils.isEmpty(vo.getCollageNo())) {
                record.setCollageno(getCollageNo());
                MallGoodsCollage mallGoodsCollage = new MallGoodsCollage();
                mallGoodsCollage.setCollageactivityid(vo.getCollageActivityId());
                mallGoodsCollage.setMinaid(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
                mallGoodsCollage.setCustomerid(vo.getCustomerId());
                mallGoodsCollage.setCollagestartdate(new Date());
                mallGoodsCollage.setGoodsid(list.get(0).getGoodsId());
                mallGoodsCollage.setCollageno(record.getCollageno());
                mallGoodsCollage.setGoodsname(list.get(0).getGoodsName());
                mallGoodsCollage.setAlcollagepeople(0);
                mallGoodsCollage.setCollagestatus(0);
                mallGoodsCollageMapper.insertSelective(mallGoodsCollage);
            }else{
                record.setCollageno(vo.getCollageNo());
            }
        }
        mallOrderMapper.insertSelective(record);
         list.forEach(goodsDetail->{
             if("1".equals(vo.getType())){
                 MallGoodsCart mallGoodsCart = new MallGoodsCart();
                 mallGoodsCart.setDeleteflag(1);
                 MallGoodsCartExample example = new MallGoodsCartExample();
                 MallGoodsCartExample.Criteria criteria = example.createCriteria();
                 criteria.andCustomeridEqualTo(vo.getCustomerId());
                 criteria.andMinaidEqualTo(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
                 criteria.andGoodsidIn(vo.getGoodsIdList());
                 criteria.andSpecidEqualTo(goodsDetail.getSpecId());
                 mallGoodsCartMapper.updateByExampleSelective(mallGoodsCart,example);
             }
             if(vo.getCollageFlag()==0) {
                 MallSpecification spcification = mallSpecificationMapper.selectByPrimaryKey(goodsDetail.getSpecId());
                 if (spcification != null && spcification.getStock() != -1) {
                     MallSpecification mallSpecification = new MallSpecification();
                     mallSpecification.setSpecid(goodsDetail.getSpecId());
                     mallSpecification.setStock(spcification.getStock() - goodsDetail.getNum());
                     mallSpecificationMapper.updateByPrimaryKeySelective(mallSpecification);
                 }
             }
         });
          return record.getOrderid();
    }

    /**
     * 获取库存为零的订单
     * @param vo
     * @return
     */
    public List<GoodsDetail> checkMallGoodsStock(PayOrderVO vo) {
        List<GoodsDetail> list = JSONObject.parseArray(vo.getGoodsDetails(), GoodsDetail.class);
        List<GoodsDetail> newList = new ArrayList<>();
        if(list!=null&&!list.isEmpty()) {
            list.forEach(goodsDetail -> {
                MallSpecification MallSpecification = mallSpecificationMapper.selectByPrimaryKey(goodsDetail.getSpecId());
                if(MallSpecification!=null) {
                    if (MallSpecification.getStock() == 0 || goodsDetail.getNum() > MallSpecification.getStock()) {
                        newList.add(goodsDetail);
                    }
                }
            });
        }
      return newList;
    }

    private static String getCollageNo(){
        StringBuffer buf = new StringBuffer();
        buf.append("PT");
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
        buf.append(sdf.format(new Date()));
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        buf.append(String.format("%015d", hashCodeV).substring(5));
        return buf.toString();
    }

    public void updateGoodsStock(Order order){
        List<GoodsDetail> list = JSONObject.parseArray(order.getGoodsDetails(), GoodsDetail.class);
        MallSpecification spcification = mallSpecificationMapper.selectByPrimaryKey(list.get(0).getSpecId());
        if (spcification != null && spcification.getStock() != -1) {
            MallSpecification mallSpecification = new MallSpecification();
            mallSpecification.setSpecid(list.get(0).getSpecId());
            mallSpecification.setStock(spcification.getStock() - list.get(0).getNum());
            mallSpecificationMapper.updateByPrimaryKeySelective(mallSpecification);
        }
    }

    public void addCollageSailed(String collageNo){
        List<Order> orderList = mallOrderMapper.selectOrderByCollageNo(collageNo);
        List<GoodsDetail> goodsDetail = JSONObject.parseArray(orderList.get(0).getGoodsDetails(),GoodsDetail.class);
        Integer total = 0;
        for(Order order:orderList){
            List<GoodsDetail> list = JSONObject.parseArray(order.getGoodsDetails(),GoodsDetail.class);
            total=total+list.get(0).getNum();
        }
        mallGoodsMapper.updateCollageSailed(goodsDetail.get(0).getGoodsId(),total);
    }

    @Async("taskExecutor")
    public void orderOvertime(){
        List<Order> list = mallOrderMapper.selectAllOrderList();
        if (list != null && !list.isEmpty()) {
            for (Order order : list) {
                if(StringUtils.isNotEmpty(order.getCollageNo())){
                    mallGoodsCollageMapper.updateCollageStatusByCustomerId(order.getCollageNo(),order.getCustomerId());
                }
                orderService.updatOrderStatus(order.getOrderNumber(),Constant.OrderType.getEnumOrderType(3));
                if (StringUtils.isEmpty(order.getCollageNo())) {
                    List<GoodsDetail> goodsDetailList = JSONObject.parseArray(order.getGoodsDetails(), GoodsDetail.class);
                    goodsDetailList.forEach(goodsDetail -> {
                        MallSpecification spcification = mallSpecificationMapper.selectByPrimaryKey(goodsDetail.getSpecId());
                        if (spcification!= null && spcification.getStock()!= -1) {
                            MallSpecification mallSpecification = new MallSpecification();
                            mallSpecification.setSpecid(goodsDetail.getSpecId());
                            mallSpecification.setStock(spcification.getStock() + goodsDetail.getNum());
                            mallSpecificationMapper.updateByPrimaryKeySelective(mallSpecification);
                        }
                    });
                }
            }
        }
    }

    @Async("taskExecutor")
    public void cancelOrderCollageFull(){
       mallOrderMapper.updateOrderByCollageFull();
    }

}
