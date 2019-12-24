package com.vicmob.shoppingmall.web.distribution.service;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.distribution.dao.CommissionMapper;
import com.vicmob.shoppingmall.web.distribution.entity.Commission;
import com.vicmob.shoppingmall.web.distribution.entity.Customer;
import com.vicmob.shoppingmall.web.goods.entity.Goods;
import com.vicmob.shoppingmall.web.goods.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class CommissionService {
    @Autowired
    private CommissionMapper commissionMapper;
    @Autowired
    @Lazy
    private GoodsService goodsService;



    public Commission  getCommissionByMinaId(Integer minaId){
        List<Commission> commissionList = commissionMapper.getCommissionByMinaId(minaId);
        if (commissionList != null && commissionList.size() > 0 ){
            return commissionList.get(0);
        }
        return null;
    }

    public List<Commission>  getCommissionByMinaIds(Set<Integer> minaIds){
        return commissionMapper.getCommissionByMinaIds(minaIds);
    }

    public ResultData addCommission(Commission commission){
        List<Commission> commissionList = commissionMapper.getCommissionByMinaId(commission.getMinaId());
        if (commissionList != null && commissionList.size() > 0 ){
            return new ResultData("该商户已添加过佣金", ResponseStatus.FAIL.getValue());
        }

        if (commissionMapper.addCommission(commission) != 1){
            log.error("添加佣金设置失败,Commission==>{}",commission);
            return new ResultData("添加佣金设置失败", ResponseStatus.FAIL.getValue());
        }
       return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }


    public ResultData updateCommission(Commission Commission){
        if (commissionMapper.updateCommission(Commission) != 1){
            log.error("修改佣金设置失败,Commission==>{}",Commission);
            return new ResultData("修改佣金设置失败", ResponseStatus.FAIL.getValue());
        }

        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }


    public ResultData delCommission(Integer commissionId,Integer minaId){
        List<Goods> goodsList = goodsService.getGoodsWithDistributionFlag(minaId, Constant.Flag.YES);
        if (goodsList != null && goodsList.size() >0){
            return new ResultData("已存在分销的商品", ResponseStatus.FAIL.getValue());
        }

        if (commissionMapper.delCommission(commissionId) != 1){
            log.error("删除佣金设置失败,commissionId==>{}",commissionId);
            return new ResultData("删除佣金设置失败", ResponseStatus.FAIL.getValue());

        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }

}
