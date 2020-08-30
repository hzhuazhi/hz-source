package com.hz.source.master.core.service.impl;

import com.hz.source.master.core.common.dao.BaseDao;
import com.hz.source.master.core.common.service.impl.BaseServiceImpl;
import com.hz.source.master.core.mapper.MobileCardDataMapper;
import com.hz.source.master.core.model.result.MobileCardDataModel;
import com.hz.source.master.core.service.MobileCardDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Date 2020/5/19 20:26
 * @Version 1.0
 */
@Service
public class MobileCardDataServiceImpl<T> extends BaseServiceImpl<T> implements MobileCardDataService<T> {
    @Autowired
    private MobileCardDataMapper mobileCardDataMapper;

    @Override
    public BaseDao<T> getDao() {
        return mobileCardDataMapper;
    }

    @Override
    public int addMobileCardData(MobileCardDataModel model) {
        return mobileCardDataMapper.addMobileCardDataModel(model);
    }

    @Override
    public int addCardDataModel(MobileCardDataModel model) {
        return mobileCardDataMapper.addCardDataModel(model);
    }
}
