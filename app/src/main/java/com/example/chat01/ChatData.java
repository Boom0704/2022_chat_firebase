package com.example.chat01;

import java.io.Serializable;

public class ChatData implements Serializable {

    private String msg;
    private String userId;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
