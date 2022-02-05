package com.dong.arrayList;

import java.util.ArrayList;

/**
 * 泛型概述
 * ArrayList<E>;其实就是一个泛型类,可以在编译阶段约束集合对象只能操作某种数据类型.
 *
 * 举例:
 * ArrayList<String> 此集合 只能操作字符串类型的元素
 * ArrayList<Integer> 此集合 只能操作整数类型的元素
 *
 * 注意: 集合中只能存储引用类型,不支持基本数据类型
 *
 * 目标:能够使用泛型约束ArrayList集合操作的数据类型
 */
public class ArrayListDemo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();//jdk1.7开始 泛型后面的类型申明可以不写
        list.add("java");
        list.add("mysql");
//        list.add(23);
//        list.add(123);
        ArrayList<Integer> list1 = new ArrayList();
        list1.add(23);
        list1.add(100);

    }
}
