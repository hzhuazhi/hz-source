package com.hz.source.master.core.model.sms;

/**
 * @Description TODO
 * @Date 2020/5/18 12:00
 * @Version 1.0
 */
public class SmsData {
    public String secretKey;
    public String sender;
    public String content;
    public String phoneId;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }
}
