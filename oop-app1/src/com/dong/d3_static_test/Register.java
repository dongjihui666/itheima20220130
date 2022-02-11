package com.dong.d3_static_test;

import java.util.Random;

public class Register {
    public static void main(String[] args) {

        //验证码
        System.out.println("验证码"+VerifyTool.createCode(5));
    }
}
