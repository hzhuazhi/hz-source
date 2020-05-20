package com.hz.source.master.core.service;

import com.hz.source.master.core.common.service.BaseService;
import com.hz.source.master.core.model.result.MobileCardDataModel;

/**
 * @Description TODO
 * @Author long
 * @Date 2020/5/19 20:25
 * @Version 1.0
 */
public   interface  MobileCardDataService<T> extends BaseService<T> {
    public int addMobileCardData(MobileCardDataModel model);
}
