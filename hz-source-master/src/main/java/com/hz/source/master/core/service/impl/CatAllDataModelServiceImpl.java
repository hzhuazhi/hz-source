package com.hz.source.master.core.service.impl;

import com.hz.source.master.core.common.dao.BaseDao;
import com.hz.source.master.core.common.service.impl.BaseServiceImpl;
import com.hz.source.master.core.mapper.CatAllDataMapper;
import com.hz.source.master.core.mapper.MobileCardDataMapper;
import com.hz.source.master.core.model.result.CatAllDataModel;
import com.hz.source.master.core.service.CatAllDataModelService;
import com.hz.source.master.core.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author long
 * @Date 2020/5/20 15:07
 * @Version 1.0
 */
@Service
public class CatAllDataModelServiceImpl <T> extends BaseServiceImpl<T> implements CatAllDataModelService<T> {
    @Autowired
    private CatAllDataMapper catAllDataMapper;

    @Override
    public BaseDao<T> getDao() {
        return catAllDataMapper;
    }

    @Override
    public int addCatAllDataModel(CatAllDataModel catAllDataModel) {
        return catAllDataMapper.addCatAllData(catAllDataModel);
    }
}
