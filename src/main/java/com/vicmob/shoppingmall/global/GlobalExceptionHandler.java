
package com.vicmob.shoppingmall.global;

import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author vicmob
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @ExceptionHandler(Exception.class)
    public ResultData handleException(HttpServletRequest request, Exception e){
    	log.error("path==>{}", request.getRequestURI());
    	log.error(e.getMessage(), e);
        return new ResultData("系统异常", ResponseStatus.FAIL.getValue());
    }
    
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultData handleHttpRequestMethodNotSupportedException(HttpServletRequest request, HttpRequestMethodNotSupportedException e) {
    	log.error("path==>{}", request.getRequestURI());
    	log.error(e.getMessage(), e);
        return new ResultData("请求方法错误", ResponseStatus.FAIL.getValue());
    }
    
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultData handleMissingServletRequestParameterException(HttpServletRequest request, MissingServletRequestParameterException e) {
    	log.error("path==>{}", request.getRequestURI());
    	log.error(e.getMessage(), e);
        return new ResultData("请求参数错误", ResponseStatus.FAIL.getValue());
    }

    //处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultData handleConstraintViolationException(HttpServletRequest request, ConstraintViolationException e) {
        log.error("path==>{}", request.getRequestURI());
        log.error(e.getMessage(), e);
        String message = StringUtils.getViolationMessage(e.getMessage());
        return new ResultData(message, ResponseStatus.FAIL.getValue());
    }

    //处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultData methodArgumentNotValidExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.error("path==>{}", request.getRequestURI());
        log.error(e.getMessage(), e);
        String message = e.getBindingResult().getFieldError().getDefaultMessage();

        return new ResultData(message, ResponseStatus.FAIL.getValue());
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ResultData InvalidDefinitionExceptionHandler(HttpServletRequest request, HttpMessageConversionException e) {
        log.error("path==>{}", request.getRequestURI());
        log.error(e.getMessage(), e);
        String message =  StringUtils.getViolationMessage(e.getMessage());
        return new ResultData("未传参,参数异常！", ResponseStatus.FAIL.getValue());
    }
}
