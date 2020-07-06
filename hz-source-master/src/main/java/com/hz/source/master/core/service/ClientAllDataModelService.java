package com.hz.source.master.core.service;

import com.hz.source.master.core.common.service.BaseService;
import com.hz.source.master.core.model.result.CatAllDataModel;
import com.hz.source.master.core.model.result.ClientAllDataModel;

/**
 * @Description TODO
 * @Author long
 * @Date 2020/5/20 15:05
 * @Version 1.0
 */
public interface ClientAllDataModelService<T> extends BaseService<T> {
    /**
     * @Description: 添加微信回执记录
     * @return  添加条数
     * @date 2020/5/20 15:06
    */
    public  int    addClientAllDataModel(ClientAllDataModel clientAllDataModel);
}
