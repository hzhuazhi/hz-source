package com.hz.source.master.core.model.wechar;

/**
 * @Description TODO
 * @Author long
 * @Date 2020/5/14 18:43
 * @Version 1.0
 */
public class Msg {
    public String to_wxid;
    public String msgid;
    public String received_money_index;
    public String money;
    public String total_money;
    public String remark;
    public String shopowner;
    public String scene_desc;
    public Integer scene;
    public Integer timestamp;

    public String getTo_wxid() {
        return to_wxid;
    }

    public void setTo_wxid(String to_wxid) {
        this.to_wxid = to_wxid;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getReceived_money_index() {
        return received_money_index;
    }

    public void setReceived_money_index(String received_money_index) {
        this.received_money_index = received_money_index;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTotal_money() {
        return total_money;
    }

    public void setTotal_money(String total_money) {
        this.total_money = total_money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getShopowner() {
        return shopowner;
    }

    public void setShopowner(String shopowner) {
        this.shopowner = shopowner;
    }

    public String getScene_desc() {
        return scene_desc;
    }

    public void setScene_desc(String scene_desc) {
        this.scene_desc = scene_desc;
    }

    public Integer getScene() {
        return scene;
    }

    public void setScene(Integer scene) {
        this.scene = scene;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }
}
