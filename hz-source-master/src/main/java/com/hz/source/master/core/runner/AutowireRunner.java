package com.hz.source.master.core.runner;

import com.hz.source.master.core.common.redis.RedisIdService;
import com.hz.source.master.core.common.redis.RedisService;
import com.hz.source.master.core.common.utils.constant.LoadConstant;
import com.hz.source.master.core.service.*;
import com.hz.source.master.util.ComponentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
@Order(0)
public class AutowireRunner implements ApplicationRunner {
    private final static Logger log = LoggerFactory.getLogger(AutowireRunner.class);

    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    @Value("${sp.send.url}")
    private String spSendUrl;

    Thread runThread = null;

    @Autowired
    private RedisIdService redisIdService;
    @Autowired
    private RedisService redisService;

    @Resource
    private LoadConstant loadConstant;

    @Autowired
    private QuestionMService questionMService;

    @Autowired
    private QuestionDService questionDService;


    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskHodgepodgeService taskHodgepodgeService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private DispatchService dispatchService;


    @Autowired
    private MobileCardDataService mobileCardDataService;


    @Autowired
    private CatAllDataModelService catAllDataModelService;

    @Autowired
    private ClientAllDataModelService clientAllDataModelService;

    @Autowired
    private WxAllDataModelService wxAllDataModelService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("AutowireRunner ...");
        ComponentUtil.redisIdService = redisIdService;
        ComponentUtil.redisService = redisService;
        ComponentUtil.loadConstant = loadConstant;
        ComponentUtil.questionMService = questionMService;
        ComponentUtil.questionDService = questionDService;

        ComponentUtil.taskService = taskService;
        ComponentUtil.taskHodgepodgeService = taskHodgepodgeService;
        ComponentUtil.regionService = regionService;
        ComponentUtil.dispatchService =dispatchService;
        ComponentUtil.mobileCardDataService =mobileCardDataService;
        ComponentUtil.catAllDataModelService =catAllDataModelService;
        ComponentUtil.clientAllDataModelService =clientAllDataModelService;
        ComponentUtil.wxAllDataModelService =wxAllDataModelService;
        runThread = new RunThread();
        runThread.start();
    }

    /**
     * @author df
     * @Description: TODO(模拟请求)
     * <p>1.随机获取当日金额的任务</p>
     * <p>2.获取代码信息</p>
     * @create 20:21 2019/1/29
     **/
    class RunThread extends Thread{
        @Override
        public void run() {
            log.info("启动啦............");
        }
    }




}
