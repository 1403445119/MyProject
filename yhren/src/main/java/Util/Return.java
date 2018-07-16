package Util;

import Controller.Basis.Message;
import lombok.Data;
import lombok.Synchronized;
@Data
public class Return<T> {
    private int code;
    private String mes;
    private T data;

    private Return(T t){
        this.mes = "请求成功";
        this.data = t;
        this.code = 0;
    }

    private Return(int code, String mes){
        this.code = code;
        this.mes = mes;
    }

    private Return(Message message){
        this.code = message.code;
        this.mes = message.mes;
    }
    private Return(String mes,T t,int code){
        this.code = code;
        this.mes = mes;
        this.data = t;
    }
    public static Return mes(int code, String mes){
        return new Return(code,mes);
    }

    public static Return success(){
        return new Return(Message.isSuccess);
    }

    public static Return success(String mes){
        return new Return(0,mes);
    }

    public static Return success(Object obj){
        return new Return(obj);
    }

    public static Return erro(String mes){
        return new Return(1,mes);
    }

    public static Return template(Message message){
        return new Return(message);
    }
}
