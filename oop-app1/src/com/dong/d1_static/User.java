package com.dong.d1_static;

public class User {
    //在线人数信息:静态成员变量
    public static int onLineNumber;
    //实例成员变量
    private String name;
    private int age;

    public static void main(String[] args) {
        //1 类名.静态成员变量
        User.onLineNumber++;
        //注意:同一个类中访问静态成员变量,类名可以省略不写.
        System.out.println(onLineNumber);

        //2 对象.实例成员变量
        User user = new User();
        user.name = "123";

    }

}
