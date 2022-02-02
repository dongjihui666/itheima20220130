package com.dong.thisdemo;

/**
 * this关键字
 * 作用:出现在成员方法,构造器中代表当前对象的地址
 * 用于访问当前对象的成员变量,成员方法.
 *
 *
 */
public class Car {
    String name;
    double price;


    public Car(String name,double price){
    this.name = name;
    this.price = price;
    }
}
