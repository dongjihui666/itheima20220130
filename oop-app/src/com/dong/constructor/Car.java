package com.dong.constructor;

/**
 * 目标:说出对象是通过构造器初始化出来的,并理解构造器的分类和区别
 * 构造器的作用?
 * 初始化类的对象,并返回对象的地址
 *
 * 构造器有几种,各自的作用是什么?
 * ·无参数构造器:初始化对象时,成员变量的数据均可采用默认值
 * ·有参数构造器:在初始化对象的时候,同时可以为对象进行赋值.
 *
 * 构造器有哪些注意事项?
 * ·任何类定义出来,默认就自带了无参数构造器,写不写都有.
 * ·一旦定义了有参数构造器.无参数构造器就没有了.此时就需要自己写无参数构造器了
 */
public class Car {
    String name;
    double price;

    //无参数构造器
    public Car(){
        System.out.println("无参构造器被触发执行");
    }

    //有参数构造器
    public Car(String n,double p){
        System.out.println("有参数构造器");
        name = n;
        price = p;
    }

}
