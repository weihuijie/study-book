package com.x.test.innerclass;

/**
 * main
 *
 * @author whj
 * @date 2019/11/1 11:12
 */

class MainTest {
    public static void main(String[] args) {
        Teacher t = new Teacher("老师","21");
        //静态内部类
        Teacher.Person p = new Teacher.Person();
        //成员内部类
        Teacher.Sex s = t.new Sex();
        //私有属性无法在此使用
        t.print();
        p.print();
        s.print();
        //方法内的类
        t.methodClass();

    }
}
