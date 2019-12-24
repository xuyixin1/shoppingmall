package com.vicmob.shoppingmall.web.goodsAPI.service;
import cn.hutool.core.convert.Convert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vicmob.shoppingmall.utils.DecryptUtils;
import com.vicmob.shoppingmall.web.goodsAPI.dao.*;
import com.vicmob.shoppingmall.web.goodsAPI.entity.*;
import com.vicmob.shoppingmall.web.goodsAPI.model.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ShopShiftService {

    @Autowired
    private MallGoodsClassifyMapper mallGoodsClassifyMapper;

    @Autowired
    private MallGoodsSecondClassifyMapper mallGoodsSecondClassifyMapper;

    @Autowired
    private MallGoodsMapper mallGoodsMapper;

    @Autowired
    private MallSpecificationMapper mallSpecificationMapper;

    @Autowired
    private MallSlideMapper mallSlideMapper;

    public ShopShiftInfoVO getClassifyList (MinaIdVO vo) {
        ShopShiftInfoVO shopShiftInfoVO = new ShopShiftInfoVO();
        MallGoodsClassifyExample example = new MallGoodsClassifyExample();
        example.createCriteria().andMinaidEqualTo(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        example.setOrderByClause("sort");
        List<MallGoodsClassify> goodsClassifylist = mallGoodsClassifyMapper.selectByExample(example);
        if(goodsClassifylist==null||goodsClassifylist.isEmpty()){
            shopShiftInfoVO.setMallGoodsClassifyList(new ArrayList<>());
        }else{
            shopShiftInfoVO.setMallGoodsClassifyList(goodsClassifylist);
        }
        MallGoodsExample goodsExample = new MallGoodsExample();
        MallGoodsExample.Criteria criteria= goodsExample.createCriteria();
        criteria.andMinaidEqualTo(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        criteria.andShowflagEqualTo(1);
        criteria.andDeleteflagEqualTo(0);
        criteria.andSaleflagEqualTo(1);
        criteria.andCollageflagEqualTo(0);
        goodsExample.setOrderByClause("sort");
        List<MallGoods> mallGoodsList = mallGoodsMapper.selectByExample(goodsExample);
        if(mallGoodsList==null||mallGoodsList.isEmpty()){
            shopShiftInfoVO.setMallGoodsList(new ArrayList<>());
        }
        if(mallGoodsList.size()>12){
            shopShiftInfoVO.setMallGoodsList(mallGoodsList.subList(0,12));
        }else{
            shopShiftInfoVO.setMallGoodsList(mallGoodsList);
        }
        MallSlideExample mallSlideExample = new MallSlideExample();
        MallSlideExample.Criteria criteria1 = mallSlideExample.createCriteria();
        criteria1.andMinaidEqualTo(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        criteria1.andUseflagEqualTo(1);
        List<MallSlide> mallSlideList = mallSlideMapper.selectByExample(mallSlideExample);
        if(mallSlideList==null||mallSlideList.isEmpty()){
            shopShiftInfoVO.setMallSlideList(new ArrayList<>());
        }else{
            shopShiftInfoVO.setMallSlideList(mallSlideList);
        }
        List<MoreGoodsCollageVO> moreGoodsCollageVO = mallGoodsMapper.getMoreCollageGoods(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())),"");
        if(moreGoodsCollageVO==null||moreGoodsCollageVO.isEmpty()){
            shopShiftInfoVO.setMoreGoodsCollageVOList(new ArrayList<>());
        }
        if(moreGoodsCollageVO.size()>2){
            shopShiftInfoVO.setMoreGoodsCollageVOList(moreGoodsCollageVO.subList(0,2));
        }else{
            shopShiftInfoVO.setMoreGoodsCollageVOList(moreGoodsCollageVO);
        }
        return shopShiftInfoVO;
    }

    public List<MallGoodsSecondClassify> getSecondClassifyByClassifyId(ClassifyIdVO vo) {
        MallGoodsSecondClassifyExample example = new MallGoodsSecondClassifyExample();
        MallGoodsSecondClassifyExample.Criteria criteria = example.createCriteria();
        criteria.andClassifyidEqualTo(vo.getClassifyId());
        criteria.andMinaidEqualTo(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        example.setOrderByClause("sort");
        List<MallGoodsSecondClassify> list = mallGoodsSecondClassifyMapper.selectByExample(example);
        if(list.size()>6) {
            list = list.subList(0,6);
        }
        return list;
    }

    public List<MallGoodsSecondClassify> getAllSecondClassifyByClassifyId(ClassifyIdVO vo) {
        MallGoodsSecondClassifyExample example = new MallGoodsSecondClassifyExample();
        MallGoodsSecondClassifyExample.Criteria criteria = example.createCriteria();
        criteria.andClassifyidEqualTo(vo.getClassifyId());
        criteria.andMinaidEqualTo(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        example.setOrderByClause("sort");
        List<MallGoodsSecondClassify> list = mallGoodsSecondClassifyMapper.selectByExample(example);
        return list;
    }

    public List<MallGoods> getGoodsList(SecondClassifyIdVO vo) {
        PageHelper.startPage(vo.getPage().getPageIndex(), vo.getPage().getPageSize());
        Page<MallGoods> list = mallGoodsMapper.getGoodsList(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())),vo.getSecondClassifyId(),vo.getGoodsName());
        if(vo.getPage()!= null) {
            vo.getPage().setTotal(list.getTotal());
        }
        return list.getResult();
    }

    public List<MallGoods> getHotGoodsList (MinaIdVO vo) {
        PageHelper.startPage(vo.getPage().getPageIndex(), vo.getPage().getPageSize());
        MallGoodsExample goodsExample = new MallGoodsExample();
        MallGoodsExample.Criteria criteria= goodsExample.createCriteria();
        criteria.andMinaidEqualTo(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        criteria.andShowflagEqualTo(1);
        criteria.andDeleteflagEqualTo(0);
        criteria.andSaleflagEqualTo(1);
        criteria.andCollageflagEqualTo(0);
        goodsExample.setOrderByClause("sort");
        Page<MallGoods> mallGoodsList = (Page<MallGoods>)mallGoodsMapper.selectByExample(goodsExample);
        if(vo.getPage()!= null) {
            vo.getPage().setTotal(mallGoodsList.getTotal());
        }
        return mallGoodsList;
    }

    public List<MoreGoodsCollageVO> getMoreCollageGoods(MinaIdVO vo) {
        PageHelper.startPage(vo.getPage().getPageIndex(), vo.getPage().getPageSize());
        Page<MoreGoodsCollageVO> mallGoodsList = mallGoodsMapper.getMoreCollageGoods(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())),vo.getGoodsName());
        if(vo.getPage()!= null) {
            vo.getPage().setTotal(mallGoodsList.getTotal());
        }
        return mallGoodsList;
    }

    public List<MallGoods> getSearchGoodsList (MinaIdVO vo) {
        PageHelper.startPage(vo.getPage().getPageIndex(), vo.getPage().getPageSize());
        MallGoodsExample goodsExample = new MallGoodsExample();
        MallGoodsExample.Criteria criteria= goodsExample.createCriteria();
        criteria.andMinaidEqualTo(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        criteria.andDeleteflagEqualTo(0);
        criteria.andSaleflagEqualTo(1);
        criteria.andGoodsnameLike("%" + vo.getGoodsName() + "%");
        goodsExample.setOrderByClause("sort");
        Page<MallGoods> mallGoodsList = (Page<MallGoods>)mallGoodsMapper.selectByExample(goodsExample);
        if(vo.getPage()!= null) {
            vo.getPage().setTotal(mallGoodsList.getTotal());
        }
        return mallGoodsList;
    }
}
