package com.dong.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 案例 : 学生信息系统,展示数据,并按照学号完成搜索
 * 学生类信息(学号,姓名,性别,班级)
 *
 * 测试数据:
 * "20180302","叶孤城",25,"护理一班"
 * "20180303","东方不败",23,"推拿二班"
 * "20180304","西门吹雪",26,"中药学四班"
 * "20180305","梅超风",26,"神经科2班"
 */
public class ArrayListTest6 {
    public static void main(String[] args) {

        //1 定义一个学生类,后期用于创建对象封装数据Student类

        //2 定义一个集合对象用于装学生对象
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("20180302","叶孤城",25,"护理一班"));
        students.add(new Student("20180303","东方不败",23,"推拿二班"));
        students.add(new Student("20180304","西门吹雪",26,"中药学四班"));
        students.add(new Student("20180305","梅超风",26,"神经科2班"));
        //3 遍历集合中的每个学生对象并展示出数据
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(student.getStudyId() + student.getName() + student.getAge() + student.getClassName());


        }
        //4 让用户不断的输入学号,可以搜索出该学生对象信息并展示出来(独立方法)
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("请您输入学号");
            String id = s.next();
            Student st = getStudentByStudyId(students, id);
            //判断学号是否存在
            if(st == null){
                System.out.println("查无此人");
            }else {
                //找到了该学生对象,信息如下
                System.out.println(st.getStudyId() + st.getName() + st.getAge() + st.getClassName());
            }
        }
    }

    /**
     * 根据学号,去集合中找出学生对象并返回
     * @param students
     * @param studyId
     * @return
     */
    public static Student getStudentByStudyId(ArrayList<Student> students,String studyId){

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if(student.getStudyId().equals(studyId)){
                return student;
            }
        }
        return null;

    }
}
