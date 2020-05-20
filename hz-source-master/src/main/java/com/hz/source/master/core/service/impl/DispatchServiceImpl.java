package com.hz.source.master.core.service.impl;

import com.hz.source.master.core.common.dao.BaseDao;
import com.hz.source.master.core.common.enums.RequestTypeEnum;
import com.hz.source.master.core.common.service.impl.BaseServiceImpl;
import com.hz.source.master.core.model.wechar.LovelyCatData;
import com.hz.source.master.core.service.DispatchService;
import com.hz.source.master.util.WecharMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @Description TODO
 * @Author long
 * @Date 2020/5/14 18:49
 * @Version 1.0
 */
@Service
public class DispatchServiceImpl<T> extends BaseServiceImpl<T> implements DispatchService<T> {

    @Override
    public BaseDao<T> getDao() {
        return null;
    }


    @Override
    public void disp(LovelyCatData lovelyCatData) throws IOException {
        RequestTypeEnum requestTypeEnum = RequestTypeEnum.map.get(Integer.parseInt(lovelyCatData.getType()));
        System.out.println(lovelyCatData.getMsg());
        switch (requestTypeEnum){
            case PRIVATE:
                //获取msg 是否取消信息
                Map<String,Object> map=WecharMethod.isCollectionHelper(lovelyCatData.getMsg());//判断是否是微信助手的信息
                System.out.println(map);
                break;
            case GROUP:
                break;
            case UNKNOW:
                break;
            case MEMBER_ADD:
                break;
            case MEMBER_DEC:
                break;
            case VERFIGY:
                break;
            case SCAN_CASH_MONEY:
                //
                break;
            case TRANSFER:
                break;
            case STARTUP:
                break;
            case LOGIN_SUCC:
                break;
            case LOGIN_OFF:
                break;
            default:
                break;
        }
    }
}
