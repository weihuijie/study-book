package com.x.test.jvm;

/**
 * gc 测试
 *
 * @author whj
 * @date 2019/11/15 10:39
 */

public class GcTest {
    private static GcTest instance = null;

    public void alive(){
        System.out.println("i'm alive");
    }
    /**
     *  该方法只调用一次
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize()");
        GcTest.instance = this;
    }

    public static void main(String[] args) throws InterruptedException {
        instance = new GcTest();
        instance = null;
        System.gc();
        Thread.sleep(500);
        if (instance != null){
            instance.alive();
        }else {
            System.out.println("i'm dead");
        }

        instance = null;
        System.gc();
        Thread.sleep(500);
        if (instance != null){
            instance.alive();
        }else {
            System.out.println("i'm dead");
        }

    }
}
