package com.vicmob.shoppingmall.web.goods.service;

import com.github.pagehelper.PageHelper;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.goods.dao.GoodsAttributeMapper;
import com.vicmob.shoppingmall.web.goods.dao.GoodsMapper;
import com.vicmob.shoppingmall.web.goods.dao.GoodsSecondClassifyMapper;
import com.vicmob.shoppingmall.web.goods.entity.Goods;
import com.vicmob.shoppingmall.web.goods.entity.GoodsAttribute;
import com.vicmob.shoppingmall.web.goods.entity.GoodsSecondClassify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsSecondClassifyService {
    private final Logger log = LoggerFactory.getLogger(GoodsSecondClassifyService.class);

    @Autowired
    private GoodsSecondClassifyMapper goodsSecondClassifyMapper;

    @Autowired
    private GoodsAttributeMapper goodsAttributeMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    public List<GoodsSecondClassify> getGoodsSecondClassifyList(GoodsSecondClassify goodsSecondClassify ,Integer page, Integer size){
        PageHelper.startPage(page, size, "sort asc");
        List<GoodsSecondClassify> goodsSecondClassifies =  goodsSecondClassifyMapper.getGoodsSecondClassifyList(goodsSecondClassify);
        return goodsSecondClassifies;
    }

    public ResultData getGoodsSecondClassifyList(GoodsSecondClassify goodsSecondClassify){
        List<GoodsSecondClassify> goodsSecondClassifies =  goodsSecondClassifyMapper.getGoodsSecondClassifyList(goodsSecondClassify);
        return new ResultData("success", ResponseStatus.SUCCESS.getValue(),goodsSecondClassifies);
    }

    public GoodsSecondClassify getByClassifyId(Integer secondClassifyId){
        GoodsSecondClassify goodsSecondClassify =  goodsSecondClassifyMapper.getBySecondClassifyId(secondClassifyId);
        return goodsSecondClassify;
    }

    public ResultData addGoodsSecondClassify(GoodsSecondClassify goodsSecondClassify){
        List<GoodsSecondClassify> list =  goodsSecondClassifyMapper.getBySecondClassifyName(goodsSecondClassify.getClassifyId(),goodsSecondClassify.getSecondClassifyName());
        if(list != null && list.size() != 0) {
            log.error("已存在二级分类名称 goodsSecondClassify =>{}",goodsSecondClassify);
            return new ResultData("已存在二级分类名称", ResponseStatus.FAIL.getValue());
        }
        if (goodsSecondClassifyMapper.addGoodsSecondClassify(goodsSecondClassify)!= 1) {
            log.error("二级分类插入失败 goodsSecondClassify =>{}",goodsSecondClassify);
            return new ResultData("二级分类插入失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }

    public ResultData updateGoodsSecondClassify(GoodsSecondClassify goodsSecondClassify){
        List<GoodsSecondClassify> list =  goodsSecondClassifyMapper.getBySecondClassifyName(goodsSecondClassify.getClassifyId(),goodsSecondClassify.getSecondClassifyName());
        if(list != null && list.size() != 0 ) {
            if (list.size() >= 2 || !(list.get(0).getSecondClassifyId().equals(goodsSecondClassify.getSecondClassifyId()))){
                log.error("已存在二级分类名称 goodsSecondClassify =>{}",goodsSecondClassify);
                return new ResultData("已存在二级分类名称", ResponseStatus.FAIL.getValue());
            }
        }
        if (goodsSecondClassifyMapper.updateGoodsSecondClassify(goodsSecondClassify)!= 1) {
            log.error("二级分类插入失败 goodsSecondClassify =>{}",goodsSecondClassify);
            return new ResultData("二级分类插入失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }

    public ResultData deleteGoodsSecondClassify(Integer secondClassifyId){
        List<GoodsAttribute> list =  goodsAttributeMapper.getAttributeList(secondClassifyId);
        if(list != null && list.size() != 0 ){
            log.error("二级分类删除失败 已存在属性值 secondClassifyId =>{}",secondClassifyId);
            return new ResultData("二级分类删除失败 已存在属性值", ResponseStatus.FAIL.getValue());
        }
        List<Goods> list1 =  goodsMapper.getGoodListBySecondClassifyId(secondClassifyId);
        if(list1 != null && list1.size() != 0 ){
            log.error("二级分类删除失败 已存在商品 secondClassifyId =>{}",secondClassifyId);
            return new ResultData("二级分类删除失败 已存在商品", ResponseStatus.FAIL.getValue());
        }
        if (goodsSecondClassifyMapper.deleteGoodsSecondClassify(secondClassifyId)!= 1) {
            log.error("二级分类删除失败 secondClassifyId =>{}", secondClassifyId);
            return new ResultData("二级分类删除失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }
}
