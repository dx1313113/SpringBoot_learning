package com.whgcdx.demo1.handler;


import com.whgcdx.demo1.domain.response.ResponseCodeConst;
import com.whgcdx.demo1.domain.response.ResponseResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.handler
 * @className: ProjectExceptionAdvice
 * @author: dx
 * @description: TODO
 * @date: 2023/10/7 12:58
 * @version: 1.0
 */

@Slf4j
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResultDTO doException (Exception e){
        log.error("error:" ,e);
        /* http 请求错误 */
        if (e instanceof HttpRequestMethodNotSupportedException){
            return ResponseResultDTO.wrap(ResponseCodeConst.REQUEST_METHOD_ERROR);
        }
        /* 参数类型错误 */
        if (e instanceof TypeMismatchException){
            return ResponseResultDTO.wrap(ResponseCodeConst.ERROR_PARAM);
        }
        // json 格式错误
        if (e instanceof HttpMessageNotReadableException) {
            return ResponseResultDTO.wrap(ResponseCodeConst.JSON_FORMAT_ERROR);
        }
        // 参数校验未通过
        if (e instanceof MethodArgumentNotValidException) {
            List<FieldError> fieldErrors = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors();
            List<String> msgList = fieldErrors.stream().map(FieldError :: getDefaultMessage).collect(Collectors.toList());
            return ResponseResultDTO.wrap(ResponseCodeConst.ERROR_PARAM, String.join(",", msgList));
        }

        return ResponseResultDTO.wrap(ResponseCodeConst.SYSTEM_ERROR);
    }
}
