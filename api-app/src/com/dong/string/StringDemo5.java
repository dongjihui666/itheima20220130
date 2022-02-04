package com.dong.string;

/**
 * 目标 掌握String常用的其他API
 */
public class StringDemo5 {
    public static void main(String[] args) {
        //1 public int length() 获取字符串的长度
        String name = "我爱你中国love";
        System.out.println(name.length());

        //2 public char charAt(int index); 获取某个索引位置处的字符

        char c = name.charAt(1);
        System.out.println(c);
        System.out.println("--------遍历-----------");
        for (int i = 0; i <name.length() ; i++) {
            char c1 = name.charAt(i);
            System.out.println(c1);

        }

        //3 public char[] toharArray(); 把字符串转换成字符数组
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            System.out.println(aChar);

        }

        // 4 public String substring(int beginIndex,int endIndex) 截取内容,包前不包后
        String name2 = "java是最厉害的编程语言";
        String rs = name2.substring(0, 9);
        System.out.println(rs);
        //5 public String substring(int beginIndex); 从当前索引一直截取到末尾
        String substring = name2.substring(4);
        System.out.println(substring);

        //6 public String replace(CharSequence target,CharSequence replacement)
        //是把指定的字符替换掉
        String name3 = "小王是最厉害的80后,我好爱小王,小王真猛";
        String s = name3.replace("小王", "**");
        System.out.println(s);


        //7 public boolean contains(CharSequence s)
        //包含不包含指定字符
        System.out.println(name3.contains("小王"));

        //8 public boolean startWiths(String prefix)
        //判断以什么开始
        System.out.println(name3.startsWith("小王"));

        //9 public String[] split(String  s) 按照某个内容把字符串分割成字符串数组返回
        String name4 = "王宝强,贾乃亮,陈羽凡,谢霆锋";
        String[] names = name4.split(",");
        for (int i = 0; i < names.length; i++) {
            System.out.println("选择"+names[i]);
        }

    }

}
