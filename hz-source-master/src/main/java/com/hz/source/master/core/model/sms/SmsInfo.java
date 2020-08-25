package com.hz.source.master.core.model.sms;

/**
 * @Description TODO
 * @Date 2020/8/25 10:55
 * @Version 1.0
 */
public class SmsInfo {
    /***
     * 手机号
     */
    private String phone;
    /***
     * key
     */
    private String key;
    /***
     * 收到的内容
     */
    private String content;
    /***
     * 短信号码
     */
    private String messageCode;
    /***
     * 时间
     */
    private String time;
    /***
     * id
     */
    private String id;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
