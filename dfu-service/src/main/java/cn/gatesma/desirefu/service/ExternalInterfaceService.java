package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.AddNormalAccountRequest;
import cn.gatesma.desirefu.domain.api.generate.CodeToWxOpenIdRequest;
import cn.gatesma.desirefu.util.MpApiHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author gatesma
 * @date 2020/12/21 3:09 下午
 * @desc
 */
@Service
public class ExternalInterfaceService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExternalInterfaceService.class);

    @Value("${wx.api.appId}")
    private String appId;

    @Value("${wx.api.appSecret}")
    private String appSecret;


    public String code2WXOpenId(CodeToWxOpenIdRequest request) {

        String code = request.getCode();

        try {
            String openId = MpApiHelper.genOpenIdFromCodeByAppIdAndSecret(appId, appSecret, code);
            LOGGER.info("[ExternalInterfaceService] code2WXOpenId code={}, openId={}", code, openId);
            return openId;
        } catch (Exception e) {
            throw new CustomerApiException(ApiReturnCode.EXTERNAL_INTERFACE_ERROR, "请求wx接口出错：" + e.getMessage());
        }
    }


}
