package com.dong.arrayList;

import java.util.ArrayList;

/**
 * 目标: 创建ArrayList对象,代表集合容器,往里面添加元素
 *
 *
 */
public class ArrayListDemo1 {
    public static void main(String[] args) {

        //1 创建 ArrayList集合的对象
        ArrayList list = new ArrayList();

        //2 往里面添加数据
        list.add("java");
        list.add("java");
        list.add("mysql");
        list.add("123");

        System.out.println(list);

        //3 给指定索引位置插入元素
        list.add(1,"excel");
        System.out.println(list);
    }
}
