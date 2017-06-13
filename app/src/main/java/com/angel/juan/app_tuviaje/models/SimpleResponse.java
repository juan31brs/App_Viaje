package com.angel.juan.app_tuviaje.models;

/**
 * Created by darfe on 23/05/2017.
 */

public class SimpleResponse {

    private boolean success;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
