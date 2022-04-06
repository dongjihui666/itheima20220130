package com.dong.d7_map;

import java.util.HashMap;
import java.util.Random;

/**
 * 需求:统计投票人数
 */
public class MapTest1 {
    public static void main(String[] args) {
        //1 把80个学生选择的数据拿进来.

        String[] selects = {"A","B","C","D"};
        //StringBuilder() 的Append方法拼接字符串
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            sb.append(selects[r.nextInt(selects.length)]);
        }
        System.out.println(sb);

        //定义一个Map集合记录统计的结果
        HashMap<Character, Integer> infos = new HashMap<>();

        //3 遍历80个学生选择的数据
        for (int i = 0; i < sb.length(); i++) {
            //4 提取当前选择字符
            //charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1
            char ch = sb.charAt(i);
            //5 判断Map集合中是否存在这个键
            //containsKey是判断里面是否包含某一个元素
            if (infos.containsKey(ch)){
                //让其值 + 1
                infos.put(ch,infos.get(ch)+1);
            }else {
                //说明此景点第一次被选
                infos.put(ch,1);
            }
        }
        //4 输出集合
        System.out.println(infos);



    }
}
