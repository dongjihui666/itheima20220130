package com.dong.string;

/**
 * 目标:了解String类的特点,String类不可变得原因
 * 1    String是什么.可以做什么?
 * ·字符串类型,可以定义字符串变量指向字符串对象
 * 2    String是不可变字符串的原因?
 * ·String变量每次的修改其实都是产生并指向了新的字符串对象.
 * ·原来的字符串对象都是没有改变的,所以称不可变字符串
 */
public class StringDemo1 {
    public static void main(String[] args) {

        String name = "小王";
        name += "爱吃";
        name += "豆腐";
        System.out.println(name);
    }
}
