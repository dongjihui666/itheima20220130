package com.dong.run;

import com.dong.bean.Business;
import com.dong.bean.Customer;
import com.dong.bean.Movie;
import com.dong.bean.User;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

public class MovieSystem {
    /**
     * 定义系统的数据容器用户存储数据
     * 1 存储很多用户(客户,商家对象)
     * @param args
     */
    //final修饰引用类型,地址值不能改变,内容可以改变
    // public static final 修饰后变量的名字全部用大写，定以后可以用类名直接访问，定义的变量不能被修改
    public static final List<User> All_Users= new ArrayList<>();

    //定义一个静态的用户变量,记住当前登录成功的用户对象
    public static User loginUser;

    //定义一个时间类型
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    //日志
     public static final Logger LOGGER = (Logger) LoggerFactory.getLogger("MoviesSystem.class");

    /**
     * 2 存储系统全部商家和排片信息
     *  商家 = [p1,p2,p3....]
     *  商家2 = [p2,p3....]
     * @param args
     */
    public static final Map<Business,List<Movie>> ALL_MOVIES = new HashMap<>();

    public static final Scanner sc = new Scanner(System.in);
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
        showMain();

    }
    private static void showMain(){
        while (true) {
        System.out.println("=======电影首页==========");
        System.out.println("1 登录");
        System.out.println("2 用户注册");
        System.out.println("3 商家注册");


            System.out.println("请输入操作命令");
            String command =  sc.nextLine();
            switch (command){
                case "1":
                    //1 登录
                    login();
                    break;
                case "2":
                    break;
                    case "3":
                        break;
                default:
                    System.out.println("命令有误,请确认");

            }
        }
    }

    /**
     * 登录功能
     */
    private static void login() {
        while (true) {
            System.out.println("请输入登录名称");
            String loginName = sc.nextLine();
            System.out.println("请您输入登录密码");
            String password = sc.nextLine();
            //1 根据登录名查询用户对象.
            User u =getUserByLoginName(loginName);
            //2 判断用户对象是否存在,存在说明登录名称正确
            if (u !=null){
                //3 比对密码是否正确.
                if (u.getPassWord().equals(password)){
                    //登录成功...
                    loginUser = u; //记录登录成功的用户
                    //判断是用户登录的,还是商家登录的用  instanceof  判断对象的类型
                    if (u instanceof Customer){
                        //当前登录的是普通客户
                        showCustomerMain();
                    }else {
                        //当前登录的是商家用户
                        showBusinessMain();
                    }
                    return;
                }else {
                    System.out.println("密码有问题,请您重新输入密码");
                }
            }else {
                System.out.println("登录名称错误,请重新输入登录名");
            }
        }
    }

    /**
     * 商家的后台操作页面
     */
    private static void showBusinessMain() {
        while (true) {
        System.out.println("========商家页面==========");
        System.out.println(loginUser.getUserName()+(loginUser.getSex() =='男' ? "先生" : "女士"+"欢迎您进入系统"));
        System.out.println("1 展示详情");
        System.out.println("2 上架电影");
        System.out.println("3 下架电影");
        System.out.println("4 修改电影");
        System.out.println("5 退出");
            System.out.println("请您输入您要操作的命令");
            String command = sc.nextLine();
            switch (command){
                case "1":
                    //展示全部排片信息
                    showBusinessInfos();
                    break;
                case "2":
                    //上架电影信息
                    addMovies();
                    break;
                case "3":
                    //下架电影信息
                    //deleteMovies();
                    break;
                case "4":
                    //修改电影信息

                    break;
                case "5":
                    //退出
                    System.out.println(loginUser.getUserName()+"请您下次再来");
                    return;
                default:
                    System.out.println("您输入的命令有问题,请您从新输入");
            }
        }

    }

    /**
     * 商家进行电影上架  :Map<Business,List<Movie> ALL_MOVIES>
     *
     */
    private static void addMovies() {
        System.out.println("================电影院上架影片==================-");
        //1 先让用户输入商家
        //2 根据商家直接提取它的影片值集合
        Business business = (Business) loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);

        System.out.println("请您输入新片名");
        String name = sc.nextLine();
        System.out.println("请您输入主演");
        String actor = sc.nextLine();
        System.out.println("请您输入时长");
        String time = sc.nextLine();
        System.out.println("请您输入票价");
        String price = sc.nextLine();
        System.out.println("请您输入票数");
        String totalNumber = sc.nextLine();
        while (true) {
            System.out.println("请您输入影片放映时间:");
            String stime = sc.nextLine();

            //字符串转成Data类型
            // SimpleDateFormat.parse 从字符串分析Date。
            try {
                //public Movie(String name, String actor, double score, double time, double price, int number, Date startTime)
                Movie movie = new Movie(name, actor, Double.valueOf(time), Double.valueOf(price), Integer.valueOf(totalNumber), sdf.parse(stime));
                //添加影片信息
                movies.add(movie);
                System.out.println("您已经成功上架了"+movie.getName());
                return;//直接退出去
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 展示商家的详细:展示当前商家的信息
     */
    private static void showBusinessInfos() {
        System.out.println("=============商家详情页面===================");
        // 根据商家对象,作为Map集合的键,提取对应的值就是其拍片信息:Map<Business,List<Movie> ALL_MOVIES>
        //把loginUser转换成Business
        Business business = (Business) loginUser;
        System.out.println(business.getShopName()+"\t\t电话:" + business.getPhone()+"\t\t地址:" + business.getAddress());
        System.out.println(MovieSystem.loginUser);
        List<Movie> movies = ALL_MOVIES.get(MovieSystem.loginUser);

        if (movies.size()>0){
            System.out.println("片名\t\t主演\t\t市场\t\t评分\t\t票价\t\t余票数量\t\t放映时间");
            for (Movie movie : movies) {
                System.out.println(movie.getName()+"\t\t"+ movie.getActor()+"\t\t"+movie.getTime()+"\t\t"+movie.getScore()+"\t\t"+movie.getPrice()+"\t\t"+
                        movie.getNumber()+"\t\t"+movie.getNumber()+"\t\t"+sdf.format(movie.getStartTime()));
            }
        }else {
            System.out.println("您的当前店铺无片可播放");
        }

    }

    /**
     * 客户操作界面
     */

    private static void showCustomerMain() {
        System.out.println("========客户页面==========");
        System.out.println(loginUser.getUserName()+(loginUser.getSex() =='男' ? "先生" : "女士"+"欢迎您进入系统"));
        System.out.println("请您选择要操作的功能");
        System.out.println("1 展示全部影片信息功能");
        System.out.println("2 根据电影名称查询电影信息");
        System.out.println("3 评分功能");
        System.out.println("4 购票系统");
        System.out.println("5 退出系统");
        while (true) {
            System.out.println("请您输入您要操作的命令");
            String command = sc.nextLine();
            switch (command){
                case "1":
                    //展示全部排片信息
                    //queryAllMovies();
                    break;
                case "2":
                    //根据电影名称查询电影信息
                    //queryByName();
                    break;
                case "3":
                    //评分功能
                    //scoreMovies();
                    break;
                case "4":
                    //购票系统
                    break;
                case "5":
                    //退出
                    return;//干掉方法
                default:
                    System.out.println("您输入的命令有问题,请您从新输入");
                    break;
            }
        }

    }

    /**
     * //根据登录名查询用户对象.
     * @param loginName
     * @return
     */
    public static User getUserByLoginName(String loginName){
        for (User user : All_Users) {
            //判断这个用户的登录名是否是我们想用的
            if (user.getLoginName().equals(loginName)){
                return user;
            }
        }
        return null;//查询没有用户登录名称
    }

}
