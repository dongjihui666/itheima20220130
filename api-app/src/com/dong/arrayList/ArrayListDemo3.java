package com.dong.arrayList;

import java.util.ArrayList;

/**
 * 目标:掌握ArrayList集合的常用API
 */
public class ArrayListDemo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("java");
        list.add("java");
        list.add("Mysql");
        list.add("Mybatis");
        list.add("HTML");
        //1 public E get(int index); 获取某个索引位置处的元素值
        String e = list.get(3);
        System.out.println(e);
        //2public int size() 获取集合的大小(元素个数)
        System.out.println(list.size());
        //3 完成集合的遍历
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }

        //4 public E remove(int index) 删除某个索引位置处的元素值,并返回被删除的元素值
        System.out.println(list);
        String e2 = list.remove(2);
        System.out.println(e2);
        //5 public boolean remove(object o) 直接删除元素值,删除成功返回true 删除失败返回fales

        System.out.println(list.remove("Mybatis"));
        System.out.println(list);
        System.out.println(list.remove("java"));
        //6 public E set(int index,E element) 修改某个索引位置处的原始值.

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Java");
        list1.add("王宝强");
        list1.add("Java");
        list1.add("Mysql");
        String e3 = list1.set(2, "Mysql1");
        System.out.println(e3);
        System.out.println(list1);
    }
}
