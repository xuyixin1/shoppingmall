package com.vicmob.shoppingmall.web.goods.controller;


import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.MySqlUtils;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.utils.ResultDataFactory;
import com.vicmob.shoppingmall.web.goods.entity.GoodsClassify;
import com.vicmob.shoppingmall.web.goods.service.GoodsClassifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * 商品分类Controller
 * @author xyx
 */
@Api(tags="商品一级分类相关接口")
@Validated
@RestController
@RequestMapping(value = "/onlineShop/goodsClassify")
public class GoodsClassifyController {
	private final Logger log = LoggerFactory.getLogger(GoodsClassifyController.class);
	@Autowired
	private GoodsClassifyService goodsClassifyService;

	/**
	 *
	 * @param classifyName
	 * @param page
	 * @param size
	 * @return
	 */
	@GetMapping(value = "findAllList")
	@ApiOperation(value="查询一级分类列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "classifyName", value = "一级分类名称"),
			@ApiImplicitParam(name = "minaId", value = "小程序id", required = true),
			@ApiImplicitParam(name = "page", value = "当前页码", required = true),
			@ApiImplicitParam(name = "size", value = "每页条数", required = true)
	})
	public ResultData getGoodsClassifyList(@RequestParam(required=false) String classifyName,
							   @NotNull(message ="page不能为空") @Min(value = 1,message ="page不能小于1")@RequestParam Integer page,
							   @NotNull(message ="size不能为空") @Min(value = 1,message ="size不能小于1")@RequestParam Integer size,
							   @NotNull(message ="minaId不能为空") @RequestParam Integer minaId) {
		try{
			GoodsClassify goodsClassify = new GoodsClassify();
			if(!StringUtils.isEmpty(classifyName)) {
				goodsClassify.setClassifyName(MySqlUtils.specialStr(classifyName));
			}
			List<GoodsClassify> list = goodsClassifyService.getGoodsClassifyList(goodsClassify,minaId,page,size);
			return ResultDataFactory.getResultData(list);

		}catch(Exception e){
			log.error("获取商品分类列表失败,mianId ==>{}，classifyName ==>{}",minaId,classifyName );
			log.error(e.getMessage(), e);
			return  new ResultData("获取商品分类列表失败", ResponseStatus.FAIL.getValue());
		}
	}

	@GetMapping(value = "")
	@ApiOperation(value="查询一级分类数据（不分页）")
	@ApiImplicitParam(name = "minaId", value = "小程序id",required = true)
	public ResultData getGoodsClassifyList(@NotNull(message ="minaId不能为空") @RequestParam Integer minaId) {
		ResultData result = null;
		try{
			result = goodsClassifyService.getGoodsClassifyList(minaId);
		}catch(Exception e){
			log.error("获取商品分类列表失败,mianId ==>{}",minaId);
			log.error(e.getMessage(), e);
			result = new ResultData("获取商品分类列表失败", ResponseStatus.FAIL.getValue());
		}
		return result;
	}


	@GetMapping(value = "{classifyId}")
	@ApiOperation(value="查询一级分类数据")
	@ApiImplicitParam(name = "classifyId", value = "一级分类id",required = true)
	public ResultData getClassify(@Min(value = 1,message ="classifyId不能小于1")@PathVariable("classifyId") Integer classifyId) {
		ResultData result = null;
		try{
			GoodsClassify goodsClassify = goodsClassifyService.getByClassifyId(classifyId);
			if (goodsClassify == null){
				log.error("获取商品分类详情失败，classifyId ==>{}",classifyId );
				result = new ResultData("获取商品分类详情失败", ResponseStatus.FAIL.getValue());
			}else{
				result = new ResultData("success", ResponseStatus.SUCCESS.getValue(),goodsClassify);
			}
		}catch(Exception e){
			log.error("获取商品分类详情失败，classifyId ==>{}",classifyId );
			log.error(e.getMessage(), e);
			result = new ResultData("获取商品分类详情失败", ResponseStatus.FAIL.getValue());
		}

		return result;
	}
	
	/**
	 * 添加
	 * @return
	 */
	@PostMapping(value = "")
	@ApiOperation(value="添加一级分类列表")
	public ResultData addGoodsClassify(@RequestBody  @Valid GoodsClassify goodsClassify ) {
		ResultData result = null;
		try {
			result = goodsClassifyService.addGoodsClassify(goodsClassify);
		} catch (Exception e) {
			log.error("商品分类插入失败 goodsClassify =>{}", goodsClassify);
			log.error(e.getMessage(), e);
			result = new ResultData("商品分类插入失败", ResponseStatus.FAIL.getValue());
		}
		return result;
	}


	/**
	 * 更新
	 * @return
	 */
	@PutMapping(value = "")
	@ApiOperation(value="更新一级分类列表")
	public ResultData updateGoodsClassify(@RequestBody  @Valid GoodsClassify goodsClassify) {
		ResultData result = null;
		try {
			if(goodsClassify.getClassifyId() == null ||goodsClassify.getClassifyId() <= 0){
				log.error("验证商品分类参数失败,classifyId不存在或者小于0，goodsClassify ==>{}",goodsClassify);
				result = new ResultData("验证商品分类参数失败,classifyId不存在或者小于0", ResponseStatus.FAIL.getValue());
			}else{
				result = goodsClassifyService.updateGoodsClassify(goodsClassify);
			}
		} catch (Exception e) {
			log.error("商品分类更新失败 goodsClassify =>{}", goodsClassify);
			log.error(e.getMessage(), e);
			result = new ResultData("商品分类更新失败", ResponseStatus.FAIL.getValue());
		}
		return result;
	}

	@DeleteMapping(value = "{classifyId}")
	@ApiOperation(value="删除一级分类数据")
	@ApiImplicitParam(name = "classifyId", value = "一级分类id",required = true)
	public ResultData deteleGoodsClassify(@Min(value = 1,message ="classifyId不能小于1")@PathVariable("classifyId") Integer classifyId){
		ResultData result = null;
		try{
			result = goodsClassifyService.deleteGoodsClassify(classifyId);
		} catch (Exception e) {
			log.error("商品分类删除失败 classifyId =>{}", classifyId);
			log.error(e.getMessage(), e);
			result = new ResultData("商品分类删除失败", ResponseStatus.FAIL.getValue());
		}
		return result;
	}
}