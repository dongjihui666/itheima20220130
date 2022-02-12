package com.dong;

/**
 * 目标:学会使用饿汉单例方式定义单例类
 */
public class SingleINstancel {
    /**
     * 2 定义一个公开的静态的成员变量存储一个类的对象
     * 饿汉:在这里加载静态变量的时候,就会创建对象了.
     * public static int onLine Number = 161;
     *
     */
    public static SingleINstancel instance = new SingleINstancel();

    /**
     * 1 把构造器私有起来
     */
    private SingleINstancel(){

    }
}
