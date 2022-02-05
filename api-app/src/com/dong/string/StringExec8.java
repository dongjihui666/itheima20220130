package com.dong.string;

import java.util.Scanner;

/**
 * 需求
 * 以字符串的形式从键盘接受一个手机号,将中间四位号码屏蔽.最终效果为:
 *
 * 分析
 * 1 键盘录入一个字符串,用scanner实现
 * 2 截取字符串前三位,截取字符串后四位.
 */
public class StringExec8 {
    public static void main(String[] args) {

        // 1 键盘录入一个手机号码
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入您的手机号码");
        String tel = sc.next();
        //2 截取号码的前3位,后4位
        String brfore = tel.substring(0, 3);
        //从索引7开始截取到手机号的末尾
        String after = tel.substring(7);

        String s1 = brfore + "****" + after;
        System.out.println(s1);
    }
}
