package com.dong.string;

/**
 * 目标:String类型创建字符串对象的2中方式
 * 有什么区别吗?(面试常考)
 * ·    以""方式给出的字符串对象,在字符串常量池中存储,而且相容内容只会在其中存储一份.
 * ·    通过构造器new对象,每new一个都会产生一个新对象,放在堆内存中.
 *
 * 字符串对象的特点有哪些?
 * ·双引号创建的字符串对象,在字符串常量池中存储同一个.
 * ·通过new构造器创建的字符串对象,在堆内存中分开存储.
 */
public class StringDemo2 {
    public static void main(String[] args) {
        //方式1 直接使用双引号得到字符串对象
        String name = "我爱你中国";
        System.out.println(name);

        //方式二
        //1 public String(); 创建一个空白字符串对象,不含有任何内容(几乎不用)
        String s1 = new String(); //s1 = "";

        //2 public String(String) 根据传入的字符串内容,来创建字符串对象(几乎不用)

        String s2 = new String("我是中国人");

        //3 public String(char[] c): 根据字符数组的内容,来创建字符串对象
        char[] chars = {'a','b','c','d'};
        String s = new String(chars);
        System.out.println(s);

        //4 public String(byte[] b): 根据字符数组的内容,来创建字符串对象
        byte[] bytes = {97,98,99,65};
        String s3 = new String(bytes);
        System.out.println(s3);

        System.out.println("------------------");


        String ss1 = "abc";
        String ss2 = "abc";
        System.out.println(ss1 == ss2);


        char[] char1 = {'a','b','c'};
        String ss3 = new String(char1);
        String ss4 = new String(char1);
        System.out.println(ss3 == ss4);



    }
}
