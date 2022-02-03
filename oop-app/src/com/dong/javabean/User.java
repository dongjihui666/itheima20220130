package com.dong.javabean;

public class User {
    //1 成员变量私有
    private String name;
    private double height;
    private double salary;

    //2 必须提供成套的getter 和 setter方法暴露成员变量的取值 和赋值


    //3 必须有无参数构造器(默认的)

    public User() {
    }

    //4 有参数构造器(不是必须,可以选择)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public User(String name, double height, double salary) {
        this.name = name;
        this.height = height;
        this.salary = salary;
    }
}