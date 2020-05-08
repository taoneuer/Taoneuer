package com.sly.c2cpay.pojo;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 处理全局异常
 */
@RestControllerAdvice
public class CustomExtHandler  {


    /**
     * 处理全局异常
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultInfo handleException(Exception e, HttpServletRequest request){
        return new ResultInfo(-1, null, e.getMessage(), request.getRequestURI());


    }
}
