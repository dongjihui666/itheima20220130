package com.dong.d6_extende_test;

/**
 * 角色类
 */
public class Role {
    private String name;
    private int age;

    /**
     * 共同行为
     * @return
     */
    public void queryCourse(){
        System.out.println(name + "开始查看课程信息");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
