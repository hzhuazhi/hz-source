package com.hz.source.master.core.service;

import com.hz.source.master.core.common.service.BaseService;
import com.hz.source.master.core.model.wechar.LovelyCatData;
import com.hz.source.master.core.model.wechar.Msg;

import java.io.IOException;

/**
 * @Description TODO
 * @Author long
 * @Date 2020/5/14 18:43
 * @Version 1.0
 */
public interface  DispatchService<T> extends BaseService<T> {
    public void disp(LovelyCatData lovelyCatData) throws IOException ;
}
