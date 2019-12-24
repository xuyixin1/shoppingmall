package com.vicmob.shoppingmall.utils;

import com.vicmob.shoppingmall.web.distribution.entity.CommissionRecord;
import com.vicmob.shoppingmall.web.goods.entity.GoodsDetail;
import io.swagger.models.auth.In;
import org.springframework.util.StringUtils;

import java.util.*;

public class ListToMapUtil {
    public static Map<Integer, List<GoodsDetail>> toMapServiceDetailByGoodsId(List<GoodsDetail> list) {
        Map<Integer, List<GoodsDetail>> map = null;
        Set<Integer> goodsIds = new HashSet<>();
        for (GoodsDetail sd : list) {
            if (sd.getGoodsId() != null) {
                goodsIds.add(sd.getGoodsId());
            }
        }
        map = new HashMap<>(goodsIds.size());
        for (Integer goodsId : goodsIds) {
            List<GoodsDetail>  gooodsDetail = new ArrayList<>();
            for (GoodsDetail sd : list) {
                if (sd.getGoodsId() != null && sd.getGoodsId().equals(goodsId)) {
                    gooodsDetail.add(sd);
                }
            }
            map.put(goodsId,gooodsDetail);
        }
        return map;
    }


    public static  Map<Integer,List<CommissionRecord>> toMapCommissionRecordByMinaId(List<CommissionRecord> list){
        Set<Integer> minaIds = new HashSet<>();
        for (CommissionRecord commissionRecord : list){
            if (commissionRecord.getMinaId() != null){
                minaIds.add(commissionRecord.getMinaId());
            }
        }
        Map<Integer,List<CommissionRecord>> records = new HashMap<>(getSize(minaIds.size()));
        for (Integer minaId : minaIds) {
            List<CommissionRecord>  commissionRecordList = new ArrayList<>();
            for (CommissionRecord cd : list) {
                if (cd.getMinaId() != null && cd.getMinaId().equals(minaId)) {
                    commissionRecordList.add(cd);
                }
            }
            records.put(minaId,commissionRecordList);
        }
        return records;

    }

    public static  Map<String,List<CommissionRecord>> toMapCommissionRecordByDistributionUser(List<CommissionRecord> list){
        Set<String> ids = new HashSet<>();
        for (CommissionRecord commissionRecord : list){
            if (commissionRecord.getDistributionUser() != null){
                ids.add(commissionRecord.getDistributionUser());
            }
        }
        Map<String,List<CommissionRecord>> records = new HashMap<>(getSize(ids.size()));
        for (String id : ids) {
            List<CommissionRecord>  commissionRecordList = new ArrayList<>();
            for (CommissionRecord cd : list) {
                if (!StringUtils.isEmpty(cd.getDistributionUser())  && cd.getDistributionUser().equals(id)) {
                    commissionRecordList.add(cd);
                }
            }
            records.put(id,commissionRecordList);
        }
        return records;

    }



    private static Integer getSize(Integer size){
        return size/3*4;
    }

    public static void main(String[] args){
        List<GoodsDetail> activities = new ArrayList<>(32);
        for (int i= 0;i<20;i++){
            GoodsDetail a = new GoodsDetail();
            a.setGoodsId(i%4);
            a.setNum(i);
            activities.add(a);
        }
        toMapServiceDetailByGoodsId(activities);
    }
}
