package com.hz.source.master.core.mapper;

import com.hz.source.master.core.common.dao.BaseDao;
import com.hz.source.master.core.model.result.MobileCardDataModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description TODO
 * @Date 2020/5/19 20:04
 * @Version 1.0
 */
@Mapper
public interface MobileCardDataMapper<T> extends BaseDao<T> {

    /**
     * @Description: 添加访问记录
     * @return
     * @date 2020/5/19 20:24
    */

    public int addMobileCardDataModel(MobileCardDataModel fnMobileCardDataModel);
}
