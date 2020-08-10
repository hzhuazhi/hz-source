package com.hz.source.master.core.service.impl;

import com.hz.source.master.core.common.dao.BaseDao;
import com.hz.source.master.core.common.service.impl.BaseServiceImpl;
import com.hz.source.master.core.mapper.CatAllDataMapper;
import com.hz.source.master.core.mapper.WxAllDataMapper;
import com.hz.source.master.core.model.result.CatAllDataModel;
import com.hz.source.master.core.service.CatAllDataModelService;
import com.hz.source.master.core.service.WxAllDataModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Date 2020/5/20 15:07
 * @Version 1.0
 */
@Service
public class WxAllDataModelServiceImpl<T> extends BaseServiceImpl<T> implements WxAllDataModelService<T> {
    @Autowired
    private WxAllDataMapper wxAllDataMapper;

    @Override
    public BaseDao<T> getDao() {
        return wxAllDataMapper;
    }

}
