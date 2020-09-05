package com.hz.source.master.core.controller.collect;

import com.alibaba.fastjson.JSON;
import com.hz.source.master.core.common.exception.ExceptionMethod;
import com.hz.source.master.core.common.utils.ShortChainUtil;
import com.hz.source.master.core.common.utils.constant.ServerConstant;
import com.hz.source.master.core.model.bank.BankModel;
import com.hz.source.master.util.HodgepodgeMethod;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Description 汇集的Controller层
 * <p>
 *     资源调度，跳转等功能的Controller层
 * </p>
 * @Author yoko
 * @Date 2020/9/5 12:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/source/collect")
public class CollectController {
    private static Logger log = LoggerFactory.getLogger(CollectController.class);



    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    /**
     * 15分钟.
     */
    public long FIFTEEN_MIN = 900;

    /**
     * 30分钟.
     */
    public long THIRTY_MIN = 30;

    @Value("${secret.key.token}")
    private String secretKeyToken;

    @Value("${secret.key.sign}")
    private String secretKeySign;



    /**
     * @Description: 组装短代
     * @param response
     * @return com.gd.chain.common.utils.JsonResult<java.lang.Object>
     * @author yoko
     * @date 2019/11/25 22:58
     * local:http://localhost:8087/source/collect/getShortChain
     * test:http://localhost:8087/source/collect/getShortChain?bankName=光大银行&bankCard=6226622108434107&accountName=孟宪宏&bankCode=CEB
     * 请求的属性类:requestData
     *
     */
    @RequestMapping(value = "/getShortChain", method = {RequestMethod.GET})
    public String dataCore(HttpServletRequest request, HttpServletResponse response, BankModel requestData) throws Exception{
        try{
            // 校验请求的数据
            HodgepodgeMethod.checkBankData(requestData);
            // 生成短链
            String shortChain = ShortChainUtil.getH5Url(requestData);
            if (!StringUtils.isBlank(shortChain)){
                return shortChain;
            }
            return null;
        }catch (Exception e){
            log.error(String.format("this CollectController.dataCore() is error , the all data=%s!", JSON.toJSON(requestData)));
            e.printStackTrace();
            return null;
        }
    }

}
