package com.vicmob.shoppingmall.web.goodsAPI.dao;

import com.github.pagehelper.Page;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsCart;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsCartExample;
import com.vicmob.shoppingmall.web.goodsAPI.model.MallGoodsCartVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MallGoodsCartMapper {
    int countByExample(MallGoodsCartExample example);

    int deleteByExample(MallGoodsCartExample example);

    List<MallGoodsCart> selectByExample(MallGoodsCartExample example);

    int updateByExampleSelective(@Param("record") MallGoodsCart record, @Param("example") MallGoodsCartExample example);

    int updateByExample(@Param("record") MallGoodsCart record, @Param("example") MallGoodsCartExample example);

    List<MallGoodsCart> selectByExampleAndPage(MallGoodsCartExample example, RowBounds rowBound);

    int deleteByPrimaryKey(Integer cartid);

    int insert(MallGoodsCart record);

    int insertSelective(MallGoodsCart record);

    MallGoodsCart selectByPrimaryKey(Integer cartid);

    int updateByPrimaryKeySelective(MallGoodsCart record);

    int updateByPrimaryKey(MallGoodsCart record);

    Page<MallGoodsCartVO> selectGoodsCartList(@Param("customerId")Integer customerId, @Param("minaId")Integer minaId);

    int getGoodsCartNumByGoodsId(@Param("goodsId")Integer goodsId, @Param("minaId")Integer minaId,@Param("customerId")Integer customerId);
}