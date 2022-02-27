package com.isoft.util;

public class StringUtil {
    /*
    * 判断字符串是否为空
    * @param str
    * @return true字符串为空  false 字符串不为空
    * */

    public static boolean isEmpty(String str ){
        if(null == str || str.trim().length() == 0){
            return true;
        }
        return false;
    }

}
