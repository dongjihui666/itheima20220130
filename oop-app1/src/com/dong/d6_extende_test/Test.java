package com.dong.d6_extende_test;

public class Test {
    public static void main(String[] args) {
        //1 创建学生对象
        Student s = new Student();
        s.setName("张三");//父类
        s.setAge(25);//父类
        s.setClassName("java");//子类
        System.out.println(s.getName());
        System.out.println(s.getAge());
        System.out.println(s.getClassName());

        s.queryCourse();//父类的
        s.write();//子类的

    }
}
