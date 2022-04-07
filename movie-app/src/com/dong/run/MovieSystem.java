package com.dong.run;

import com.dong.bean.Business;
import com.dong.bean.Customer;
import com.dong.bean.Movie;
import com.dong.bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieSystem {
    /**
     * 定义系统的数据容器用户存储数据
     * 1 存储很多用户(客户,商家对象)
     * @param args
     */
    //final修饰引用类型,地址值不能改变,内容可以改变
    // public static final 修饰后变量的名字全部用大写，定以后可以用类名直接访问，定义的变量不能被修改
    public static final List<User> All_Users= new ArrayList<>();

    /**
     * 2 存储系统全部商家和排片信息
     *  商家 = [p1,p2,p3....]
     *  商家2 = [p2,p3....]
     * @param args
     */
    public static final Map<Business,List<Movie>> ALL_MOVIES = new HashMap<>();

    /**
     * 提前准备一些测试数据
     * @param args
     */
    static {
        Customer c = new Customer();
        c.setLoginName("zyf888");
        c.setPassWord("123456");
        c.setUserName("刘德华");
        c.setSex('男');
        c.setPhone("123456");
        All_Users.add(c);

        Customer c1 = new Customer();
        c1.setLoginName("zyf888999");
        c1.setPassWord("1234567");
        c1.setUserName("关之琳");
        c1.setSex('女');
        c1.setPhone("1234568");
        All_Users.add(c1);


        Customer c2 = new Customer();
        c2.setLoginName("zyf888000");
        c2.setPassWord("12345678");
        c2.setUserName("小网");
        c2.setSex('男');
        c2.setPhone("1234568");
        All_Users.add(c2);

        Business b = new Business();
        b.setLoginName("baozugong888");
        b.setPassWord("123456");
        b.setUserName("宝助攻");
        b.setSex('男');
        b.setPhone("118118");
        b.setAddress("火星6号");
        b.setShopName("甜甜圈国际影城");
        All_Users.add(b);

        ArrayList<Movie> movies = new ArrayList<>();
        ALL_MOVIES.put(b,movies);

        Business b1 = new Business();
        b.setLoginName("baozugpo999");
        b.setPassWord("654321");
        b.setUserName("爆竹皮");
        b.setSex('女');
        b.setPhone("119119");
        b.setAddress("火星7号");
        b.setShopName("小红国际影城");
        All_Users.add(b1);

        ArrayList<Movie> movies3 = new ArrayList<>();
        ALL_MOVIES.put(b1,movies3);
    }

    public static void main(String[] args) {


    }
}
