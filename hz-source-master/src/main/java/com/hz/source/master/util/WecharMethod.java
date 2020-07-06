package com.hz.source.master.util;

import com.alibaba.fastjson.JSON;
import com.hz.source.master.core.common.utils.BeanUtils;
import com.hz.source.master.core.common.utils.DateUtil;
import com.hz.source.master.core.common.utils.MapUtil;
import com.hz.source.master.core.common.utils.StringUtil;
import com.hz.source.master.core.common.utils.constant.ServerConstant;
import com.hz.source.master.core.model.common.DateModel;
import com.hz.source.master.core.model.result.CatAllDataModel;
import com.hz.source.master.core.model.result.ClientAllDataModel;
import com.hz.source.master.core.model.result.MobileCardDataModel;
import com.hz.source.master.core.model.result.MobileCardDataModel;
import com.hz.source.master.core.model.sms.SmsData;
import com.hz.source.master.core.model.wechar.Msg;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2020/5/15 11:15
 * @Version 1.0
 */
public class WecharMethod {

    /**
     * @Description: TODO
     * @param msg
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @map  rs  yes 代表是支付助手 no  过滤的消息
     * @map  type 1、是取消收款助手  2、添加收款助手
     * @map  name   微信名称
     * @date 2020/5/15 16:15
     */
     public static   Map<String,Object>  isCollectionHelper(String msg){
         Map<String,Object>   map  =  new   HashMap<String,Object>();
         map.put("rs","no");
         map.put("type","");
         map.put("name","");

         //这里后续要替换strStart  strEnd
         String  rs= StringUtil.subString(msg,"<first_data><![CDATA[","已取消");
         if(!StringUtils.isBlank(rs)){
             map.put("rs","yes");
             map.put("type","1");
             map.put("name",rs);
             return map;
         }
         //这里后续要替换strStart  strEnd
         String  sueeseRs= StringUtil.subString(msg,"<first_data><![CDATA[你已接受","的邀请");
         if(!StringUtils.isBlank(sueeseRs)){
             map.put("rs","yes");
             map.put("type","2");
             map.put("name",sueeseRs);
             return map;
         }
         return map;
     }


    /**
     * @Description: 去除了（**）的方法返回参数和真实参数一样的
     * @param msg
     * @return com.hz.source.master.core.model.wechar.Msg
     * @date 2020/5/18 11:41
     */
    public static  Msg toPaymentInfo(String msg){
        Msg msgRes=JSON.parseObject(msg, Msg.class);
        if (!msgRes.getScene_desc().equals("店员收款完成")){
            return msgRes;
        }
        Integer   beginCount =  msgRes.getShopowner().indexOf("(");
        Integer   endCount =  msgRes.getShopowner().indexOf(")");
        String   deleltString =msgRes.getShopowner().substring(beginCount,endCount+1);
        String   name  = msgRes.getShopowner().replace(deleltString,"");
        msgRes.setShopowner(name);
        return  msgRes ;
    }


    /**
     * @Description: 获取当前系统时间
     * @param
     * @return com.pf.play.rule.core.model.DateModel
     * @date 2019/11/20 22:15
     */
    public  static DateModel  getDate(){
        Date date  = new Date();
        DateModel dateModel = new DateModel();
        dateModel.setCurday(DateUtil.getDayNumber(date));
        dateModel.setCurhour(DateUtil.getHour(date));
        dateModel.setCurminute(DateUtil.getCurminute(date));
        dateModel.setCreateTime(date);
        dateModel.setUpdateTime(date);
        return dateModel;
    }


    /**
     * @Description: 给sms 短信接口的数据转换成MobileCardData
     * @param smsData
     * @return com.hz.source.master.core.model.result.FnMobileCardDataModel
     * @date 2020/5/20 11:15
     */
    public   static MobileCardDataModel toSmsData(SmsData smsData){
        DateModel dateModel =WecharMethod.getDate();
        MobileCardDataModel   fnMobileCardDataModel = new   MobileCardDataModel();
        BeanUtils.copy(dateModel,fnMobileCardDataModel);
        fnMobileCardDataModel.setPhoneNum(smsData.getPhoneId());
        fnMobileCardDataModel.setSmsContent(smsData.getContent());
        fnMobileCardDataModel.setSmsNum(smsData.getSender());
        return fnMobileCardDataModel;
    }


    /**
     * @Description: TODO
     * @param smsData
     * @return boolean
     * @date 2020/5/20 14:05
     */
    public  static  boolean   isEffectiveSmsData(SmsData smsData){
        boolean   flag = false ;
        if(StringUtils.isBlank(smsData.getSender())){
            return flag;
        }else if(StringUtils.isBlank(smsData.getSecretKey())){
            return flag;
        }else if(StringUtils.isBlank(smsData.getPhoneId())){
            return flag;
        }
        return    true;
    }

    /**
     * @Description: map 转 CatAllDataModel
     * @param map
     * @return com.hz.source.master.core.model.result.CatAllDataModel
     * @date 2020/5/20 15:27
     */
    public  static CatAllDataModel toCatAllDataModel(Map<String,Object> map){
        DateModel dateModel =WecharMethod.getDate();
        CatAllDataModel   catAllDataModel = new   CatAllDataModel();
        BeanUtils.copy(dateModel,catAllDataModel);
        String  jsonData = MapUtil.mapToJson(map);
        catAllDataModel.setJsonData(jsonData);
        return catAllDataModel;
    }


    /**
     * @Description: map 转 ClientAllDataModel
     * @param map
     * @return com.hz.source.master.core.model.result.CatAllDataModel
     * @date 2020/5/20 15:27
     */
    public  static ClientAllDataModel toClientAllDataModel(Map<String,Object> map){
        DateModel dateModel =WecharMethod.getDate();
        ClientAllDataModel   clientAllDataModel = new   ClientAllDataModel();
        BeanUtils.copy(dateModel,clientAllDataModel);
        String  jsonData = MapUtil.mapToJson(map);
        clientAllDataModel.setJsonData(jsonData);
        return clientAllDataModel;
    }



    public  static void  main(String [] agrs ){
        String  string ="{\"to_wxid\":\"wxid_3ak1xc2zohut22\",\"msgid\":1713710954,\"received_money_index\":\"1\",\"money\":\"0.01\",\"total_money\":\"0.01\",\"remark\":\"\",\"shopowner\":\"小龙(**龙)\",\"scene_desc\":\"店员收款完成\",\"scene\":4,\"timestamp\":1589532207}";
        Msg msg=WecharMethod.toPaymentInfo(string);
    }


}
