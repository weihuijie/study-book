package com.x.book.simpletest.generic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static com.x.book.simpletest.generic.Generic.printMsg;

/**
 * main
 *
 * @author whj
 * @date 2019/11/1 11:12
 */
@Slf4j
class MainTest {
    public static void main(String[] args) {
//        aGenericTest();
        testGenericClass();
    }


    /**
     * 泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
     */
    public static void aGenericTest(){
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        Class stringsClass = strings.getClass();
        Class integersClass = integers.getClass();

        if (stringsClass.equals(integersClass)){
            log.info("泛型类型相同");
        }
    }

    /**
     * 泛型类测试
     */
    public static void testGenericClass(){
        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> generic = new Generic<>(1);
        Generic<String> genericStr = new Generic<>("001");
        log.info(generic.getGeneric()+genericStr.getGeneric());
        printMsg(generic);
        printMsg(genericStr);
    }

}
