package sort.五亿整数排序;

import cn.hutool.core.date.DateUtil;
import java.io.*;

/**
 * 生成5亿个整数
 *
 * @author whj
 * @date 2019/11/15 15:54
 */

public class CreatFiveBillion{
    static FileOutputStream out = null;
    static int n = 445;
    public static void write(){
        String rn = "\r\n";
        try {
            long startDate  = DateUtil.currentSeconds();
            out = new FileOutputStream(new File("E://5Billion.txt"),true);
            for (int i = 0; i < 1000000; i++) {
                int num =(int) (Math.random()*9999999*10);
                out.write(String.valueOf(num).getBytes());
                out.write(rn.getBytes());
                System.out.println("第"+i+"个数："+num);
            }
            long endDate  = DateUtil.currentSeconds();
            System.out.println(n+"---所用时间："+(endDate-startDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            n--;
            write();
        }
    }

}
