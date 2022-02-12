package com.dong.d5_static_codeblock;

import java.util.ArrayList;

/**
 * # 斗地主游戏
 * 需求:
 * 在启动游戏房间的时候,应该提前准备好54张牌,后续才可以直接使用这些牌数据.
 *
 * 分析:
 * 1. 该房间只需要一副牌.
 * 2. 定义一个静态的ArrayList集合存储54张牌,**静态的集合只会加载一份**
 * 3. 在启动游戏房间前,应该将54张牌初始化好
 * 4.** 当系统启动的同时需要准备好54张牌数据,此时可以用静态代码块完成.**
 */
public class StaticCodeTest1 {

    //1准备一个容器,存储54张牌对象
     public  static ArrayList<String> cards = new ArrayList<>();

       //2 在游戏启动之前准备好54张牌,使用静态代码块初始化
   static {
       //3 加载54张牌
           // 4准备4种花色
           String[] colors = {"♠","♣","♥","♦"};
           //5 定义点数
           String[] sizes = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
           //6先遍历点数,在组合花色
           for (int i = 0; i < sizes.length; i++) {
               for (int j = 0; j < colors.length; j++) {
                  cards.add(sizes[i] + colors[j]);
               }
           }
           //7 添加大小王
           cards.add("大王");
           cards.add("小王");
       }
    public static void main(String[] args) {

        System.out.println("新牌"+ cards);
    }
}
