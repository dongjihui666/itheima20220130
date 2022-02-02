package com.dong.thisdemo;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Test {
    public static void main(String[] args) {
        Car car = new Car("张三",12);

        System.out.println(car.name);
        System.out.println(car.price);

    }
}
