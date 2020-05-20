package com.hz.source.master.core.mapper;

import com.hz.source.master.core.common.dao.BaseDao;
import com.hz.source.master.core.model.result.CatAllDataModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description TODO
 * @Date 2020/5/20 15:02
 * @Version 1.0
 */

@Mapper
public interface CatAllDataMapper <T> extends BaseDao<T>{
    public int addCatAllData(CatAllDataModel catAllDataModel);
}
