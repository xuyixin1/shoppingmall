package com.vicmob.shoppingmall.web.goods.service;

import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.utils.StringUtils;
import com.vicmob.shoppingmall.web.goods.dao.GoodsAttributeMapper;
import com.vicmob.shoppingmall.web.goods.dao.SpecificationMapper;
import com.vicmob.shoppingmall.web.goods.entity.GoodsAttribute;
import com.vicmob.shoppingmall.web.goods.entity.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsAttributeService {
    private final Logger log = LoggerFactory.getLogger(GoodsAttributeService.class);

    @Autowired
    private GoodsAttributeMapper goodsAttributeMapper;
    @Autowired
    private SpecificationMapper specificationMapper;

    public List<GoodsAttribute> getGoodsAttributeList (Integer secondClassifyId){
        List<GoodsAttribute>  goodsAttributes =  goodsAttributeMapper.getAttributeList(secondClassifyId);
        return goodsAttributes;
    }

    public ResultData getByAttributeId(Integer attributeId){
        GoodsAttribute goodsAttribute = goodsAttributeMapper.getByAttributeId(attributeId);
        if (goodsAttribute == null){
            log.error("获取商品属性详情失败attributeId ==>{} ",attributeId);
            return new ResultData("获取商品属性详情失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue(),goodsAttribute);
    }

    public ResultData addGoodsAttribute(GoodsAttribute goodsAttribute){
        ResultData result = null;
        try{
            if (StringUtils.checkDuplicate(goodsAttribute.getAttributeValues())){
                throw new Exception("商品属性值存在重复");
            }
            List<Specification> specifications  = specificationMapper.getSpecificationListByAttributeId(goodsAttribute.getAttributeId());
            if (specifications != null && specifications.size() != 0){
                throw new Exception("此属性下已存在商品,不可添加");
            }
            List<GoodsAttribute> list = goodsAttributeMapper.getAttributeList(goodsAttribute.getSecondClassifyId());
            if (list != null && list.size() != 0){
                if ( list.size() > 2){
                    throw new Exception("商品属性不能大于2个");
                }
            }
            List<GoodsAttribute> list1 =  goodsAttributeMapper.getGoodsAttributeByName(goodsAttribute);
            if(list1 != null && list1.size() != 0) {
                throw new Exception("已存在商品属性名称");
            }
            if (goodsAttributeMapper.addGoodsAttribute(goodsAttribute)!= 1) {
                throw new Exception("商品属性添加失败");
            }
            return new ResultData("success", ResponseStatus.SUCCESS.getValue());
        } catch (Exception e) {
            log.error("商品属性添加失败，goodsAttribute ==>{}",goodsAttribute);
            log.error(e.getMessage(), e);
            result = new ResultData(e.getMessage(), ResponseStatus.FAIL.getValue());
        }
        return result;
    }


    public ResultData updateGoodsAttribute(GoodsAttribute goodsAttribute){
        ResultData result = null;
        try{
            if (StringUtils.checkDuplicate(goodsAttribute.getAttributeValues())){
                throw new Exception("商品属性值存在重复");
            }
            List<Specification> specifications  = specificationMapper.getSpecificationListByAttributeId(goodsAttribute.getAttributeId());
            if (specifications != null && specifications.size() != 0){
                throw new Exception("此属性下已存在商品,不可修改");
            }
            List<GoodsAttribute> list =  goodsAttributeMapper.getGoodsAttributeByName(goodsAttribute);
            if(list != null && list.size() != 0) {
                if (list.size()>= 2 || !(list.get(0).getAttributeId().equals(goodsAttribute.getAttributeId()))){
                    throw new Exception("已存在商品属性名称");
                }
            }
            if (goodsAttributeMapper.updateGoodsAttribute(goodsAttribute)!= 1) {
                throw new Exception("商品属性修改失败");
            }

            return new ResultData("success", ResponseStatus.SUCCESS.getValue());
        } catch (Exception e) {
            log.error("商品属性修改失败，goodsAttribute ==>{}",goodsAttribute);
            log.error(e.getMessage(), e);
            result = new ResultData(e.getMessage(), ResponseStatus.FAIL.getValue());
        }
        return result;
    }
    public ResultData deleteGoodsAttribute(Integer attributeId){
        List<Specification> specifications  = specificationMapper.getSpecificationListByAttributeId(attributeId);
        if (specifications != null && specifications.size() != 0){
            return  new ResultData("此属性下已存在商品,不可删除", ResponseStatus.FAIL.getValue());
        }
       if (goodsAttributeMapper.deleteGoodsAttribute(attributeId)!= 1) {
           return  new ResultData("商品删除失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }

}
