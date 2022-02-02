package com.dong.demo;

import java.util.Scanner;

//目标 : 面向对象编程训练,购物车模块模拟
public class ShopCarTest {
    public static void main(String[] args) {
        //1 定义商品类
        //2 定义购物车对象,使用一个数组对象表示.
        Goods[] shopCar = new Goods[100];//地址
        //3 搭建操作架构
        while (true) {
            System.out.println("请您选择如下命令进行操作:");
            System.out.println("添加商品到购物车:add");
            System.out.println("查询商品到购物车:query");
            System.out.println("修改商品到购物车:update");
            System.out.println("结算购买商品的金额:pay");

            Scanner sc = new Scanner(System.in);
            System.out.println("请您输入命令:");
            String command = sc.next();
            switch (command){
                case "add":
                    addGoods(shopCar,sc);
                    break;
                case "query":
                    //
                    query(shopCar);
                    break;
                case "update":
                    update(shopCar,sc);
                    //
                    break;
                case "pay":
                    //
                    pay(shopCar);
                    break;
                default:
                    System.out.println("没有该功能");

            }
        }
    }

    public static void pay(Goods[] shopCar) {

        query(shopCar);
        /**
         * 定义一个求和变量累加金额
         */
        double money = 0;
        //2 遍历购物车数组中的全部对象,要单价+数量
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if (g !=null){
                money += (g.price * g.buyNumber);
            }else {

                break;
            }
        }
        System.out.println("订单总金额" + money);

    }

    public static void update(Goods[] shopCar, Scanner sc) {

        while (true) {
            System.out.println("请您输入要修改的商品ID");
            int id = sc.nextInt();
            Goods g = getGoodsById(shopCar, id);
            if(g == null){

                System.out.println("对不起,没有购买商品");

            }else {

                System.out.println("请您输入" + g.name + "商品最新购买数量");
                int buyNumber = sc.nextInt();
                g.buyNumber = buyNumber;
                System.out.println("修改完成");
                query(shopCar);
                break;

            }
        }
        /**
         * 修改商品的信息.让用户输入要修改商品的ID,根据ID查询出要修改的商品对象
         */
    }
    public static Goods getGoodsById(Goods[] shopCar,int id){

        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if(g !=null){
                if(g.id == id){
                    return g;
                }
            }else {
                return null;
            }
        }
        return null;
    }
    /**
     * 查询商品购物车中的商品信息,并展示出来
     */
    public static void query(Goods[] shopCar) {

        System.out.println("=========查询购物车信息如下============");

        System.out.println("编号\t\t名称\t\t价格\t\t购买数量");

        for (int i = 0; i < shopCar.length; i++) {
           Goods g = shopCar[i];
           if (g !=null){
               System.out.println(g.id +"\t\t" + g.name +"\t\t" + g.price+"\t\t"+g.buyNumber);
           }else {

               break;
           }
        }
    }

    //完成商品添加到购物车的功能
    public static void addGoods(Goods[] shopCar, Scanner sc) {
        //录入用户输入的购买商品的信息.

        System.out.println("请您输入购买商品的编号(不重复):");
        int id = sc.nextInt();
        System.out.println("请您输入购买商品的名称:");
        String name = sc.next();
        System.out.println("请您输入购买商品数量:");
        int buyNumber = sc.nextInt();
        System.out.println("请您输入购买商品价格:");
        double price = sc.nextDouble();

        //2 把这些购买商品的信息封装成一个商品对象
        Goods g = new Goods();
        g.id = id;
        g.name = name;
        g.buyNumber = buyNumber;
        g.price = price;

        //把商品对象添加到购物车数组中去
        for (int i = 0; i < shopCar.length; i++) {
            if(shopCar[i] == null ){
                //说明此位置没有元素,把我们新买的商品添加到此处即可
                shopCar[i] = g;
                break;
            }
        }
        System.out.println("您的商品 " +g.name + "添加到购物车完成");
    }

}
