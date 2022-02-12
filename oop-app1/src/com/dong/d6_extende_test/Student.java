package com.dong.d6_extende_test;

public class Student extends Role{

    //独有属性
    private String className;

    //独有行为
    public void write(){
        System.out.println(getName() + "他说了今天学习感觉美美的");
    }
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
