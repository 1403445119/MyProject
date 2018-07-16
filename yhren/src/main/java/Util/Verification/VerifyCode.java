package Util.Verification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 需要验证的枚举对象
 */
public enum VerifyCode {
    Null(0,"",""),
    Tel(1,"^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$","手机号码格式错误"),
    IdCard(2,"^\\d{15}|\\d{18}$","身份证格式错误"),
    IsNumber(3,"^(0|[1-9][0-9]*)$","请输入正确的数字格式");
    public int type;    //类型编号
    public String expression;   //正则表达式
    public String isError;  //错误时提示文字

    VerifyCode(int type, String expression, String isError){
        this.type = type;
        this.expression = expression;
        this.isError = isError;
    }

    /**
     * 传入验证的类型与验证的值，返回验证结果(String)
     * @param type
     * @param object
     * @return
     */
    static String verifyAction(int type, Object object){
        VerifyCode ver = null;
        for(VerifyCode v : VerifyCode.values()){
            if(v.type==type){
                ver = v;
                break;
            }
        }
        if(ver==null){
            return "无此类型";
        }
        String obj = null;  //对参数进行转型
        try{
            obj = String.valueOf(object);
        }catch (Exception e){
            e.printStackTrace();
        }
        Pattern p = Pattern.compile(ver.expression);   //引入表达式
        Matcher m = p.matcher(obj); //验证
        boolean is = m.matches();
        return is?"":ver.isError+",";
    }
}
