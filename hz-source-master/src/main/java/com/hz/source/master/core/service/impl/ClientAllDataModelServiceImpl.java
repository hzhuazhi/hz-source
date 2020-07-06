package com.hz.source.master.core.service.impl;

import com.hz.source.master.core.common.dao.BaseDao;
import com.hz.source.master.core.common.service.impl.BaseServiceImpl;
import com.hz.source.master.core.mapper.CatAllDataMapper;
import com.hz.source.master.core.mapper.ClientAllDataMapper;
import com.hz.source.master.core.model.result.CatAllDataModel;
import com.hz.source.master.core.model.result.ClientAllDataModel;
import com.hz.source.master.core.service.CatAllDataModelService;
import com.hz.source.master.core.service.ClientAllDataModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Date 2020/5/20 15:07
 * @Version 1.0
 */
@Service
public class ClientAllDataModelServiceImpl<T> extends BaseServiceImpl<T> implements ClientAllDataModelService<T> {
    @Autowired
    private ClientAllDataMapper clientAllDataMapper;

    @Override
    public BaseDao<T> getDao() {
        return clientAllDataMapper;
    }

    @Override
    public int addClientAllDataModel(ClientAllDataModel clientAllDataModel) {
        return clientAllDataMapper.addClientAllData(clientAllDataModel);
    }
}
