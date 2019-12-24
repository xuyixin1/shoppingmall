package com.vicmob.shoppingmall.web.goods.controller;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.goods.entity.Slide;
import com.vicmob.shoppingmall.web.goods.service.SlideService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Api(tags = "幻灯片相关接口")
@RestController
@Validated
@RequestMapping("/onlineShop/slide")
public class SlideController {
    private final Logger log = LoggerFactory.getLogger( SlideController.class);

    @Autowired
    private SlideService slideService;
    @GetMapping(value = "")
    @ApiOperation(value="查询幻灯片列表")
    @ApiImplicitParam(name = "minaId", value = "小程序id", required = true)
    public ResultData getSlideList(@NotNull(message ="minaId不能为空") @RequestParam Integer minaId) {
        ResultData result = null;
        try{
            result = slideService.getSlideList(minaId);
        }catch(Exception e){
            log.error("获取幻灯片列表失败,mianId ==>{}",minaId);
            log.error(e.getMessage(), e);
            result = new ResultData("获取幻灯片列表失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }


    @GetMapping(value = "{slideId}")
    @ApiOperation(value="查询幻灯片数据")
    @ApiImplicitParam(name = "slideId", value = "幻灯片id",required = true)
    public ResultData getSlide(@Min(value = 1,message ="slideId不能小于1")@PathVariable("slideId") Integer slideId) {
        ResultData result = null;
        try{
            Slide slide = slideService.getByslideId(slideId);
            if (slide == null){
                log.error("获取幻灯片数据详情失败，slideId ==>{}",slideId);
                result = new ResultData("获取幻灯片数据详情失败", ResponseStatus.FAIL.getValue());
            }else{
                result = new ResultData("sucess", ResponseStatus.SUCCESS.getValue(),slide);
            }
        }catch(Exception e){
            log.error("获取幻灯片数据详情失败，slideId ==>{}",slideId);
            log.error(e.getMessage(), e);
            result = new ResultData("获取幻灯片数据详情失败", ResponseStatus.FAIL.getValue());
        }

        return result;
    }

    /**
     * 添加
     * @return
     */
    @PostMapping(value = "")
    @ApiOperation(value="添加幻灯片")
    public ResultData addSlide(@RequestBody  @Valid Slide slide ) {
        ResultData result = null;
        try {
            result = slideService.addSlide(slide);
        } catch (Exception e) {
            log.error("幻灯片数据插入失败 slide =>{}", slide);
            log.error(e.getMessage(), e);
            result = new ResultData("幻灯片数据插入失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }


    /**
     * 更新
     * @return
     */
    @PutMapping(value = "")
    @ApiOperation(value="更新幻灯片数据")
    public ResultData updateSlide(@RequestBody  @Valid Slide slide) {
        ResultData result = null;
        try {
            if(slide.getSlideId() == null ||slide.getSlideId() <= 0){
                log.error("验证slideId参数失败,slideId不存在或者小于0，slide ==>{}",slide);
                result = new ResultData("验证slideId参数失败,slideId不存在或者小于0", ResponseStatus.FAIL.getValue());
            }else{
                result = slideService.updateSlide(slide);
            }
        } catch (Exception e) {
            log.error("更新幻灯片数据失败 slide ==>{}",slide);
            log.error(e.getMessage(), e);
            result = new ResultData("更新幻灯片数据失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    @DeleteMapping(value = "{slideId}")
    @ApiOperation(value="删除幻灯片数据")
    @ApiImplicitParam(name = "slideId", value = "幻灯片id",required = true)
    public ResultData deteleSlide(@Min(value = 1,message ="slideId不能小于1")@PathVariable("slideId") Integer slideId){
        ResultData result = null;
        try{
            result = slideService.deteleSlide(slideId);
        } catch (Exception e) {
            log.error("商品分类删除失败 slideId ==>{}",slideId);
            log.error(e.getMessage(), e);
            result = new ResultData("商品分类删除失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }


    @GetMapping(value = "updateUseFlag/{slideId}")
    @ApiOperation(value="更新商品上下架状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "slideId", value = "幻灯片id",required = true),
            @ApiImplicitParam(name = "useFlag", value = "启用状态",required = true)
    })
    public ResultData updateUseFlag(@PathVariable Integer slideId,
                                     @RequestParam Constant.Flag useFlag){
        ResultData result = null;
        try{
            result = slideService.updateUseFlag(slideId,useFlag);
        }catch(Exception e){
            log.error("更新幻灯片使用状态失败,slideId ==>{}，useFlag ==>{}",slideId,useFlag );
            log.error(e.getMessage(), e);
            result = new ResultData("更新幻灯片使用状态失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }
}
