package com.dong.encapsulation;

/**
 * 封装的实现步骤
 * ·一般对成员变量使用private(私有)关键字修饰进行隐藏,private修饰后该成员变量就只能在当前类中访问
 * ·提供public修饰的公开的getter,setter方法暴露其取值和赋值
 * 封装的好处
 * ·加强了程序代码的安全性
 * ·适当的封装可以提高开发效率,同时可以让程序更容易理解和维护
 */
public class Student {
   private int age;
    /**
     * 取值的方法:定义getAge
     */

    public int getAge(){
        return age;
    }
    /**
     * 赋值的方法:setAge
     */
   public void setAge(int age){
       if(age >= 0 && age <=200){

           this.age= age;

       }else {
           System.out.println("年龄非法");
       }
   }


}
