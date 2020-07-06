package com.hz.source.master.util;


import com.hz.source.master.core.common.redis.RedisIdService;
import com.hz.source.master.core.common.redis.RedisService;
import com.hz.source.master.core.common.utils.constant.LoadConstant;
import com.hz.source.master.core.service.*;

/**
 * 工具类
 */
public class ComponentUtil {
    public static RedisIdService redisIdService;
    public static RedisService redisService;
    public static RegionService regionService;
    public static LoadConstant loadConstant;
    public static QuestionMService questionMService;
    public static QuestionDService questionDService;
    public static TaskService taskService;
    public static TaskHodgepodgeService taskHodgepodgeService;
    public static DispatchService dispatchService;
    public static MobileCardDataService mobileCardDataService;
    public static CatAllDataModelService catAllDataModelService;
    public static ClientAllDataModelService clientAllDataModelService;

}
