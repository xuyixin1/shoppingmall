package com.vicmob.shoppingmall.web.goods.service;

import com.github.pagehelper.PageHelper;
import com.vicmob.shoppingmall.constant.CommissionConstant;
import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.utils.StringUtils;
import com.vicmob.shoppingmall.web.distribution.dao.DistributionMapper;
import com.vicmob.shoppingmall.web.distribution.entity.Commission;
import com.vicmob.shoppingmall.web.distribution.entity.Distribution;
import com.vicmob.shoppingmall.web.distribution.service.CommissionService;
import com.vicmob.shoppingmall.web.goods.dao.*;
import com.vicmob.shoppingmall.web.goods.entity.*;
import com.vicmob.shoppingmall.web.goodsAPI.service.GoodsCollageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.util.*;

@Service
public class GoodsService {
    private final Logger log = LoggerFactory.getLogger(GoodsService.class);

    @Autowired
    private CommissionService commissionService;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsClassifyMapper goodsClassifyMapper;
    @Autowired
    private GoodsSecondClassifyMapper goodsSecondClassifyMapper;
    @Autowired
    private SpecificationMapper specificationMapper;
    @Autowired
    private GoodsAttributeMapper goodsAttributeMapper;
    @Autowired
    private DistributionMapper distributionMapper;
    @Autowired
    private GoodsCollageService goodsCollageService;


    public List<Goods> getGoodsList(Goods goods, Integer minaId, Integer page, Integer size){
        PageHelper.startPage(page, size, "sort asc");
        List<Goods> goodsList =  goodsMapper.getGoodList(minaId, goods);
        if(goods.getDistributionFlag() == Constant.Flag.YES){
            Commission commission = commissionService.getCommissionByMinaId(minaId);
            if (commission == null){
                 log.error("佣金设置不存在,minaId ==>{}",minaId);
                return goodsList;
            }
            for(Goods g : goodsList){
                Distribution distribution = distributionMapper.getDistribution(g.getGoodsId());
                if (distribution == null){
                    continue;
                }
                List<Specification> specifications = specificationMapper.getSpecificationList(g.getGoodsId());
                BigDecimal totalMoney = getMaxPrice(specifications);
                BigDecimal commission1  =  CommissionConstant.CommissionMode.getCommission(distribution.getCommissionMode(),commission.getMinAmount(),distribution,totalMoney,1);
                g.setCommission(commission1);

            }
        }
        return goodsList;
    }

