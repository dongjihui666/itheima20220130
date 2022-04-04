package com.itheima.smallchange;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 完成零钱通各个功能的类
 * 使用面向对象 oop
 * 将各个功能对应一个方法
 */
public class SmallChangeSys {

    //属性
    boolean loop = true;
   Scanner sc = new Scanner(System.in);
   String key ="";

   String details = "--------零钱通---------";
   double money = 0;
   double balance = 0;

  Date date= new Date();
  SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm");
  String note = "";


    //先完成显示菜单
    public void mainMenu(){
        do {
            System.out.println("==========零钱通菜单===========");
            System.out.println("1 零钱通明细");
            System.out.println("2 收益入账");
            System.out.println("3 消费");
            System.out.println("4 退出");
            System.out.println("请选择1 -4 ");
            key = sc.next();
switch (key){
    case "1":
        this.detail();
        break;
    case "2":
        this.income();
        break;
    case "3":
        this.pay();
        break;
    case "4":
        this.exit();
        break;
}
        }while (loop);
    }
    //完成零钱通的明细
    public void detail(){

        System.out.println(details);
    }
    //完成收益入账
    public void income(){
        System.out.println("收益入账金额");
        money = sc.nextDouble();
        if (money<=0){
            System.out.println("收益入账金额需要大于0");
            return;
        }
        balance+=money;

        details +=money + sdf.format(date)+balance;
    }
    //消费
    public void pay(){
        System.out.println("消费金额");
        money = sc.nextDouble();
        if (money<=0 || money>balance){
            System.out.println("您的消费金额应该是 0-"+ balance);
            return;
        }
        System.out.println("消费说明");
        note =sc.next();
        balance-=money;
        details += note + money + sdf.format(date) + balance;
    }
    public void exit(){
        String choice = "";
        while (true){
            System.out.println("您确定要退出么 y/n");
            choice = sc.next();
            if ("y".equals(choice) || "n".equals(choice)){
                break;
            }
            if (choice.equals("y")){
                loop= false;
            }

        }
    }


}
