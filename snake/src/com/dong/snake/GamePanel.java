package com.dong.snake;

import sun.awt.image.IntegerInterleavedRaster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    int length; //蛇的长度
    int[] shakeX = new int[600];//蛇的坐标X
    int[] shakeY = new int[500];//蛇的坐标Y
    String fx ; //R:右 L:左 U:上 D:下
    boolean isStart = false; //游戏是否开始

    Timer timer = new Timer(100,this);//定时器

    //1 定义一个食物
    int foodx;
    int foody;
    Random random = new Random();
    //死亡判断
    boolean isFail = false;

    //积分系统
    int score;

    //构造器,构造器调用初始化方法
    public GamePanel(){
        this.init();
        //获取键盘的监听事件
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();//让时间动起来
    }

    /**
     * 初始化
     */
    public void init() {
        length = 3;
        shakeX[0] = 100;shakeY[0] = 100; //头部坐标
        shakeX[1] = 75;shakeY[1] = 100; //第一个身体的坐标
        shakeX[2] = 50;shakeY[2] = 100; //第二个身体的坐标
        fx = "R";
        foodx = 25 + 25*random.nextInt(34);
        foody = 75 + 25*random.nextInt(24);
        score=0;
    }


    //画板:画界面,画蛇
    //Graphics : 画笔
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        this.setBackground(Color.BLACK);//设置背景的颜色

        //绘制头部的广告栏
        Data.header.paintIcon(this, g, 25, 11);

        //绘制游戏区域
        g.fillRect(25, 75, 850, 600);

        //画一条静态的小蛇
        Data.right.paintIcon(this,g,shakeX[0],shakeY[0]);
        //判断上下左右
        if (fx.equals("R")){
            Data.right.paintIcon(this,g,shakeX[0],shakeY[0]);
        }else if(fx.equals("L")){
            Data.left.paintIcon(this,g,shakeX[0],shakeY[0]);
        }else if(fx.equals("U")){
            Data.up.paintIcon(this,g,shakeX[0],shakeY[0]);
        }else if(fx.equals("D")){
            Data.down.paintIcon(this,g,shakeX[0],shakeY[0]);
        }
        //蛇的身体长度通过length来控制
        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this,g,shakeX[i],shakeY[i]);
        }
        //画积分
        g.setColor(Color.white);//设置画笔的颜色
        g.setFont(new Font("微软雅黑",Font.BOLD,18));//设置字体
        g.drawString("长度"+length,750,35);
        g.drawString("分数"+score,750,50);

        //画食物
        Data.food.paintIcon(this,g,foodx,foody);

        //提示游戏:是否开始
        if (isStart==false){
            //画一个文字,String
            g.setColor(Color.white);//设置画笔的颜色
            g.setFont(new Font("微软雅黑",Font.BOLD,40));//设置字体
            g.drawString("按下空格游戏开始",300,300);
        }

        //失败提醒
        if (isFail){
            //画一个文字,String
            g.setColor(Color.RED);//设置画笔的颜色
            g.setFont(new Font("微软雅黑",Font.BOLD,40));//设置字体
            g.drawString("游戏失败,按下空格重新开始",200,300);

        }
    }

    //实现了KeyListener 重写了3个方法
    /**
     * 监听:接收键盘的输入
     */
    @Override
    public void keyPressed(KeyEvent e) {
        //键盘按下,未释放
        //获取按下的键盘是哪个键
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE){//如果按下的是空格键
            if (isFail){//失败,游戏再来一遍
                isFail = false;
                init();//重新初始化游戏
            }else {//暂停游戏
                isStart = !isStart;
            }
            repaint();//重新绘制界面,刷新页面
        }
        //键盘控制走向
        if(keyCode == KeyEvent.VK_LEFT){
            fx = "L";
        }else if(keyCode ==KeyEvent.VK_RIGHT){
            fx = "R";
        }else if(keyCode ==KeyEvent.VK_UP){
            fx = "U";
        }else if(keyCode ==KeyEvent.VK_DOWN){
            fx = "D";
        }
    }
    //定时器:监听时间,帧
    @Override
    public void actionPerformed(ActionEvent e) {
        //如果游戏处于开始状态,并且游戏没有结束
        if (isStart && isFail==false){
            //右移
            for (int i = length-1; i >0; i--) {//除了脑袋,身体都向前移动
                shakeX[i] = shakeX[i-1];
                shakeY[i] = shakeY[i-1];
            }
            //通过控制方向让头部移动起来
            if (fx.equals("R")){
                shakeX[0] = shakeX[0]+25; //头部移动
                if (shakeX[0]>850){shakeX[0]=25;} //边界判断
            }else if(fx.equals("L")){
                shakeX[0] = shakeX[0]-25; //头部移动
                if (shakeX[0]<25){shakeX[0]=850;} //边界判断
            }else if(fx.equals("U")) {
                shakeY[0] = shakeY[0] - 25; //头部移动
                if (shakeY[0] < 75) {shakeY[0] = 650;} //边界判断
            }else if(fx.equals("D")) {
                shakeY[0] = shakeY[0] + 25; //头部移动
                if (shakeY[0] > 650) {shakeY[0] = 75;} //边界判断
            }
            //如果小蛇的头和咱们的食物坐标重合了
            if (shakeX[0] == foodx && shakeY[0] == foody){
                //长度 + 1
                length ++;
                //分数
                score +=10;
                //重新生成食物
                foodx = 25 + 25*random.nextInt(34);
                foody = 75 + 25*random.nextInt(24);
            }

            //结束判断
            for (int i = 1; i <length ; i++) {
                if (shakeX[0]==shakeX[i] && shakeY[0]==shakeY[i]){
                    isFail = true;
                }
            }
            repaint();//刷新页面
        }
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //键盘按下,弹起:敲击
    }
    @Override
    public void keyReleased(KeyEvent e) {
        //释放某个键
    }



}
//bilibili.com/video/BV1HE41127CV?p=8&spm_id_from=pageDriver
