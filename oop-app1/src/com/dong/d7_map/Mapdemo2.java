package com.dong.d7_map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Mapdemo2 {
    public static void main(String[] args) {
        HashMap<String, Integer> maps = new HashMap<>();
        maps.put("Iphonex",10);
        maps.put("娃娃",20);
        maps.put("Iphonex",100);//Map集合后面重复的键对应的元素会覆盖前面重复的整个元素!
        maps.put("huawei",100);
        maps.put("生活用品",10);
        maps.put("手表",10);

        System.out.println(maps);

        //2 清空集合
        maps.clear();
        System.out.println(maps);

        //3 判断集合是否为空,为空返回true,反之
        System.out.println(maps.isEmpty());

        //4 根据键获取对应值public v get(Object key)
        System.out.println(maps.get("huawei"));
        //5 根据键删除整个元素(删除键会返回键的值)
        System.out.println(maps.remove("手表"));
        //6 判断是否包含某个键,包含返回true,反之
        System.out.println(maps.containsKey("生活用品"));
        //7 判断是否包含某个值
        System.out.println(maps.containsValue("100"));
        //8获取全部键的集合 public set<k> keyset()
        Set<String> keys =  maps.keySet();
        System.out.println(keys);

        //9 获取全部值的集合 collection<V> values();
        Collection<Integer> valuse = maps.values();
        System.out.println(valuse);

        //10 集合的大小
        System.out.println(maps.size());
        //11 合并其他Map集合(扩展)
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("java1",1);
        map1.put("java2",100);
        Map<String,Integer> map2 = new HashMap<>();
        map2.put("java2",1);
        map2.put("java3",100);
        map1.putAll(map2);//把集合Map2的元素拷贝一份到map1中去
        System.out.println(map1);
    }
}
