package com.hz.source.master.core.model.common;

import java.util.Date;

/**
 * @Description TODO
 * @Date 2020/5/20 10:26
 * @Version 1.0
 */
public class DateModel {
    private Integer curday ;
    private Integer curhour ;
    private Integer curminute ;
    private Date createTime ;
    private Date   updateTime ;


    public Integer getCurday() {
        return curday;
    }

    public void setCurday(Integer curday) {
        this.curday = curday;
    }

    public Integer getCurhour() {
        return curhour;
    }

    public void setCurhour(Integer curhour) {
        this.curhour = curhour;
    }

    public Integer getCurminute() {
        return curminute;
    }

    public void setCurminute(Integer curminute) {
        this.curminute = curminute;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
