package com.yhren.Util.Verification;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 验证数据是否正确(配合Note注解使用)
 */
public class Verify {
    public static String verify(Object obj) {
        String ret = "";
        Class clasz = obj.getClass();
        Field[] fields = clasz.getDeclaredFields();
        for(Field f : fields){
            Note note = f.getAnnotation(Note.class);
            boolean index = true;
            String temp = "get"+f.getName().toUpperCase().substring(0,1)+f.getName().substring(1,f.getName().length());
            Method m = null;
            try {
                m = clasz.getDeclaredMethod(temp,null);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            Object mes = null;
            try {
                mes = m.invoke(obj,null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            if(note!=null){
                if(note.notNull()==true){
                    if(String.valueOf(mes).equals("")||String.valueOf(mes)==null){
                        ret+= note.name()+"不能为空,";
                        index = false;
                    }
                }
                if(index&&note.type()!=0){     //防止重复判定
                    ret += VerifyCode.verifyAction(note.type(),mes);
                }
            }
        }
        if(!ret.equals("")){
            return ret.substring(0,ret.length()-1);
        }
        return ret;
    }
}
