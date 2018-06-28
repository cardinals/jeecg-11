package com.jeecg.emay;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jeecg.emay.eucp.inter.http.v1.dto.response.BalanceResponse;
import com.jeecg.emay.eucp.inter.http.v1.dto.response.MoResponse;
import com.jeecg.emay.eucp.inter.http.v1.dto.response.ReportResponse;
import com.jeecg.emay.eucp.inter.http.v1.dto.response.ResponseData;
import com.jeecg.emay.eucp.inter.http.v1.dto.response.SmsResponse;
import com.jeecg.emay.util.DateUtil;
import com.jeecg.emay.util.JsonHelper;
import com.jeecg.emay.util.Md5;
import com.jeecg.emay.util.http.EmayHttpClient;
import com.jeecg.emay.util.http.EmayHttpRequestKV;
import com.jeecg.emay.util.http.EmayHttpResponseString;
import com.jeecg.emay.util.http.EmayHttpResponseStringPraser;
import com.jeecg.emay.util.http.EmayHttpResultCode;

import com.google.gson.reflect.TypeToken;
import org.jeecgframework.core.util.ResourceUtil;

import static com.jeecg.emay.SimpleExample.request;

/**
 * Created on 17/6/7.
 * 短信API产品的DEMO程序,工程中包含了一个SmsDemo类，直接通过
 * 执行main函数即可体验短信产品API功能(只需要将AK替换成开通了云通信-短信产品功能的AK即可)
 * 工程依赖了2个jar包(存放在工程的libs目录下)
 * 1:aliyun-java-sdk-core.jar
 * 2:aliyun-java-sdk-dysmsapi.jar
 *
 * 备注:Demo工程编码采用UTF-8
 * 国际短信发送请勿参照此DEMO
 */
public class EMSmsUitl {

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    static final String appId = ResourceUtil.getConfigByName("appId");
    static final String secretKey = ResourceUtil.getConfigByName("secretKey");
    static final String host = ResourceUtil.getConfigByName("host");
    static final String smsurl = ResourceUtil.getConfigByName("smsurl");


    public static String check(Map param) throws Exception, InterruptedException {


        return "";
    }

    /**
     * 发送个性短信
     */
    public static ResponseData setPersonalitySms( Map<String,String> mobileAndContents,String customSmsId,String extendedCode,String timerTime) {
        System.out.println("=============setPersonalitySms ==================");
        Map<String,String> params = new HashMap<String, String>();
        try {
            params.put("appId", appId);
            params.put("sign", Md5.md5((appId + secretKey + DateUtil.toString(new Date(), "yyyyMMddHHmmss")).getBytes()));
            params.put("timestamp", DateUtil.toString(new Date(), "yyyyMMddHHmmss"));
            for(String mobile : mobileAndContents.keySet()){
                params.put(mobile, URLEncoder.encode(mobileAndContents.get(mobile), "utf-8"));
            }
            if(customSmsId != null){
                params.put("customSmsId", customSmsId);
            }
            if(timerTime != null){
                params.put("timerTime", timerTime);
            }
            if(extendedCode != null){
                params.put("extendedCode", extendedCode);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String json =request(params, "http://" + host + smsurl);
        ResponseData<SmsResponse[]> data = null;
        if(json != null){
            data = JsonHelper.fromJson(new TypeToken<ResponseData<SmsResponse[]>>(){}, json);
            String code = data.getCode();
            if("SUCCESS".equals(code)){
                for (SmsResponse d : data.getData()) {
                    System.out.println("data:" + d.getMobile() + "," + d.getSmsId() + "," + d.getCustomSmsId());
                }
            }
        }
        System.out.println("=============end setPersonalitySms==================");
        return data;
    }

}
