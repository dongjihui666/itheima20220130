package com.dong.javabean;

public class Test {
    public static void main(String[] args) {

        //1 调用无参数构造器创建对象
        User u = new User();
        u.setName("吴彦祖");
        u.setHeight(185.5);
        u.setSalary(1000);
        System.out.println(u.getName());
        System.out.println(u.getHeight());
        System.out.println(u.getSalary());

        //2 调用有参数构造器创建对象
        User user = new User("小李", 188.0, 2000);
        System.out.println(user.getHeight());


    }
}
