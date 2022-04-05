package com.dong.d7_map;

import java.util.HashMap;
import java.util.Map;

/**
 * Map集合的遍历方式二:键值对
 *
 * 先把Map集合转换成Set集合,Set集合中每个元素都是键值对实体类型了.
 * 遍历Set集合,然后提取键以及提取值.
 *
 * 键值对涉及到的API:
 * Set<Map,Entry<K,V>> entrySet()    获取所有键值对对象的集合
 * k.getKey()                        获取键
 * K.getValue()                      获取值
 */
public class MapDemo4 {
    public static void main(String[] args) {
        HashMap<String, Integer> maps = new HashMap<>();

        maps.put("java",1);
        maps.put("DB",2);
        maps.put("javaScript",3);

        System.out.println(maps);
        for (Map.Entry<String, Integer> k : maps.entrySet()) {
            String key =  k.getKey();
            Integer value = k.getValue();
            System.out.println(key + "====" + value);
        }

    }
}
