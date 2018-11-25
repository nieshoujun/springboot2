package com.example.bean.question;

/**
 * Created by niejun on 2018/11/15 10:41
 */
public class ReponseMessage implements  java.io.Serializable{

    private boolean flag =false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private String message;

    private Object data;

}
