package com.itheima.smallchange;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * �����Ǯͨ�������ܵ���
 * ʹ��������� oop
 * ���������ܶ�Ӧһ������
 */
public class SmallChangeSys {

    //����
    boolean loop = true;
   Scanner sc = new Scanner(System.in);
   String key ="";

   String details = "--------��Ǯͨ---------";
   double money = 0;
   double balance = 0;

  Date date= new Date();
  SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm");
  String note = "";


    //�������ʾ�˵�
    public void mainMenu(){
        do {
            System.out.println("==========��Ǯͨ�˵�===========");
            System.out.println("1 ��Ǯͨ��ϸ");
            System.out.println("2 ��������");
            System.out.println("3 ����");
            System.out.println("4 �˳�");
            System.out.println("��ѡ��1 -4 ");
            key = sc.next();
switch (key){
    case "1":
        this.detail();
        break;
    case "2":
        this.income();
        break;
    case "3":
        this.pay();
        break;
    case "4":
        this.exit();
        break;
}
        }while (loop);
    }
    //�����Ǯͨ����ϸ
    public void detail(){

        System.out.println(details);
    }
    //�����������
    public void income(){
        System.out.println("�������˽��");
        money = sc.nextDouble();
        if (money<=0){
            System.out.println("�������˽����Ҫ����0");
            return;
        }
        balance+=money;

        details +=money + sdf.format(date)+balance;
    }
    //����
    public void pay(){
        System.out.println("���ѽ��");
        money = sc.nextDouble();
        if (money<=0 || money>balance){
            System.out.println("�������ѽ��Ӧ���� 0-"+ balance);
            return;
        }
        System.out.println("����˵��");
        note =sc.next();
        balance-=money;
        details += note + money + sdf.format(date) + balance;
    }
    public void exit(){
        String choice = "";
        while (true){
            System.out.println("��ȷ��Ҫ�˳�ô y/n");
            choice = sc.next();
            if ("y".equals(choice) || "n".equals(choice)){
                break;
            }
            if (choice.equals("y")){
                loop= false;
            }

        }
    }


}
