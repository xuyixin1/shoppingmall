package com.vicmob.shoppingmall.web.goods.dao;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.web.goods.entity.Evaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluateMapper {
    public List<Evaluate> findEvaluateList(@Param("e") Evaluate evaluate);

    public Integer updateReply(@Param("evaluateId")Integer evaluateId, @Param("storeReply")String storeReply);

    public Integer deleteEvaluate(@Param("evaluateId")Integer evaluateId,@Param("deleteFlag")Constant.DeleteFlag1 deleteFlag);

    public Evaluate getByEvaluateId(@Param("evaluateId")Integer evaluateId);
}
