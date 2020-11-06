
package cn.gatesma.desirefu.utils;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.ReturnCode;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class RetCodeUtils {

  public static boolean isOk(Integer retCode){
    return Objects.equals(retCode, ApiReturnCode.OK.code());
  }
  
  public static boolean isOk(ReturnCode retCode) {
    return retCode!=null&&retCode.getCode()!=null&&retCode.getCode().intValue()==ApiReturnCode.OK.code();
  }
  
  public static boolean isNotOk(ReturnCode retCode) {
    return !isOk(retCode);
  }

  public static boolean isResourceNotFound(ReturnCode retCode) {
    return null != retCode && null != retCode.getCode() && retCode.getCode().intValue() == ApiReturnCode.RESOURCE_NOT_FOUND.code();
  }
  
  public static ReturnCode ok() {
    return new ReturnCode().code(ApiReturnCode.OK.code()).message(ApiReturnCode.OK.name());
  }
  
  public static <T extends ReturnCode> T ok(T retCode) {
    retCode.setCode(ApiReturnCode.OK.code());
    retCode.setMessage(ApiReturnCode.OK.name());
    return retCode;
  }
  
  public static ReturnCode create(ApiReturnCode code,String msg) {
    return new ReturnCode().code(code.code()).message(msg);
  }

  public static ReturnCode create(Integer code,String msg) {
    return new ReturnCode().code(code).message(msg);
  }
  
  public static <T extends ReturnCode> T create(T retCode,ApiReturnCode code,String msg) {
    retCode.setCode(code.code());
    retCode.setMessage(msg);
    return retCode;
  }

  public static <T extends ReturnCode> T create(T retCode,int code,String msg) {
    retCode.setCode(code);
    retCode.setMessage(msg);
    return retCode;
  }

  public static <T extends ReturnCode> T create(T retCode,ReturnCode template) {
    retCode.setCode(template.getCode());
    retCode.setMessage(template.getMessage());
    return retCode;
  }

  public static void throwExceptionIfNotOk(ReturnCode ret){
    if(isNotOk(ret)){
      throw exceptionOf(ret);
    }
  }

  public static CustomerApiException exceptionOf(ReturnCode ret){
    ApiReturnCode code=(ret==null||ret.getCode()==null)?ApiReturnCode.INNER_ERROR:ApiReturnCode.parseCode(ret.getCode());
    String message=(ret==null||ret.getMessage()==null)?ApiReturnCode.INNER_ERROR.name():ret.getMessage();
    return new CustomerApiException(code,message);
  }

  public static <T extends ReturnCode> T retCodeOf(CustomerApiException e,T template){
    ApiReturnCode retCode = (e == null || e.getRetCode() == null) ? ApiReturnCode.INNER_ERROR : e.getRetCode();
    String msg = (e == null || StringUtils.isBlank(e.getMessage())) ? ApiReturnCode.INNER_ERROR.name() : e.getMessage();
    template.setCode(retCode.code());
    template.setMessage(msg);
    return template;
  }
  
}

