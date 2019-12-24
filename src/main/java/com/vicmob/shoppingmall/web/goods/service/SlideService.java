package com.vicmob.shoppingmall.web.goods.service;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.goods.dao.SlideMapper;
import com.vicmob.shoppingmall.web.goods.entity.Slide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlideService {
    private final Logger log = LoggerFactory.getLogger(SlideService.class);

    @Autowired
    private SlideMapper slideMapper;

    public ResultData getSlideList(Integer minaId){
        List<Slide> slideList  = slideMapper.getSlideList(minaId);
        return new ResultData("success", ResponseStatus.SUCCESS.value,slideList);
    }

    public Slide getByslideId(Integer slideId){
        return slideMapper.getByslideId(slideId);
    }


    public ResultData addSlide(Slide slide){
        List<Slide> slideList  = slideMapper.getSlideList(slide.getMinaId());
        if (slideList != null && slideList.size() >= 4){
            log.error("幻灯片数量已超过最大限制，添加失败 minaId ==>{}",slide.getMinaId());
            return  new ResultData("幻灯片数量已超过最大限制，添加失败", ResponseStatus.FAIL.value);
        }
        if (slideMapper.addSlide(slide) != 1){
            log.error("幻灯片添加失败 slide ==>{}",slide);
            return  new ResultData("幻灯片添加失败", ResponseStatus.FAIL.value);
        }
        return new ResultData("success", ResponseStatus.SUCCESS.value);
    }

    public ResultData updateSlide(Slide slide){
        if (slideMapper.updateSlide(slide) != 1){
            log.error("幻灯片更新失败 slide ==>{}",slide);
            return  new ResultData("幻灯片更新失败", ResponseStatus.FAIL.value);
        }
        return new ResultData("success", ResponseStatus.SUCCESS.value);
    }

    public ResultData deteleSlide(Integer slideId){
        if (slideMapper.deteleSlide(slideId) != 1){
            log.error("幻灯片删除失败 slideId ==>{}",slideId);
            return  new ResultData("幻灯片删除失败", ResponseStatus.FAIL.value);
        }
        return new ResultData("success", ResponseStatus.SUCCESS.value);
    }


    public ResultData updateUseFlag(Integer slideId, Constant.Flag useFlag){
        if  (slideMapper.updateUseFlag(slideId,useFlag)!= 1){
            log.error("更新幻灯片使用状态失败，slideId ==>{}，useFlag ==>{}",slideId,useFlag);
            return new ResultData("更新幻灯片使用状态失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }
}
