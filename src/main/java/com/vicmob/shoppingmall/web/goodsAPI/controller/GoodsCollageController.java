package com.vicmob.shoppingmall.web.goodsAPI.controller;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoods;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsClassify;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsSecondClassify;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallSpecification;
import com.vicmob.shoppingmall.web.goodsAPI.model.*;
import com.vicmob.shoppingmall.web.goodsAPI.service.GoodsCollageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/minaAPI/goodsCollage")
@Slf4j
@Api(value="/minaAPI/goodsCollage", tags="拼团管理")
public class GoodsCollageController {

    @Autowired
    private GoodsCollageService goodsCollageService;

    @PostMapping(value = "/getAllClassify")
    @ApiOperation(value = "获取一级分类", notes = "获取一级分类", httpMethod = "POST")
    public ServerResponse<List<MallGoodsClassify>> getAllClassify(@RequestBody ClassifyIdQueryVO vo) {
        List<MallGoodsClassify> list = goodsCollageService.getAllClassify(vo);
        if(list==null||list.isEmpty()) {
            return ServerResponse.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(list);
    }

    @PostMapping(value = "/getAllSecondClassifyByClassifyId")
    @ApiOperation(value = "通过一级分类获取所有二级分类", notes = "通过一级分类获取所有二级分类", httpMethod = "POST")
    public ServerResponse<List<MallGoodsSecondClassify>> getAllSecondClassifyByClassifyId(@RequestBody ClassifyIdQueryVO vo) {
        List<MallGoodsSecondClassify> list = goodsCollageService.getAllSecondClassifyByClassifyId(vo);
        if(list==null||list.isEmpty()) {
            return ServerResponse.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(list);
    }

    @PostMapping(value = "/getAllGoodsList")
    @ApiOperation(value = "获取所有没进行拼团活动的商品列表", notes = "获取所有没进行拼团活动的商品列表", httpMethod = "POST")
    public ServerResponse<List<MallGoods>> getAllGoodsList(@RequestBody ClassifyIdQueryVO vo) {
        List<MallGoods> list = goodsCollageService.getAllGoodsList(vo);
        if(list==null||list.isEmpty()) {
            return ServerResponse.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(list);
    }

    @PostMapping(value = "/getAllClassifyByEdit")
    @ApiOperation(value = "获取一级分类", notes = "获取一级分类", httpMethod = "POST")
    public ServerResponse<List<MallGoodsClassify>> getAllClassifyByEdit(@RequestBody ClassifyIdQueryVO vo) {
        List<MallGoodsClassify> list = goodsCollageService.getAllClassifyByEdit(vo);
        if(list==null||list.isEmpty()) {
            return ServerResponse.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(list);
    }

    @PostMapping(value = "/getAllSecondClassifyByEdit")
    @ApiOperation(value = "通过一级分类获取所有二级分类", notes = "通过一级分类获取所有二级分类", httpMethod = "POST")
    public ServerResponse<List<MallGoodsSecondClassify>> getAllSecondClassifyByEdit(@RequestBody ClassifyIdQueryVO vo) {
        List<MallGoodsSecondClassify> list = goodsCollageService.getAllSecondClassifyByEdit(vo);
        if(list==null||list.isEmpty()) {
            return ServerResponse.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(list);
    }

    @PostMapping(value = "/getAllGoodsListByEdit")
    @ApiOperation(value = "获取所有没进行拼团活动的商品列表", notes = "获取所有没进行拼团活动的商品列表", httpMethod = "POST")
    public ServerResponse<List<MallGoods>> getAllGoodsListByEdit(@RequestBody ClassifyIdQueryVO vo) {
        List<MallGoods> list = goodsCollageService.getAllGoodsListByEdit(vo);
        if(list==null||list.isEmpty()) {
            return ServerResponse.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(list);
    }

    @PostMapping(value = "/getAllSpecificationByGoodsId")
    @ApiOperation(value = "获取这个商品的所有规格和库存", notes = "获取这个商品的所有规格和库存", httpMethod = "POST")
    public ServerResponse<List<MallSpecification>> getAllSpecificationByGoodsId(@RequestBody GoodsCollageVO vo) {
        List<MallSpecification> list =  goodsCollageService.getAllSpecificationByGoodsId(vo.getMinaId(),vo.getGoodsId());
        if(list == null){
            return ServerRespage.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(list);
    }

    @PostMapping(value = "/getCollageActivityList")
    @ApiOperation(value = "获取拼团活动列表", notes = "获取拼团活动列表", httpMethod = "POST")
    public ServerRespage<List<MallGoodsCollageActivityVO>> getCollageActivityList(@RequestBody MallGoodsCollageActivityQueryVO vo) {
        List<MallGoodsCollageActivityVO> list = goodsCollageService.getCollageActivityList(vo);
        if(list == null){
            return ServerRespage.createByErrorMessage("未获取到相关数据！");
        }
        return ServerRespage.createBySuccessPage(list,vo.getPage());
    }

    @PostMapping(value = "/getCollageActivityDetail")
    @ApiOperation(value = "获取拼团活动详情", notes = "获取拼团活动详情", httpMethod = "POST")
    public ServerResponse<MallGoodsCollageActivityDetailVO> getCollageActivityDetail(@RequestBody CollageActivityIdVO vo) {
        MallGoodsCollageActivityDetailVO result = goodsCollageService.getCollageActivityDetail(vo.getCollageActivityId());
        return ServerResponse.createBySuccess(result);
    }

    @PostMapping(value = "/addCollageActivity")
    @ApiOperation(value = "新增拼团活动", notes = "新增拼团活动", httpMethod = "POST")
    public ServerResponse addCollageActivity(@RequestBody MallGoodsCollageActivityAddVO vo) {
         int result = goodsCollageService.addCollageActivity(vo);
        if(result == 0){
            return ServerResponse.createByError("新增或者修改拼团活动失败!");
        }else{
            return ServerResponse.createBySuccess("新增或者修改拼团活动成功!");
        }
    }

    @PostMapping(value = "/updateCollageActivity")
    @ApiOperation(value = "修改拼团活动", notes = "修改拼团活动", httpMethod = "POST")
    public ServerResponse updateCollageActivity(@RequestBody MallGoodsCollageActivityAddVO vo) {
        int result = goodsCollageService.updateCollageActivity(vo);
        if(result == 0){
            return ServerResponse.createByError("新增或者修改拼团活动失败!");
        }else{
            return ServerResponse.createBySuccess("新增或者修改拼团活动成功!");
        }
    }

    @PostMapping(value = "/delCollageActivity")
    @ApiOperation(value = "删除拼团活动", notes = "删除拼团活动", httpMethod = "POST")
    public ServerResponse delCollageActivity(@RequestBody CollageActivityIdVO vo) {
        int result = goodsCollageService.delCollageActivity(vo);
        if(result == 0){
            return ServerResponse.createByError("删除拼团活动失败!");
        }else{
            return ServerResponse.createBySuccess("删除拼团活动成功!");
        }
    }

    @PostMapping(value = "/getCollageList")
    @ApiOperation(value = "获取拼团列表", notes = "获取拼团列表", httpMethod = "POST")
    public ServerRespage<List<MallGoodsCollageVO>> getCollageList(@RequestBody MallGoodsCollageQueryVO vo) {
        List<MallGoodsCollageVO> list = goodsCollageService.getCollageList(vo);
        if(list == null){
            return ServerRespage.createByErrorMessage("未获取到相关数据！");
        }
        return ServerRespage.createBySuccessPage(list,vo.getPage());
    }

    @PostMapping(value = "/collageActivityLose")
    @ApiOperation(value = "拼团活动失效", notes = "拼团活动失效", httpMethod = "POST")
    public ServerResponse collageActivityLose(@RequestBody CollageActivityIdVO vo) {
        int result = goodsCollageService.collageActivityLose(vo);
        if(result == 0){
            return ServerResponse.createByError("拼团活动失效失败!");
        }else{
            return ServerResponse.createBySuccess("删除拼团失效成功!");
        }
    }


}
