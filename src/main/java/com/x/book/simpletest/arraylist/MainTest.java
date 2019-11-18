package com.x.book.simpletest.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * main
 *
 * @author whj
 * @date 2019/11/1 11:12
 */

class MainTest {

    static List<String> list = new ArrayList<>();
    static {
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("a");
        list.add("a");
    }

    public static void main(String[] args) {
//        delListTest();
//        delList1();
        delList2();
    }

    /**
     *  由于数组长度变化，所以此删除方法不可行
     */
    public static void delListTest(){

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("a")){
                list.remove(i);
            }
        }
        System.out.println(list);//[a, c, a]
    }

    /**
     *  逆向遍历List删除
     */
    public static void  delList1(){
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals("a")){
                list.remove(i);
            }
        }
        System.out.println(list);//
    }

    /**
     *  迭代器
     */
    public static void delList2(){
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            /*
             * 没有it.next();这一行， 就会抛出java.lang.IllegalStateException异常，原因<br>“
             * 要删除集合中某一个不满足条件的元素
             * ，通过Iterator来删除，首先需要使用next方法迭代出集合中的元素
             * ，然后才能调用remove方法，否则集合可能抛出java
             * .lang.IllegalStateException异常。”
             */
            iterator.next();
            if (iterator.next().equals("a")){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
