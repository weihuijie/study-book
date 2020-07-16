package Singleton;

/**
 * 懒汉式
 *
 * @author whj
 * @date 2019/10/15 10:31
 */

public class LHS {
    /**
     * 构造器私有化
     */
    private LHS(){};
    /**
     * 初始化实例
     */
    private static LHS instance = null;
    /**
     * 静态工厂方法
     */
    public static LHS getInstance(){
        if (null == instance){
            instance = new LHS();
        }
        return instance;
    }

}
