package org.jerry.jnotification;

import java.util.Map;

public class Notification {
    private Object sender;
    private String name;
    private Map userInfo;

    public Object getSender() {
        return sender;
    }

    public void setSender(Object sender) {
        this.sender = sender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Map userInfo) {
        this.userInfo = userInfo;
    }

    Notification(Object sender, String name, Map userInfo) {
        this.sender = sender;
        this.name = name;
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "sender=" + sender +
                ", name='" + name + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}