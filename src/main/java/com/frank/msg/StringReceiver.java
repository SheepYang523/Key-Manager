package com.frank.msg;

public class StringReceiver implements Receiver{
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
