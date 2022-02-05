package com.dong.arrayList;

import javax.swing.event.MouseInputAdapter;
import java.util.ArrayList;

/**
 * 案例: 集合存储自定义元素并遍历.
 * 需求:定义电影类(名称,分值,演员),创建3个电影对象,代表三部影片,存入集合中并遍历.
 * (肖生克的救赎) 9.6 罗宾斯
 * (霸王别姬) 9.6 张国荣 张丰毅
 * (阿甘正传) 9.5 汤姆,汉克斯
 */
public class ArrayListTest5 {
    public static void main(String[] args) {

        //1 定义一个电影类 Movie
        //2 定义一个ArrayList集合存储影片对象

        ArrayList<Movie> movies = new ArrayList<>();

        //3 创建影片对象封装电影数据,把对象加入到集合中去.
//        Movie m1 = new Movie("肖生克的救赎",9.6,"罗宾斯");
//        movies.add(m1);

        movies.add(new Movie("肖生克的救赎",9.6,"罗宾斯"));
        movies.add(new Movie("霸王别姬",9.6,"张国荣,张丰毅"));
        movies.add(new Movie("阿甘正传",9.5,"汤姆,汉克斯"));

        //4 遍历

        for (int i = 0; i < movies.size(); i++) {
            Movie s1 = movies.get(i);
            System.out.println("片名" + s1.getName());
            System.out.println("评分" + s1.getScore());
            System.out.println("主演" + s1.getActor());
        }

    }
}
