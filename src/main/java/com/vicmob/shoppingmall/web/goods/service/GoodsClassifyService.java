package com.vicmob.shoppingmall.web.goods.service;

import com.github.pagehelper.PageHelper;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.goods.dao.GoodsClassifyMapper;
import com.vicmob.shoppingmall.web.goods.dao.GoodsSecondClassifyMapper;
import com.vicmob.shoppingmall.web.goods.entity.GoodsClassify;
import com.vicmob.shoppingmall.web.goods.entity.GoodsSecondClassify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsClassifyService {
    private final Logger log = LoggerFactory.getLogger(GoodsClassifyService.class);
    @Autowired
    private GoodsClassifyMapper goodsClassifyMapper;
    @Autowired
    private GoodsSecondClassifyMapper goodsSecondClassifyMapper;

    public List<GoodsClassify> getGoodsClassifyList(GoodsClassify goodsClassify, Integer minaId, Integer page, Integer size){
        PageHelper.startPage(page, size, "sort asc");
        List<GoodsClassify> goodsClassifies =  goodsClassifyMapper.getGoodsClassifyList(minaId, goodsClassify);
        return goodsClassifies;
    }

    public ResultData getGoodsClassifyList(Integer minaId){
        List<GoodsClassify> goodsClassifies =  goodsClassifyMapper.getGoodsClassifyList(minaId,new GoodsClassify());
        return new ResultData("success", ResponseStatus.SUCCESS.getValue(),goodsClassifies);
    }

    public GoodsClassify getByClassifyId(Integer classifyId){
        GoodsClassify goodsClassify =  goodsClassifyMapper.getByClassifyId(classifyId);
        return goodsClassify;
    }

    public ResultData addGoodsClassify(GoodsClassify goodsClassify){
        List<GoodsClassify> list =  goodsClassifyMapper.getByClassifyName(goodsClassify.getMinaId(),goodsClassify.getClassifyName());
        if(list != null && list.size() != 0) {
            log.error("已存在商品分类名称 goodsClassify =>{}",goodsClassify);
            return new ResultData("已存在商品分类名称", ResponseStatus.FAIL.getValue());
        }
        if (goodsClassifyMapper.addGoodsClassify(goodsClassify)!= 1) {
            log.error("商品分类插入失败 goodsClassify =>{}", goodsClassify);
            return new ResultData("商品分类插入失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }

    public ResultData updateGoodsClassify(GoodsClassify goodsClassify){
        List<GoodsClassify> list =  goodsClassifyMapper.getByClassifyName(goodsClassify.getMinaId(),goodsClassify.getClassifyName());
        if(list != null && list.size() != 0 ){
            if(list.size() >= 2 || !(list.get(0).getClassifyId().equals(goodsClassify.getClassifyId()))){
                log.error("已存在商品分类名称 goodsClassify =>{}",goodsClassify);
                return new ResultData("已存在商品分类名称", ResponseStatus.FAIL.getValue());
            }
        }
        if (goodsClassifyMapper.updateGoodsClassify(goodsClassify)!= 1) {
            log.error("商品分类插入失败 goodsClassify =>{}", goodsClassify);
            return new ResultData("商品分类插入失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }

    public ResultData deleteGoodsClassify(Integer classifyId){
        List<GoodsSecondClassify> list =  goodsSecondClassifyMapper.getByClassifyId(classifyId);
        if(list != null && list.size() != 0 ){
            log.error("已存在二级分类 classifyId =>{}",classifyId);
            return new ResultData("已存在二级分类", ResponseStatus.FAIL.getValue());
        }
        if (goodsClassifyMapper.deleteGoodsClassify(classifyId)!= 1) {
            log.error("商品分类删除失败 classifyId =>{}", classifyId);
            return new ResultData("商品分类删除失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }
}