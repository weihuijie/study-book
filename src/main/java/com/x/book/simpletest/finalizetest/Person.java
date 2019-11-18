package com.x.book.simpletest.finalizetest;

/**
 * 人员
 *
 * @author whj
 * @date 2019/11/1 11:09
 */

class Person {
    private String name;
    private Integer age;
    public Person(String name ,Integer age){
        this.name = name;
        this.age = age;
    };

    @Override
    protected void finalize() throws Throwable {
        System.out.println(name+","+age);
    }
}
