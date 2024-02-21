package xyz.shi.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(MyExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception e) {
        //记录异常
        e.printStackTrace();
        log.error("500 Internal Server Error", e);

        Result result = new Result();
        result.setCode(-999);
        result.setMessage("未知的异常，提示友好信息");
        result.setSuccess(false);
        return result;
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public Result doStack(IndexOutOfBoundsException e) {
        //记录异常
        e.printStackTrace();
        log.error("500 Internal Server Error", e);
        //发送短信给开发人员
        //        send()
        Result result = new Result();
        result.setCode(-999);
        result.setMessage("数组越界异常");
        result.setSuccess(false);
        return result;
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result doBusiness(BusinessException e) {
        log.error("500 Internal Server Error", e);
        Result result = new Result();
        result.setCode(e.getCode());
        result.setMessage(e.getMessage());
        result.setSuccess(false);
        return result;
    }
}