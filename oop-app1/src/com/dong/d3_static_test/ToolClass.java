package com.dong.d3_static_test;

import java.util.Random;

public class ToolClass {
    public static void main(String[] args) {

        //验证码
        //1 使用String开发一个验证码
        String chars = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFHJKLZXCVBNM";

        //2 定义一个变量用于存储5位随机的字符作为验证码
        String code = "";

        //3随机数
        Random random = new Random();
        //4 循环
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(chars.length());
            //5对应索引提取字符
            code += chars.charAt(index);
        }
        System.out.println("code");
    }
}