    public ResultData getByGoodsId(Integer goodsId){
        Goods goods =  goodsMapper.getByGoodsId(goodsId);
        if (goods == null){
            log.error("获取商品详情失败，goodsId ==>{}",goodsId );
            return new ResultData("获取商品详情失败", ResponseStatus.FAIL.getValue());
        }
        GoodsClassify goodsClassify = goodsClassifyMapper.getByClassifyId(goods.getClassifyId());
        if (goodsClassify == null){
            log.error("商品一级分类不存在，classifyId ==>{}",goods.getClassifyId() );
            return new ResultData("商品一级分类不存在", ResponseStatus.FAIL.getValue());
        }
        goods.setClassifyName(goodsClassify.getClassifyName());
        GoodsSecondClassify goodsSecondClassify = goodsSecondClassifyMapper.getBySecondClassifyId(goods.getSecondClassifyId());
        if (goodsSecondClassify == null){
            log.error("商品二级级分类不存在，secondClassifyId ==>{}",goods.getSecondClassifyId() );
            return new ResultData("商品二级级分类不存在", ResponseStatus.FAIL.getValue());
        }
        goods.setSecondClassifyName(goodsSecondClassify.getSecondClassifyName());
        Distribution distribution = distributionMapper.getDistribution(goodsId);
        goods.setDistribution(distribution);
        List<Specification> specifications = specificationMapper.getSpecificationList(goodsId);
        goods.setSpecifications(specifications);
        return new ResultData("success", ResponseStatus.SUCCESS.getValue(),goods);
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultData deleteByGoodsId(Integer goodsId){
        ResultData result = null;
        try{
            if (goodsMapper.deleteByGoodsId(goodsId) != 1){
                log.error("删除商品失败,goodsId ==>{}",goodsId );
                throw new Exception ("删除商品失败");
            }
            specificationMapper.deleteFlagByGoodsId(goodsId);
            return new ResultData("success", ResponseStatus.SUCCESS.getValue());
        }catch(Exception e){
            log.error("商品删除失败,goodsId ==>{}",goodsId);
            log.error(e.getMessage(), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result = new ResultData(e.getMessage(), ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    public ResultData updateSaleFlag(Integer goodsId, Constant.SaleFlag saleFlag){
        if  (goodsMapper.updateSaleFlag(goodsId,saleFlag)!= 1){
            log.error("更改商品上下架状态失败，goodsId ==>{}，saleFlag ==>{}",goodsId,saleFlag);
            return new ResultData("更改商品上下架状态失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultData addGoods(Goods goods){
        ResultData result = null;
        try {
            if (StringUtils.checkDuplicate(goods.getSpecifications())){
                throw new Exception ("商品规格重复");
            }
            List<Goods> list =  goodsMapper.getByGoodsName(goods.getMinaId(),goods.getGoodsName());
            if(list != null && list.size() != 0) {
                throw new Exception ("已存在商品名");
            }
            if (goodsMapper.addGoods(goods) != 1){
                throw new Exception("商品添加失败");
            }

            List<GoodsAttribute> attributes = goodsAttributeMapper.getAttributeList(goods.getSecondClassifyId());
            Integer goodsId = goods.getGoodsId();
            for (Specification sp : goods.getSpecifications()){
                //验证规格属性是否正确
                if (!checkAttribute(attributes,sp)){
                    throw new Exception("商品规格属性验证失败");
                }
                sp.setGoodsId(goodsId);
                if(specificationMapper.addSpecification(sp) != 1){
                    throw new Exception("商品规格添加失败");
                }
            }
            addOrEditDistribution(goods);
            result = new ResultData("sucess", ResponseStatus.SUCCESS.getValue());
        } catch (Exception e) {
            log.error("商品添加失败，goods ==>{}",goods);
            log.error(e.getMessage(), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result = new ResultData(e.getMessage(), ResponseStatus.FAIL.getValue());
        }
        return result;
    }



    @Transactional(rollbackFor = Exception.class)
    public ResultData updateGoods(Goods goods){
        ResultData result = null;
        try {
            if (StringUtils.checkDuplicate(goods.getSpecifications())){
                throw new Exception ("商品规格重复");
            }

            List<Goods> list =  goodsMapper.getByGoodsName(goods.getMinaId(),goods.getGoodsName());
            if(list != null && list.size() != 0  ) {
                if (list.size() >= 2 ||!(list.get(0).getGoodsId().equals(goods.getGoodsId()))){
                    throw new Exception ("已存在商品名");
                }
            }
            if (goodsMapper.updateGoods(goods) != 1){
                throw new Exception("商品修改失败");
            }
            List<Specification> specifications =  specificationMapper.getSpecificationList(goods.getGoodsId());

            //验证规格属性是否正确
            List<GoodsAttribute> attributes = goodsAttributeMapper.getAttributeList(goods.getSecondClassifyId());
            for (Specification sp : goods.getSpecifications()){

                if (!checkAttribute(attributes,sp)){
                    throw new Exception("商品规格属性验证失败");
                }
                sp.setGoodsId(goods.getGoodsId());
            }

            Map<String,List<Specification>> map = getSpecifications(specifications,goods.getSpecifications());
            if (map.get("add").size() > 0){
                for (Specification sp : map.get("add")){
                    specificationMapper.addSpecification(sp);
                }
            }
            if (map.get("update").size() > 0){
                for (Specification sp : map.get("update")){
                    specificationMapper.updateSpecification(sp);
                }
            }
            if (map.get("delete").size() > 0){
                specificationMapper.deleteSpecifications(map.get("delete"));
                List<Integer> specIds = new LinkedList<>();
                for (Specification sp : map.get("delete")){
                    specIds.add(sp.getSpecId());
                }
                goodsCollageService.delCollageActivityBySpecId(specIds);
            }

            addOrEditDistribution(goods);
            result = new ResultData("sucess", ResponseStatus.SUCCESS.getValue());
        } catch (Exception e) {
            log.error("商品修改失败，goods ==>{}",goods);
            log.error(e.getMessage(), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result = new ResultData(e.getMessage(), ResponseStatus.FAIL.getValue());
        }
        return result;
    }


    public Integer  updateSailed(Integer goodsId,Integer num){
        return goodsMapper.updateSailed(goodsId,num);
    }

    public Integer reduceSailed(Integer goodsId,Integer num){
        return goodsMapper.reduceSailed(goodsId,num);
    }


    private Boolean checkAttribute( List<GoodsAttribute> attributes,Specification sp){
        if (attributes == null || attributes.size() == 0){
            return false;
        }
        if (attributes.size() == 1){
            return isEqual(attributes.get(0),sp,1);
        }
        if (attributes.size() == 2){
            Boolean var = false;
            Boolean var1 = false;
            for(GoodsAttribute ga : attributes){
                if(ga.getAttributeId() .equals(sp.getAttributeId1())){
                    var =  isEqual(ga,sp,1);
                }
                if(ga.getAttributeId() .equals(sp.getAttributeId2())){
                    var1 = isEqual(ga,sp,2);
                }
            }
            if (var && var1 && ! sp.getAttributeId1().equals(sp.getAttributeId2())){
                return true;
            }
        }
        return false;
    }

    private Boolean isEqual(GoodsAttribute attributes,Specification sp,Integer index){
        if (index == 1){
            if ( attributes.getAttributeId().equals(sp.getAttributeId1()) &&
                    attributes.getAttributeName() .equals(sp.getAttributeIdName1()) &&
                    (checkAttributeValues(attributes.getAttributeValues(),sp.getAttributeValueName1()))){
                return true ;
            }
        }else{
            if ( attributes.getAttributeId().equals(sp.getAttributeId2()) &&
                    attributes.getAttributeName() .equals(sp.getAttributeIdName2()) &&
                    (checkAttributeValues(attributes.getAttributeValues(),sp.getAttributeValueName2())) ){
                return true ;
            }
        }
       return false;
    }

    private Boolean checkAttributeValues(String avs,String spv){
        String[] spvs =  avs.split(",");
        for(int i=0 ;i<spvs.length ;i++){
            if (spvs[i] .equals(spv)){
                return true;
            }
        }
        return  false;
    }


    //分销模块
    public void addOrEditDistribution(Goods goods) throws Exception {
        if (goods.getDistributionFlag() == Constant.Flag.NO){
            return ;
        }
        if (goods.getDistributionFlag() == Constant.Flag.YES){
            Commission commission = commissionService.getCommissionByMinaId(goods.getMinaId());
            if (commission == null){
                throw new Exception("请添加佣金相关数据");
            }
        }
        goods.fillDistribution();
        Distribution distribution = distributionMapper.getDistribution(goods.getGoodsId());
        if (distribution == null) {
            if (distributionMapper.addDistribution(goods.getDistribution()) != 1) {
                throw new Exception("添加分销设置失败");
            }
        } else {
            goods.getDistribution().setDistributionId(distribution.getDistributionId());
            if (distributionMapper.updateDistribution(goods.getDistribution()) != 1) {
                throw new Exception("修改分销设置失败");
            }
        }
    }

    public ResultData updateDistributionFlag(Integer goodsId, Constant.Flag distributionFlag){
        if (distributionFlag == Constant.Flag.YES){
            Distribution distribution = distributionMapper.getDistribution(goodsId);
            if (distribution == null) {
                return new ResultData("分销数据不存在，请先设置", ResponseStatus.FAIL.getValue());
            }
        }
        if  (goodsMapper.updateDistributionFlag(goodsId,distributionFlag) != 1){
            log.error("更新商品分销状态失败，goodsId ==>{},distributionFlag ==>{}",goodsId,distributionFlag);
            return new ResultData("更新商品分销状态失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }

    /**
     * 是否用正在使用分销的商品
     */
    public List<Goods> getGoodsWithDistributionFlag(Integer minaId,Constant.Flag falg){
        return goodsMapper.getGoodsWithDistributionFlag(minaId,falg);
    }


    private BigDecimal getMaxPrice(List<Specification> specifications){
        BigDecimal maxPrice = null;
        for(int i = 0;i<specifications.size();i++){
            if(i == 0){
                maxPrice = specifications.get(i).getPrice();
            }else{
                if(maxPrice.compareTo(specifications.get(i).getPrice()) < 0){
                    maxPrice =  specifications.get(i).getPrice();
                }
            }

        }
        return maxPrice;
    }

    public Map<String,List<Specification>> getSpecifications(List<Specification> specifications,List<Specification> newSpecifications){
        List<Specification> add = new ArrayList<>();
        List<Specification> update = new ArrayList<>();
        List<Specification> delete = new ArrayList<>();
        for(Specification specification : newSpecifications){
            if(specification.getSpecId() == null){
                add.add(specification);
            }else{
                update.add(specification);
            }
        }
        for(Specification specification : specifications){
            int i = 0;
            for(Specification sp : update){
                if (specification.getSpecId().equals(sp.getSpecId())){
                    i++;
                    break;
                }
            }
            if (i== 0){
                delete.add(specification);
            }
        }

        Map<String,List<Specification>> map = new HashMap<>();
        map.put("add",add);
        map.put("update",update);
        map.put("delete",delete);
        return map;
     }


}
