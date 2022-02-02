package com.dong.constructor;

public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.name);
        System.out.println(car.price);

        Car car1 = new Car("王五", 123);

        System.out.println(car1.name);
        System.out.println(car1.price);

    }
}
