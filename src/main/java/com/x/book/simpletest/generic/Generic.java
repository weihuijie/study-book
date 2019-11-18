package com.x.book.simpletest.generic;

import lombok.extern.slf4j.Slf4j;

/**
 * 泛型类
 *
 * @author whj
 * @date 2019/11/4 10:40
 */
@Slf4j
public class Generic<T> implements Generator<T>{
    /**
     * t这个成员变量的类型为T,T的类型由外部指定
     */
    private T t;

    /**
     * 泛型构造方法形参key的类型也为T，T的类型由外部指定
     * @param t
     */
    public Generic(T t){
        this.t = t;
    }

    public T getGeneric(){
        return t;
    }

    /**
     * 获取信息
     *
     * @return T
     */
    @Override
    public T getMsg() {
        return null;
    }

    /**
     * 泛型方法的基本介绍
     * @param generic 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public static <E> void printMsg(Generic<E> generic){
        log.info(generic.getGeneric().toString());
    }

    /**
     *  //这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
     * @param generic
     * @param i 切割字符串
     */
    public static void printMsgSub(Generic<String> generic,Integer i){
        log.info(generic.getGeneric().substring(i));
    }

    /**
     * 这也不是一个泛型方法，这也是一个普通的方法，只不过使用了泛型通配符?
     * @param generic
     * @param b
     */
    public static void printMsgSub(Generic<?> generic,Boolean b){
        log.info(generic.getGeneric().toString());
    }

    /**
     * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
     * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
     * 如：public static void show(T t){..},此时编译器会提示错误信息：
     "StaticGenerator cannot be refrenced from static context"
     */
    public static <E> E printMsg(E... es){
        for (E e : es){
            return e;
        }
        return null;
    }

    /**
     * 非泛型方法使用泛型
     * 在使用泛型的时候，我们还可以为传入的泛型类型实参进行上下边界的限制，如：类型实参只准传入某种类型的父类或某种类型的子类。
     * @param generic
     */
    public static void printMsgSun(Generic<? extends Number> generic){
        generic.getMsg();
    }

    /**
     * //在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<E>上添加上下边界，即在泛型声明的时候添加
     * //public <T> T showKeyName(Generic<T extends Number> container)，编译器会报错："Unexpected bound"
     * @param e
     * @param <E>
     * @return
     */
    public static  <E extends  Number> E  printMsgE(Generic<E> e){
        return null;
    }
}
