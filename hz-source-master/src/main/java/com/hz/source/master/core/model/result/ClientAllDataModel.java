package com.hz.source.master.core.model.result;

/**
 * @Description TODO
 * @Author long
 * @Date 2020/5/20 14:52
 * @Version 1.0
 */
public class ClientAllDataModel {
    private String  jsonData;
    private Integer curday;
    private Integer curhour;
    private Integer curminute;

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

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
}
