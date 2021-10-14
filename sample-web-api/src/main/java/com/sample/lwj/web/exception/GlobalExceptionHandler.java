package com.sample.lwj.web.exception;

import com.sample.lwj.exception.BizException;
import com.sample.lwj.utils.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 全局异常处理
 * @date 2021/8/3 9:48
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    public ResultData globalException(Exception e) {
        logger.error(e.getMessage(), e);
        return ResultData.error();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BizException.class})
    public ResultData bizException(BizException e) {
        logger.error(e.getMessage(), e);
        return ResultData.fail(e.getCode(), e.getMsg());
    }
}
