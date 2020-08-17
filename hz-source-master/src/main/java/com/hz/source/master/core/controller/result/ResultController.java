package com.hz.source.master.core.controller.result;

import com.alibaba.fastjson.JSON;
import com.hz.source.master.core.common.utils.JsonResult;
import com.hz.source.master.core.common.utils.StringUtil;
import com.hz.source.master.core.controller.question.QuestionController;
import com.hz.source.master.core.model.ResponseEncryptionJson;
import com.hz.source.master.core.model.result.CatAllDataModel;
import com.hz.source.master.core.model.result.ClientAllDataModel;
import com.hz.source.master.core.model.result.MobileCardDataModel;
import com.hz.source.master.core.model.result.WxAllDataModel;
import com.hz.source.master.core.model.sms.SmsData;
import com.hz.source.master.core.model.wechar.LovelyCatData;
import com.hz.source.master.util.ComponentUtil;
import com.hz.source.master.util.WecharMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2020/5/11 10:06
 * @Version 1.0
 */
@RestController
@RequestMapping("/source/rs")
public class ResultController {
    private static Logger log = LoggerFactory.getLogger(ResultController.class);


//    http://192.168.1.156:8087/source/rs/sms_rs

    @RequestMapping(value = "/sms", method = {RequestMethod.POST})
    public JsonResult<Object> smsRs(HttpServletRequest request, HttpServletResponse response, @RequestBody SmsData smsData) throws Exception{
        String sgid = ComponentUtil.redisIdService.getNewId();
        String cgid = "";
        String token;
        String ip = StringUtil.getIpAddress(request);

        String data = "";
        log.error("SecretKey:"+smsData.getSecretKey());
        log.error("sender:"+smsData.getSender());
        log.error("PhoneId:"+smsData.getPhoneId());
        log.error("Content:"+smsData.getContent());
        boolean  flag  =   WecharMethod.isEffectiveSmsData(smsData);//是否有效

        if(!flag){
            return JsonResult.failedResult("", "", "400");
        }

        MobileCardDataModel mobileCardDataModel = WecharMethod.toSmsData(smsData);

        try{
            ComponentUtil.mobileCardDataService.addMobileCardData(mobileCardDataModel);
            ResponseEncryptionJson resultDataModel = new ResponseEncryptionJson();
            resultDataModel.jsonData = "ok";
            // 返回数据给客户端
            return JsonResult.successResult(resultDataModel, cgid, sgid);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.failedResult("数据异常","500");
        }


//        mobileCardDataService

    }

    @PostMapping(value = "/wechat")
    public JsonResult<Object> wechat(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, Object> obj) throws Exception{
        //判断是需要的状态码
//        ComponentUtil.dispatchService.disp(lovelyCatData);
        log.info("==============:wechat 进来了！");
        log.info("==============:map"+obj);
        System.out.println("==================="+obj.get("msg_type"));
        CatAllDataModel catAllDataModel=WecharMethod.toCatAllDataModel(obj);
        ComponentUtil.catAllDataModelService.addCatAllDataModel(catAllDataModel);

        //内容判断 1、取消管理员 2、添加 管理员 3、支付内容
        return JsonResult.successResult("", "", "");
    }


//    @GetMapping(value = "/newWechat")
//    public JsonResult<Object> newWechat(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, Object> obj) throws Exception{
//        //判断是需要的状态码
////        ComponentUtil.dispatchService.disp(lovelyCatData);
//        log.info("==============:wechat 进来了！");
//        log.info("==============:map"+obj);
//        System.out.println("==================="+obj.get("msg_type"));
//        CatAllDataModel catAllDataModel=WecharMethod.toCatAllDataModel(obj);
//        ComponentUtil.catAllDataModelService.addCatAllDataModel(catAllDataModel);
//
//        //内容判断 1、取消管理员 2、添加 管理员 3、支付内容
//        return JsonResult.successResult("", "", "");
//    }


    /**
     * @Description: 接收阿里支付宝的数据-APP
     * @param request
     * @param response
     * @return com.gd.chain.common.utils.JsonResult<java.lang.Object>
     * @author yoko
     * @date 2019/11/25 22:58
     * local:http://localhost:8082/ad/ad/getNotify
     */
    @RequestMapping(value = "/newwechat", method = {RequestMethod.GET})
    public void newwechat(HttpServletRequest request, HttpServletResponse response,@RequestParam Map<String, Object> obj) throws Exception{
        try{
            log.error("ResultController.newwechat()----------进来了!");
            log.error("ResultController.newwechat():" + JSON.toJSON(obj));

            String dataStr = "";
            if (obj != null && obj.size() > 0){
                dataStr = obj.get("data").toString();
                dataStr = StringUtil.decoderBase64ByUTF8(dataStr);
                dataStr = dataStr.replaceAll("\"", "~");
                dataStr = dataStr.replaceAll("'", "\"");
                WxAllDataModel wxAllDataModel= WecharMethod.toWxAllDataModel(dataStr);
                ComponentUtil.wxAllDataModelService.add(wxAllDataModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @PostMapping(value = "/alNotice")
    public JsonResult<Object> alNotice(HttpServletRequest request, HttpServletResponse response, @RequestBody Object obj) throws Exception{
        //判断是需要的状态码
//        ComponentUtil.dispatchService.disp(lovelyCatData);
        log.error("ResultController.alNotice():" + JSON.toJSON(obj));
        ClientAllDataModel clientAllDataModel = WecharMethod.toClientAllDataModel(JSON.toJSON(obj).toString());
        ComponentUtil.clientAllDataModelService.addClientAllDataModel(clientAllDataModel);

        //内容判断 1、取消管理员 2、添加 管理员 3、支付内容
        return JsonResult.successResult("", "", "");
    }


}
