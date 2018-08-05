package com.yhren.Controller.Basis;

/**
 * 返回字符串封装枚举类
 */
public enum Message {
    isSuccess(0,"请求成功"),
    isError(1,"请求失败"),
    isReturnNull(1,"数据有误请刷新"),
    isTomcatDeGuo(1,"服务器问题，如多次出现请联系管理员"),
    isRepetition(1 ,"请不要录入重复数据"),
    ;
    public int code;    //0表示成功的请求，1表示失败的请求
    public String mes;
    Message(int type, String value){
        this.code = type;
        this.mes = value;
    }

    public static Message judgeBoolean(boolean bool){
        return bool?isSuccess:isError;
    }
}
