package com.dong.constructor;

public class User {
    private String name;
    private String loginName;
    private String passWord;
    private int age ;
    //构造器: 无参数构造器是默认存在的
    public User() {
        System.out.println("无参数构造器被触发");
    }

    //有参数构造器
    public User(String name, String loginName, String passWord, int age) {
        this.name = name;
        this.loginName = loginName;
        this.passWord = passWord;
        this.age = age;
    }
}
