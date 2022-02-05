package com.dong;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {

        //1 准备系统需要的容器对象,用于存储账户对象
        ArrayList<Account> accounts = new ArrayList<>();
        //2 准备系统的首页:  登录  注册
        showMain(accounts);

    }
    public static  void showMain(ArrayList<Account> accounts){
        System.out.println("===========欢迎进入首页=================");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请您输入您想做的操作");
            System.out.println("1 登录");
            System.out.println("2 开户");
            System.out.println("您可以输入命令了:");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    //登录
                    break;
                case 2:
                    //开户
                    register(accounts,sc);
                    break;
                default:
                    System.out.println("您当前输入的操作命令不被支持");
            }
        }
    }

    /**
     * 实现开户功能
     * 1 定义方法完成开户
     * 2 键盘录入姓名,密码,确认密码(需保证二次密码一致)
     * 3 生成账户卡号,卡号必须有系统自动生成8位数字(必须保证卡号的唯一)
     * 4 创建Account账户类对象用于封装账户信息(姓名,密码,卡号)
     * @param accounts
     */
    //直接把 上面的扫描器传到里面来
    public static void register(ArrayList<Account> accounts,Scanner sc){
        System.out.println("===========欢迎您进入银行用户办卡界面================");
        System.out.println("请您输入您的姓名");
        String name = sc.next();


        String password = "";
        while (true) {
            System.out.println("请您输入开户密码:");
            password = sc.next();
            System.out.println("请您输入确认密码:");
            String okPassword = sc.next();
            //判断2次密码是否一致
            if (okPassword.equals(password)){

                break;
            }else {
                System.out.println("您输入的密码不一致请重新输入");
            }
        }
        System.out.println("请您输入当次限额");
        double  quotaMoney = sc.nextDouble();

        //3 生成账户的卡号,卡号是8位,而且不能与其他账户卡号重复
        String cardId = createCardId(accounts);

        //4 创建一个账户对象封装账户的信息

        Account account = new Account(cardId,name,password,quotaMoney);

        //5 把账户对象添加到集合中去
        accounts.add(account);
        System.out.println("恭喜您,您开户成功: 您的卡号是" + account.getCardId() +"请您妥善保管");

    }

    /**
     * 生成一个账户的卡号 8位,而且不能与其他账户卡号重复.
     * @return
     */
    public static String createCardId(ArrayList<Account> accounts){
        while (true) {
            //生成8位的随机数字代表卡号
            String cardId = "";
            Random r = new Random();
            for (int i = 0; i < 8; i++) {
                //0-9直接的数字
                cardId += r.nextInt(10);
            }
            Account acc = getAccountByCardId(cardId, accounts);
            if (acc == null){
                //说明当前卡号没有重复
                return cardId;
            }
        }

    }
    public static Account getAccountByCardId(String carId,ArrayList<Account> accounts){

        //判断卡号是否重复

        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if(account.getCardId().equals(carId)){
                return account;
            }

        }
        return null; //查无此账户
    }

}
