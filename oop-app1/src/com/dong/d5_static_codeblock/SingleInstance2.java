package com.dong.d5_static_codeblock;

/**
 * 目标:学会使用懒汉单例设计模式单例类
 */
public class SingleInstance2 {
/**
 * 2 创建一个静态的成员变量,存储本类的对象,注意:此时不能初始化对象
 *
 */

   private  static SingleInstance2 instance;
    /**
     * 1 私有构造器
     *
     */
    private SingleInstance2(){

    }
    /**
     * 3 定义一个方法,让其他地方可以来调用获取一个对象
     */

    public static SingleInstance2 getInstance(){
        if(instance == null){
            //第一次来获取对象
          instance =  new SingleInstance2();
        }
        return instance;
    }

}
