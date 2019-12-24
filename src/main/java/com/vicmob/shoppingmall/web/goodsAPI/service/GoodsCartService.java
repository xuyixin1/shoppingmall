package com.vicmob.shoppingmall.web.goodsAPI.service;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vicmob.shoppingmall.utils.DecryptUtils;
import com.vicmob.shoppingmall.web.goodsAPI.dao.MallGoodsCartMapper;
import com.vicmob.shoppingmall.web.goodsAPI.entity.*;
import com.vicmob.shoppingmall.web.goodsAPI.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class GoodsCartService {

    @Autowired
    private MallGoodsCartMapper mallGoodsCartMapper;

    public List<MallGoodsCartVO> getGoodsCartList(MinaIdVO vo) {
        PageHelper.startPage(vo.getPage().getPageIndex(), vo.getPage().getPageSize());
        Page<MallGoodsCartVO> list = mallGoodsCartMapper.selectGoodsCartList(vo.getCustomerId(),Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        if(vo.getPage()!= null) {
            vo.getPage().setTotal(list.getTotal());
        }
        return list.getResult();
    }

    public Integer getGoodsCartNumByGoodsId(GoodsIdVO vo) {
      return mallGoodsCartMapper.getGoodsCartNumByGoodsId(vo.getGoodsId(),Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())),vo.getCustomerId());
    }

    public int addOrMinusGoodsNum(MallGoodsCartAddVO vo) {
        MallGoodsCart record = Convert.convert(MallGoodsCart.class,vo);
        return mallGoodsCartMapper.updateByPrimaryKeySelective(record);
    }

    public int delGoodsCart(List<Integer> cartIds) {
        int result = 0;
        MallGoodsCart record = new MallGoodsCart();
        record.setDeleteflag(1);
        for (Integer cartId : cartIds) {
            record.setCartid(cartId);
            result += mallGoodsCartMapper.updateByPrimaryKeySelective(record);
        }
        return result;
    }

    public int pullGoodsCart(MallGoodsCartPullVO vo) {
        MallGoodsCartExample example = new MallGoodsCartExample();
        MallGoodsCartExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsidEqualTo(vo.getGoodsid());
        criteria.andCustomeridEqualTo(vo.getCustomerid());
        criteria.andMinaidEqualTo(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
        criteria.andSpecidEqualTo(vo.getSpecid());
        criteria.andDeleteflagEqualTo(0);
        List<MallGoodsCart> mallGoodsCartList = mallGoodsCartMapper.selectByExample(example);
        if(mallGoodsCartList==null||mallGoodsCartList.isEmpty()){
            MallGoodsCart record = Convert.convert(MallGoodsCart.class,vo);
            record.setMinaid(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(),vo.getMinaStr())));
            record.setGoodsnum(vo.getGoodsnum());
            record.setCreatedate(new Date());
            record.setDeleteflag(0);
            return mallGoodsCartMapper.insertSelective(record);
        }else{
            MallGoodsCart record = new MallGoodsCart();
            record.setCartid(mallGoodsCartList.get(0).getCartid());
            record.setGoodsnum(mallGoodsCartList.get(0).getGoodsnum().intValue()+vo.getGoodsnum().intValue());
            return mallGoodsCartMapper.updateByPrimaryKeySelective(record);
        }
    }
}
