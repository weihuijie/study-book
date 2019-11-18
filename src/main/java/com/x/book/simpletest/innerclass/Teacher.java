package com.x.book.simpletest.innerclass;

import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

/**
 * @author whj
 * @date 2019/11/1 11:22
 */
@Slf4j
public class Teacher {
    Teacher(String name,String age){
        this.name = name;
        this.age = age;
    };

    public String name;
    private String age;
    class Sex{
        public String men = "男";
        private String women = "女";
        //普通的内部类不能有static数据和static字段
//        public static String m = "中年";
        public void print(){
            //内部类直接获取外部类属性
            name = "成内";
            age = "1";
            log.info(name+"，"+age);
        }
    }
    static class Person{
        public String yong = "年轻";
        private String old = "年长";
        public void print(){
            //静态内部类无法直接获取外部类实例属性
            //需创建外部类实例
            Teacher t = new Teacher("静内","2");
            log.info(t.name+"，"+t.age);
        }
    }

    public void print() {
        Teacher.Person p = new Teacher.Person();
        Teacher.Sex s = new Teacher.Sex();
        name = "小苍";
        age = "22";
        log.info(name+"-"+age+"-"+p.yong+"-"+s.women);
    };

    public void methodClass(){
        Runnable r = new Runnable(){
            @Override
            public void run() {
                print();
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}
