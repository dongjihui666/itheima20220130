package com.dong.d3_static_test;

public class Test2 {
    /**
     * 需求:在实际开发中,经常会遇到一些数组使用的工具类,请按照如下要求编写一个数组的工具类:ArrayUtils
     * 1 我们知道数组对象直接输出的时候是输出对象的地址的,而项目中很多地方都需要返回数组的内容,请在
     * ArrayUtiils中提供一个工具类方法toString;用于返回整数数组的内容,返回的字符串格式如:[10,20,50,34,100]
     * (只考虑整形数组,而且只考虑一维数组)
     * 2 经常需要统计平均值,平均值为去掉最低分和最高分后的分值,请提供这样一个工具方法getAerage,用于返回平均分(只考虑浮点型整数,且只考虑一维数组)
     *
     * 3 定义一个测试类TestDemo,调用该工具类的工具方法,并返回结果.
     */
    public static void main(String[] args) {
        int[] arr = {20,30,40,50,60,70,100};
        System.out.println(ArrayUtils.toString(arr));

        System.out.println(ArrayUtils.getAverage(arr));

    }
}
