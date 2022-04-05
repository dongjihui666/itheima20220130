package com.dong.d7_map;

import java.time.temporal.ValueRange;
import java.util.HashMap;

/**
 * Map集合的遍历方式1:键找值
 * 先获取Map集合的全部键的Set集合.
 * 遍历键的Set集合,然后通过键提取对应值
 */
public class MapDemo3 {
    public static void main(String[] args) {
        HashMap<String, Integer> maps = new HashMap<>();

        maps.put("java",1);
        maps.put("DB",2);
        maps.put("javaScript",3);

        System.out.println(maps);

        //1 键找值 第一步:先拿到集合的全部键.
        for (String s : maps.keySet()) {
            int value = maps.get(s);
            System.out.println(value + s);
        }



    }
}
