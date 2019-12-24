package com.vicmob.shoppingmall.web.goodsAPI.controller;
import com.vicmob.shoppingmall.web.goodsAPI.model.*;
import com.vicmob.shoppingmall.web.goodsAPI.service.GoodsCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/minaAPI/goodsCart")
@Slf4j
@Api(value="/minaAPI/goodsCart", tags="购物车")
public class GoodsCartController {

    @Autowired
    private GoodsCartService goodsCartService;

    @PostMapping(value = "/getGoodsCartList")
    @ApiOperation(value = "获取用户的购物车列表", notes = "获取用户的购物车列表", httpMethod = "POST")
    public ServerRespage<List<MallGoodsCartVO>> getGoodsCartList(@RequestBody MinaIdVO vo) {
        List<MallGoodsCartVO> list =  goodsCartService.getGoodsCartList(vo);
        if(list==null||list.isEmpty()){
            return ServerRespage.createByErrorMessage("未获取到相关数据！");
        }
        return ServerRespage.createBySuccessPage(list,vo.getPage());
    }

    @PostMapping(value = "/getGoodsCartNumByGoodsId")
    @ApiOperation(value = "获取商品的购物车数量", notes = "获取商品的购物车数量", httpMethod = "POST")
    public ServerResponse<Integer> getGoodsCartNumByGoodsId(@RequestBody GoodsIdVO vo) {
        return ServerResponse.createBySuccess(goodsCartService.getGoodsCartNumByGoodsId(vo));
    }

    @PostMapping(value = "/addOrMinusGoodsNum")
    @ApiOperation(value = "加减购物车商品数量", notes = "加减购物车商品数量", httpMethod = "POST")
    public ServerResponse addOrMinusGoodsNum(@RequestBody MallGoodsCartAddVO vo) {
         int result =  goodsCartService.addOrMinusGoodsNum(vo);
        if(result ==0){
            return ServerResponse.createByError("加减购物车商品数量失败!");
        }else{
            return ServerResponse.createBySuccess("加减购物车商品数量成功!");
        }
    }

    @PostMapping(value = "/delGoodsCart")
    @ApiOperation(value = "购物车商品删除", notes = "购物车商品删除", httpMethod = "POST")
    public ServerResponse addOrMinusGoodsNum(@RequestBody CartIdsVO vo) {
        int result =  goodsCartService.delGoodsCart(vo.getCartIds());
        if(result ==0){
            return ServerResponse.createByError("删除购物车商品失败!");
        }else{
            return ServerResponse.createBySuccess("删除购物车商品成功!");
        }
    }

    @PostMapping(value = "/pullGoodsCart")
    @ApiOperation(value = "商品加入购物车", notes = "商品加入购物车", httpMethod = "POST")
    public ServerResponse pullGoodsCart(@RequestBody MallGoodsCartPullVO vo) {
        int result =  goodsCartService.pullGoodsCart(vo);
        if(result ==0){
            return ServerResponse.createByError("商品加入购物车失败!");
        }else{
            return ServerResponse.createBySuccess("商品加入购物车成功!");
        }
    }

}
