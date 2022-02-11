package com.dong.d3_static_test;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Random;

public class VerifyTool {
    /**
     * 静态方法
     */
    /**
     * 私有构造器
     *
     * @param
     * @return
     */

    private VerifyTool(){

    }

    public static String createCode(int n){
        //验证码
        //1 使用String开发一个验证码
        String chars = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFHJKLZXCVBNM";

        //2 定义一个变量用于存储5位随机的字符作为验证码
        String code = "";

        //3随机数
        Random random = new Random();
        //4 循环
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(chars.length());
            //5对应索引提取字符
            code += chars.charAt(index);
        }
        return code;
    }

    }
