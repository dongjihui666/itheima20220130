package com.dong.arrayList;

import java.util.ArrayList;

/**
 * 需求:
 * 某个班级的考试在系统上进行,成绩大致为 98,77,66,89,79,50,100
 * 现在需要先把成绩低于80分一下的数据去掉.
 *
 * 分析:
 * 1 定义ArrayList集合存储多名学员的成绩.
 * 2 遍历集合每个元素,如果元素值低于80分去掉它
 *
 * 从集合中遍历元素,并筛选出元素删除它,应该怎么解决?
 *  从集合后面遍历然后删除,可以避免漏掉元素
 */
public class ArrayListTest4 {
    public static void main(String[] args) {

        ArrayList<Integer> score = new ArrayList<>();
        score.add(98);
        score.add(77);
        score.add(66);
        score.add(89);
        score.add(79);
        score.add(50);
        score.add(100);
        System.out.println(score);

        //遍历集合每个元素
//        for (int i = 0; i < list.size(); i++) {
//            int s1 =  list.get(i);
//            if (s1 >=80){
//                System.out.println(s1);
//            }else {
//                list.remove(s1);
//            }
//        }
        for (int i = score.size() - 1;i >=0;i-- ) {
            int s1 =  score.get(i);
            if (s1<80){
                score.remove(i);
            }
        }
        System.out.println(score);
    }
}
