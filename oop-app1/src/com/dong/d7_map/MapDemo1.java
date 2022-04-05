package com.dong.d7_map;

import java.util.HashMap;

/**
 *   目标,认识Map体系的特点,按照键无需,不重复,无索引,值不做要求.
 */
public class MapDemo1 {

    public static void main(String[] args) {

        //1 创建一个map集合对象
        /**
         * HashMap:元素按照键是无序,不重复,无索引,值不做要求.
         * LinkedHashMap:元素按照键是有序,不重复,无索引,值不做要求.
         * TreeMap:元素按照键是排序,不重复,无索引的,值不做要求的.
         */
        HashMap<String, Integer> maps = new HashMap<>();
        maps.put("红星",3);
        maps.put("枸杞",100);
        maps.put("java",1);
        System.out.println(maps);
    }




}
