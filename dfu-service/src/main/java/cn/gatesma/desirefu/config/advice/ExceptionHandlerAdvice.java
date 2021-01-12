package cn.gatesma.desirefu.config.advice;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.Global;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.ReturnCode;
import cn.gatesma.desirefu.exception.RPCException;
import cn.gatesma.desirefu.utils.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * User: gatesma
 * Date: 2020-11-28
 * Desc: 错误处理
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ReturnCode> handleException(HttpMessageNotReadableException exception, HttpServletRequest request) {
        return new ResponseEntity<ReturnCode>(generateReturnCode(request, ApiReturnCode.HTTP_REQUEST_MAPPING_ERROR.code(), exception.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ReturnCode> handleException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        return new ResponseEntity<ReturnCode>(generateReturnCode(request, ApiReturnCode.HTTP_REQUEST_MAPPING_ERROR.code(), exception.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ReturnCode> handleException(HttpMediaTypeNotSupportedException exception, HttpServletRequest request) {
        return new ResponseEntity<ReturnCode>(generateReturnCode(request, ApiReturnCode.HTTP_REQUEST_MAPPING_ERROR.code(), exception.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ReturnCode> handleException(MaxUploadSizeExceededException exception, HttpServletRequest request) {
        return new ResponseEntity<ReturnCode>(generateReturnCode(request, ApiReturnCode.UPLOAD_FILE_EXCEEDS_LIMIT.code(), "上传文件超过最大限制"), HttpStatus.OK);
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    public ResponseEntity<ReturnCode> handleException(MissingServletRequestPartException exception, HttpServletRequest request) {
        return new ResponseEntity<ReturnCode>(generateReturnCode(request, ApiReturnCode.UPLOAD_FILE_EMPTY_ERROR.code(), "上传文件为空"), HttpStatus.OK);
    }

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<ReturnCode> handleException(MultipartException exception, HttpServletRequest request) {
        return new ResponseEntity<ReturnCode>(generateReturnCode(request, ApiReturnCode.UPLOAD_FILE_PARSE_ERROR.code(), "文件上传解析错误"), HttpStatus.OK);
    }

    @ExceptionHandler(CustomerApiException.class)
    public ResponseEntity<ReturnCode> handleException(CustomerApiException exception, HttpServletRequest request) {
        LOGGER.error("Logic Error：", exception);
        return new ResponseEntity<ReturnCode>(generateReturnCode(request, exception.getRetCode().code(), exception.getMessage(), false), HttpStatus.OK);
    }

    // RPCException
    @ExceptionHandler(RPCException.class)
    public ResponseEntity<ReturnCode> handleException(RPCException exception, HttpServletRequest request) {
        LOGGER.error("Logic Error：", exception);
        return new ResponseEntity<ReturnCode>(generateReturnCode(request, exception.getRetCode().code(), exception.getMessage(), false), HttpStatus.OK);
    }

    @ExceptionHandler(AsyncRequestTimeoutException.class)
    public ResponseEntity<ReturnCode> handleException(AsyncRequestTimeoutException exception, HttpServletRequest request) {
        LOGGER.error("Timeout Error：", exception);
        String msg = "接口调用超时";
        return new ResponseEntity<>(generateReturnCode(request, ApiReturnCode.PROCESS_TIMEOUT_ERROR.code(), msg, false), HttpStatus.OK);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ReturnCode> handleException(Throwable exception, HttpServletRequest request) {
        // 获取嵌套内层的异常
        Throwable targetException = getTargetException(exception);
        // 处理异常
        if (targetException instanceof CustomerApiException) {
            return handleException((CustomerApiException) targetException, request);
        } else {
            LOGGER.error("System Error：", targetException);
            String msg = StringUtils.isBlank(targetException.getMessage()) ? "系统错误：[" + targetException.toString() + "]" : targetException.getMessage();
            return new ResponseEntity<ReturnCode>(generateReturnCode(request, ApiReturnCode.INNER_ERROR.code(), msg, true), HttpStatus.OK);
        }
    }

    private Throwable getTargetException(Throwable exception) {
        if (exception instanceof UndeclaredThrowableException) {
            Throwable undeclaredThrowable = ((UndeclaredThrowableException) exception).getUndeclaredThrowable();
            if (undeclaredThrowable instanceof InvocationTargetException) {
                return ((InvocationTargetException) undeclaredThrowable).getTargetException();
            }
        }
        return exception;
    }

    /**
     * 生成ReturnCode && 记录异常信息
     *
     * @param request
     * @param errorCode
     * @param errorMsg
     */
    private ReturnCode generateReturnCode(HttpServletRequest request, int errorCode, String errorMsg) {
        return generateReturnCode(request, errorCode, errorMsg, false);
    }

    /**
     * 生成ReturnCode && 记录异常信息
     *
     * @param request
     * @param errorCode       错误码
     * @param errorMsg        错误消息
     * @param isReportedError 异常是否上报MO
     * @return
     */
    private ReturnCode generateReturnCode(HttpServletRequest request, int errorCode, String errorMsg, boolean isReportedError) {
        String url = request.getContextPath() + request.getServletPath();
        String client = CommonUtils.safeGetStringFromObj(request.getHeader(Global.PROXY_CLIENT), "UNKNOWN");
        String clientId = CommonUtils.safeGetStringFromObj(request.getHeader(Global.PROXY_CLIENT_ID), "UNKNOWN");
        request.setAttribute(Global.REQ_ERROR_MESSAGE, StringUtils.trimToEmpty(errorMsg));
        request.setAttribute(Global.REQ_ERROR_CODE, errorCode);

        LOGGER.error("ReturnCode errorMsg: Client Id=[{}],Name=[{}],interface=[{}],isReportedMo=[{}],errorMsg=[{}]",
                clientId, client, url, isReportedError, StringUtils.trimToEmpty(errorMsg));
        ReturnCode retCode = new ReturnCode();
        retCode.setCode(errorCode);
        retCode.setMessage(errorMsg);
        return retCode;
    }


}
