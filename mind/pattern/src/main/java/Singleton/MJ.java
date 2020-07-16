package Singleton;

/**
 * 枚举
 *
 * @author whj
 * @date 2019/10/15 11:20
 */

public enum  MJ {
    instance;

    private MJ getInstance(){
        return instance;
    }
}
