package com.dong.createobject;

public class Test {

    public static void main(String[] args) {
        //目标: 自己设计对象使用
        //类名 对象名= new 类名()
        Car c = new Car();
        c.name = "奔驰";
        c.price = 31.00;
        System.out.println(c.name);
        System.out.println(c.price);

        c.start();
        c.run();

        Car car = new Car();
        car.name="宝马";
        car.price=38.98;

        System.out.println(car.name);
        System.out.println(car.price);
        car.run();
        car.start();


    }

}
