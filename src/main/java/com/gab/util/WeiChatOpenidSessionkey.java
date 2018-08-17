package com.gab.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class WeiChatOpenidSessionkey {
	public Map getOpenId(HttpServletRequest request,HttpServletResponse response){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = "1";
        String msg = "ok";
        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        try {
            String code = request.getParameter("code");
            if(StringUtils.isBlank(code)){
                status = "0";//失败状态
                msg = "code为空";
            }else {
            			/*String requestUrl = WX_URL.replace("APPID", "1wqas2342dasaqwe2323424ac23qwe").
                        replace("SECRET", WeixinConstants.APP_SECRECT).replace("JSCODE", "").
                        replace("authorization_code", WeixinConstants.AUTHORIZATION_CODE);
               // logger.info(requestUrl);
                // 发起GET请求获取凭证
                JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
                if (jsonObject != null) {
                    try {
                        map.put("openid", jsonObject.getString("openid"));
                        map.put("session_key", jsonObject.getString("session_key"));
                    } catch (JSONException e) {
                        // 获取token失败
                        status = "0";
                        msg = "code无效";
                    }
                }else {
                    status = "0";
                    msg = "code无效";
                }*/
            }
            map.put("status", status);
            map.put("msg", msg);
        } catch (Exception e) {
            //logger.error(e.getMessage(),e);
           // return AnalyzeMoblieData.errorResponse();
        }
        return map;

    }
}
