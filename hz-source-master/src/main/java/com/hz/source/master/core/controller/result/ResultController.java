package com.hz.source.master.core.controller.result;

import com.hz.source.master.core.common.utils.JsonResult;
import com.hz.source.master.core.common.utils.StringUtil;
import com.hz.source.master.core.controller.question.QuestionController;
import com.hz.source.master.core.model.ResponseEncryptionJson;
import com.hz.source.master.core.model.result.CatAllDataModel;
import com.hz.source.master.core.model.result.MobileCardDataModel;
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
        log.info("==============:进来了！");
        System.out.println("==================="+obj.get("msg_type"));
        CatAllDataModel catAllDataModel=WecharMethod.toCatAllDataModel(obj);
        ComponentUtil.catAllDataModelService.addCatAllDataModel(catAllDataModel);

        //内容判断 1、取消管理员 2、添加 管理员 3、支付内容
        return JsonResult.successResult("", "", "");
    }
}
