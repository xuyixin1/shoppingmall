package com.vicmob.shoppingmall.web.goods.service;

import com.github.pagehelper.PageHelper;
import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.goods.dao.EvaluateMapper;
import com.vicmob.shoppingmall.web.goods.entity.Evaluate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateService {
    private final Logger log = LoggerFactory.getLogger(EvaluateService.class);

    @Autowired
    private EvaluateMapper evaluateMapper;

    public List<Evaluate> findEvaluateList(Evaluate evaluate, Integer page , Integer size){
        PageHelper.startPage(page, size,"evalTime desc");
        List<Evaluate> evaluates =  evaluateMapper.findEvaluateList(evaluate);
        return evaluates;
    }

    public ResultData getByEvaluateId(Integer evaluateId){
        Evaluate evaluate = evaluateMapper.getByEvaluateId(evaluateId);
        if (evaluate == null){
            log.error("获取评论详情失败evaluateId ==>{} ",evaluateId);
            return new ResultData("获取评论详情失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue(),evaluate);
    }

    public ResultData updateReply(Integer evaluateId, String storeReply){
        if(evaluateMapper.updateReply(evaluateId, storeReply) != 1){
            log.error("更新商家回复失败，evaluateId ==>{},storeReply ==>{}",evaluateId,storeReply);
            return new ResultData("更新商家回复失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }

    public ResultData deleteEvaluate(Integer evaluateId, Constant.DeleteFlag1 deleteFlag){
        if(evaluateMapper.deleteEvaluate(evaluateId, deleteFlag) != 1){
            log.error("屏蔽操作失败，evaluateId ==>{},deleteFlag ==>{}",evaluateId,deleteFlag);
            return new ResultData("屏蔽操作失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());

    }

}
