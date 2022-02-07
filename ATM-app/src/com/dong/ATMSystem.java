package com.dong;

import sun.security.util.Password;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {

        //1 准备系统需要的容器对象,用于存储账户对象
        ArrayList<Account> accounts = new ArrayList<>();
        //2 准备系统的首页:  登录  注册
        showMain(accounts);

    }
    public static  void showMain(ArrayList<Account> accounts){
        System.out.println("===========欢迎进入首页=================");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请您输入您想做的操作");
            System.out.println("1 登录");
            System.out.println("2 开户");
            System.out.println("您可以输入命令了:");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    //登录
                    login(accounts,sc);
                    break;
                case 2:
                    //开户
                    register(accounts,sc);
                    break;
                default:
                    System.out.println("您当前输入的操作命令不被支持");
            }
        }
    }

    /**
     * 用户登录功能实现
     * 分析
     * 1定义方法: public static void login(ArrayList<Account> accounts){}
     * 2让用户键盘录入卡号,根据卡号查询账户对象.
     * 3如果没有找到了账户对象,说明卡号不存在,提示继续输入卡号
     * 4如果找到了账户对象,说明卡号存在,继续输入密码
     * @param accounts
     */
    private static void login(ArrayList<Account> accounts,Scanner sc) {

        if(accounts.size() == 0){
            System.out.println("当前系统中无任何用户,您需要先注册");
            return;//直接结束方法的执行.
        }
        //2 让用户键盘录入卡号,根据卡号查询账户对象.
        System.out.println("===========银行ATM系统登录界面==============");
        while (true) {
            System.out.println("请您输入您的卡号");
            String carId = sc.next();

            //根据卡号查询账户对象
            Account acc = getAccountByCardId(carId, accounts);

            //3 判断账户对象是否存在,存在卡号没有问题
            if (acc != null){
                while (true) {
                    //4 让用户继续输入密码
                    System.out.println("请您输入您的密码");
                    String password = sc.next();
                    //5 判断密码是否正确
                    if (acc.getPassWord().equals(password)){
                        //密码正确,登录成功

                        System.out.println("登录成功");
                        //展示系统登录后的操作界面
                        showUserCommand(sc,acc,accounts);
                    }else {
                        System.out.println("您输入的密码不一致.请您重新输入");
                    }
                }
            }else {
                System.out.println("对不起不存在该卡号的账户");
            }
        }
    }

    /**
     * 用户操作页设计,查询账户,退出账户功能分析
     *查询就是直接展示当前登录成功的账户对象的信息
     * 退出账户是需要回到首页的
     */
    private static void showUserCommand(Scanner sc,Account acc,ArrayList<Account> accounts) {
        while (true) {
        System.out.println("==========用户操作界面=============");
        System.out.println("1 查询账户");
        System.out.println("2 存款");
        System.out.println("3 取款");
        System.out.println("4 转账");
        System.out.println("5 修改密码");
        System.out.println("6 退出");
        System.out.println("7 注销账户");

            System.out.println("请您输入操作命令");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    //查询账户
                    showAccount(acc);
                    break;
                case 2:
                    //存款
                    depositMoner(acc,sc);
                    break;
                case 3:
                    //取款
                    drawMoney(acc,sc);
                    break;
                case 4:
                    //转账
                    transferMoney(accounts,acc,sc);
                    break;
                case 5:
                    //修改密码
                    updatePassword(acc,sc);
                    return;
                case 6:
                    //退出
                    System.out.println("欢迎下次光临!");
                    return;//结束当前操作的方法
                case 7:
                    //注销账户
                    //直接从当前集合中抹掉当前对象即可
                    accounts.remove(acc);
                    System.out.println("销户成功了!");
                    return;
                default:
                    System.out.println("没有该命令");
                    break;

            }
        }
    }

    /**
     *
     * @param acc
     */
    private static void updatePassword(Account acc,Scanner sc ) {
        System.out.println("===========修改密码==============");
        while (true) {
            System.out.println("请您输入正确的密码");
            String okPassword = sc.next();
            if (acc.getPassWord().equals(okPassword)){
                //可以输入新密码
                while (true) {
                    System.out.println("请您输入新的密码");
                    String newPassWord = sc.next();

                    System.out.println("请您确认新的密码");
                    String okNewPassWord =sc.next();

                    if(newPassWord.equals(okNewPassWord)){
                        //修改账户对象的密码为新密码
                        acc.setPassWord(newPassWord);
                        return;//代表修改密码结束
                    }else {
                        System.out.println("您两次输入的密码不一致");
                    }
                }


            }else {
                System.out.println("您输入的密码不正确");
            }
        }
    }

    /**
     * 转账功能
     * 1 转账功能需要判断系统中是否有2个账户对象及以上.
     * 2 同时还要判断自己账户是否有钱.
     * 3 接下来需要输入对方卡号,判断对方账户是否存在.
     * 4 对方账户存在还需要认证对方户主的姓氏
     * 5 满足要求则可以把自己账户对象的金额修改到对方账户对象中去.
     * @param accounts
     * @param acc
     * @param sc
     */
    private static void transferMoney(ArrayList<Account> accounts, Account acc, Scanner sc) {

        // 1 判断系统中是否有2个账户及以上
        if (accounts.size()<2){
            System.out.println("对不起,系统无其他账户,您不可以转账");
            return;
        }
        //2 判断自己的账户对象中是否有钱
        if(acc.getMoney() == 0 ){
            System.out.println("账户余额为0");
            return;
        }
        //3 开始转账逻辑
        while (true) {
            System.out.println("请您输入对象账户的卡号");
            String carId = sc.next();
            Account account =  getAccountByCardId(carId,accounts);
            if (account != null){
                //判断这个账户对象是否是当前登录的账户自己
                if (account.getCardId().equals(acc.getCardId())){
                    //正在给自己转账
                    System.out.println("您不可以为自己转账!");
                }else {
                    //确认对方的姓氏
                    String name = "*" + account.getUserName().substring(1);
                    System.out.println("请您确认{"+ name + "}的姓氏");
                    String preName = sc.next();

                    //判断
                    if (account.getUserName().startsWith(preName)){

                        //真正开始转账了.
                        System.out.println("请您输入转账的金额");
                        double money = sc.nextDouble();
                        //判断金额是否超过了自己的余额
                        if (money > acc.getMoney()){
                            System.out.println("对不起,您要转账的金额太多,您最多可以转账"+ acc.getMoney());

                        }else {
                            //真的可以转了
                            acc.setMoney(acc.getMoney() - money);
                            account.setMoney(account.getMoney() + money);
                            System.out.println("恭喜您转账成功了,已经为" + acc.getUserName()+"转账多少" + money);
                            showAccount(acc);
                            return;
                        }
                    }else{
                        System.out.println("对不起您认证的信息有误");
                    }
                }
            }else {
                System.out.println("对不起您输入的转账卡号有问题");
            }
        }
    }

    /**
     * 取款
     * 1 取款需要先判断账户是否有钱.
     * 2 有钱则拿到自己账户对象
     * 3 然后让用户输入取款金额
     * 4 判断取款金额是否超过了当次限额,以及余额是否足够
     * 5 满足要求则调用账户对象的setMoney方法完成金额的修改.
     *
     * @param acc
     * @param sc
     */
    private static void drawMoney(Account acc, Scanner sc) {
        System.out.println("===========取款操作==============");
        //1 判断账户是否足够100元
        if(acc.getMoney()>=100 ){
            while (true) {
                System.out.println("请您输入取款的金额");
                double money = sc.nextDouble();
                //判断金额有没有超过当次限额
                if (money> acc.getQuotaMoney()){
                    System.out.println("您当次取款金额超过每次限额,不要取那么多,最多取"+ acc.getQuotaMoney());
                }else {

                    //3 判断当前余额是否足够你取钱
                    if (acc.getMoney() >= money){
                        acc.setMoney(acc.getMoney()-money);
                        System.out.println("恭喜你取钱"+ money +  "成功,当前账户还剩余" + acc.getMoney());
                        return;//取钱后干掉
                    }else {

                        System.out.println("您当前的余额不足");
                    }
                }
            }
        }else {
            System.out.println("您自己的金额没有超过100元,您就别取了");
        }
    }

    /**
     * 存钱
     * @param acc
     */
    private static void depositMoner(Account acc,Scanner sc) {

        System.out.println("===========存钱操作==============");
        System.out.println("请您输入存款的金额");
        double money = sc.nextDouble();

        //直接把金额修改到账户对象的money属性中去
        acc.setMoney(acc.getMoney()+ money);
        System.out.println("存款完成!");
        showAccount(acc);
    }

    private static void showAccount(Account acc) {

        System.out.println("===========当前账户详情==============");
        System.out.println("卡号" + acc.getCardId());
        System.out.println("姓名" + acc.getUserName());
        System.out.println("余额" + acc.getMoney());
        System.out.println("当次限额" + acc.getQuotaMoney());
    }

    /**
     * 实现开户功能
     * 1 定义方法完成开户
     * 2 键盘录入姓名,密码,确认密码(需保证二次密码一致)
     * 3 生成账户卡号,卡号必须有系统自动生成8位数字(必须保证卡号的唯一)
     * 4 创建Account账户类对象用于封装账户信息(姓名,密码,卡号)
     * @param accounts
     */
    //直接把 上面的扫描器传到里面来
    public static void register(ArrayList<Account> accounts,Scanner sc){
        System.out.println("===========欢迎您进入银行用户办卡界面================");
        System.out.println("请您输入您的姓名");
        String name = sc.next();


        String password = "";
        while (true) {
            System.out.println("请您输入开户密码:");
            password = sc.next();
            System.out.println("请您输入确认密码:");
            String okPassword = sc.next();
            //判断2次密码是否一致
            if (okPassword.equals(password)){

                break;
            }else {
                System.out.println("您输入的密码不一致请重新输入");
            }
        }
        System.out.println("请您输入当次限额");
        double  quotaMoney = sc.nextDouble();

        //3 生成账户的卡号,卡号是8位,而且不能与其他账户卡号重复
        String cardId = createCardId(accounts);

        //4 创建一个账户对象封装账户的信息

        Account account = new Account(cardId,name,password,quotaMoney);

        //5 把账户对象添加到集合中去
        accounts.add(account);
        System.out.println("恭喜您,您开户成功: 您的卡号是" + account.getCardId() +"请您妥善保管");

    }

    /**
     * 生成一个账户的卡号 8位,而且不能与其他账户卡号重复.
     * @return
     */
    public static String createCardId(ArrayList<Account> accounts){
        while (true) {
            //生成8位的随机数字代表卡号
            String cardId = "";
            Random r = new Random();
            for (int i = 0; i < 8; i++) {
                //0-9直接的数字
                cardId += r.nextInt(10);
            }
            Account acc = getAccountByCardId(cardId, accounts);
            if (acc == null){
                //说明当前卡号没有重复
                return cardId;
            }
        }

    }
    public static Account getAccountByCardId(String carId,ArrayList<Account> accounts){

        //判断卡号是否重复

        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if(account.getCardId().equals(carId)){
                return account;
            }

        }
        return null; //查无此账户
    }

}
