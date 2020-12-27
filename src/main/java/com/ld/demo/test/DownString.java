package com.ld.demo.test;
//实现一个函数，把一个字符串中的字符从小写转为大写
/**
 *
 */
public class DownString {
    public String changeStrToDown(String param){
        char[] asc={'a','b','c','d'};
        char[] ascUp={'A','B','C','D'};
        char[] strChar=param.toCharArray();
        StringBuilder resultSb= new StringBuilder();

        for(int i=0;i<strChar.length;i++){
            Integer tempIndex = null;
            for(int j=0;j<asc.length;j++){
                if(strChar[i]==asc[j]){
                    tempIndex=j;
                }
            }
            if(tempIndex==null){
                resultSb.append(strChar[i]);
            }else{
                resultSb.append(ascUp[tempIndex]);
                tempIndex=null;
            }

        }

        return "";
    }
}
