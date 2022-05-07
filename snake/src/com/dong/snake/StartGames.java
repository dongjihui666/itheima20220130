package com.dong.snake;

import javax.swing.*;

public class StartGames {
    public static void main(String[] args) {
        //1 绘制一个静态窗口   JFrame
        JFrame frame = new JFrame("贪吃蛇小游戏");
        //设置界面的一个大小
        frame.setBounds(10,10,900,720);
        //窗口大小不可以改变
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设计关闭事件,游戏就可以关闭了

        //2 画板 JPanel 可以加入到JFrame

        frame.add(new GamePanel());
        frame.setVisible(true);//让窗口能够展示出来


    }
}
