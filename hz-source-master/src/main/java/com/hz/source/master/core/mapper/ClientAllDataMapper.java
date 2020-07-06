package com.hz.source.master.core.mapper;

import com.hz.source.master.core.common.dao.BaseDao;
import com.hz.source.master.core.model.result.CatAllDataModel;
import com.hz.source.master.core.model.result.ClientAllDataModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description TODO
 * @Date 2020/5/20 15:02
 * @Version 1.0
 */

@Mapper
public interface ClientAllDataMapper<T> extends BaseDao<T>{
    public int addClientAllData(ClientAllDataModel clientAllDataModel);
}
