package com.vicmob.shoppingmall.web.goodsAPI.controller;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoods;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsSecondClassify;
import com.vicmob.shoppingmall.web.goodsAPI.model.*;
import com.vicmob.shoppingmall.web.goodsAPI.service.ShopShiftService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/minaAPI/shopShift")
@Slf4j
@Api(value="/minaAPI/shopShift", tags="小程序商品首页")
public class ShopShiftController {

    @Autowired
    private ShopShiftService shopShiftService;

    @PostMapping(value = "/getClassifyList")
    @ApiOperation(value = "获取首页信息(包含一级分类，幻灯片列表，热门商品（最多展示12个）", notes = "获取首页信息(包含一级分类，幻灯片列表，热门商品（最多展示12个）", httpMethod = "POST")
    public ServerResponse<ShopShiftInfoVO> getClassifyList(@RequestBody MinaIdVO vo) {
        ShopShiftInfoVO shopShiftInfoVO = shopShiftService.getClassifyList(vo);
        if(shopShiftInfoVO==null){
            return ServerResponse.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(shopShiftInfoVO);
    }

    @PostMapping(value = "/getSecondClassifyByClassifyId")
    @ApiOperation(value = "首页通过一级分类获取二级分类(展示6个)", notes = "首页通过一级分类获取二级分类(展示6个)", httpMethod = "POST")
    public ServerResponse<List<MallGoodsSecondClassify>> getSecondClassifyByClassifyId(@RequestBody ClassifyIdVO vo) {
        List<MallGoodsSecondClassify> list = shopShiftService.getSecondClassifyByClassifyId(vo);
        if(list==null||list.isEmpty()){
            return ServerResponse.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(list);
    }

    @PostMapping(value = "/getAllSecondClassifyByClassifyId")
    @ApiOperation(value = "通过一级分类获取所有二级分类", notes = "通过一级分类获取所有二级分类", httpMethod = "POST")
    public ServerResponse<List<MallGoodsSecondClassify>> getAllSecondClassifyByClassifyId(@RequestBody ClassifyIdVO vo) {
        List<MallGoodsSecondClassify> list = shopShiftService.getAllSecondClassifyByClassifyId(vo);
        if(list==null||list.isEmpty()) {
            return ServerResponse.createByErrorMessage("未获取到相关数据！");
        }
            return ServerResponse.createBySuccess(list);
    }

    @PostMapping(value = "/getGoodsList")
    @ApiOperation(value = "获取商品列表通过二级分类", notes = "获取商品列表通过二级分类", httpMethod = "POST")
    public ServerRespage<List<MallGoods>> getGoodsList(@RequestBody SecondClassifyIdVO vo) {
        List<MallGoods> list = shopShiftService.getGoodsList(vo);
        if(list==null||list.isEmpty()) {
            return ServerRespage.createByErrorMessage("未获取到相关数据！");
        }
        return ServerRespage.createBySuccessPage(list,vo.getPage());
    }

    @PostMapping(value = "/getHotGoodsList")
    @ApiOperation(value = "获取更多热卖商品", notes = "获取更多热卖商品", httpMethod = "POST")
    public ServerRespage<List<MallGoods>> getHotGoodsList(@RequestBody MinaIdVO vo) {
        List<MallGoods> list = shopShiftService.getHotGoodsList(vo);
        if(list==null||list.isEmpty()) {
            return ServerRespage.createByErrorMessage("未获取到相关数据！");
        }
        return ServerRespage.createBySuccessPage(list,vo.getPage());
    }

    @PostMapping(value = "/getMoreCollageGoods")
    @ApiOperation(value = "获取更多拼团商品", notes = "获取更多拼团商品", httpMethod = "POST")
    public ServerRespage<List<MoreGoodsCollageVO>> getMoreCollageGoods(@RequestBody MinaIdVO vo) {
        List<MoreGoodsCollageVO> list = shopShiftService.getMoreCollageGoods(vo);
        if(list==null||list.isEmpty()) {
            return ServerRespage.createByErrorMessage("未获取到相关数据！");
        }
        return ServerRespage.createBySuccessPage(list,vo.getPage());
    }

    @PostMapping(value = "/getSearchGoodsList")
    @ApiOperation(value = "首页搜索商品", notes = "首页搜索商品", httpMethod = "POST")
    public ServerRespage<List<MallGoods>> getSearchGoodsList(@RequestBody MinaIdVO vo) {
        List<MallGoods> list = shopShiftService.getSearchGoodsList(vo);
        if(list==null||list.isEmpty()) {
            return ServerRespage.createByErrorMessage("未获取到相关数据！");
        }
        return ServerRespage.createBySuccessPage(list,vo.getPage());
    }


}
