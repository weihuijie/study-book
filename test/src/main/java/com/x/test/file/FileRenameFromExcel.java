package com.x.test.file;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;

import java.io.File;
import java.util.*;

/**
 * @author: weihuijie
 * @date: 2020/12/25
 * @description: 从cvs获取名字重命名文件
 */
public class FileRenameFromExcel {
    private static String pack = "D:\\学习\\测试\\";
    private static String url = pack + "liansiaiqi-994585482024501249(20180510_223032)-1338119481051107329(20201213_215159)-media"+".xls";
    //可以在中括号内加上任何想要替换的字符，实际上是一个正则表达式
    private static String regEx="[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
    private static String aa = "";//这里是将特殊字符换为aa字符串,""代表直接去掉
    private static Map<String,String> map = new HashMap<>();
    public static void main(String[] args) {
        readExcel();
    }


    /**
     *  读取excel
     * @return
     */
    private static void readExcel(){
        /**
         *  获取文件名
         */
        List<String> nameList = getFilesName();
        ExcelUtil.readBySax(url, 0, new RowHandler() {
            @Override
            public void handle(int i, int row, List<Object> list) {
                if (row > 5){
                    map.put(String.valueOf(list.get(7)),String.valueOf(list.get(9)));
                }
            }
        });
        for (String s : nameList) {
            if (map.containsKey(s)){
                reName(s,map.get(s));
            }
        }
    }

    /**
     *  获取文件夹下文件的名字
     * @return
     */
    private static List<String> getFilesName(){
        File file = new File(pack);
        String[] fileNames = file.list();
        List<String> arrayList = Arrays.asList(fileNames);
        List<String> list = new ArrayList<>(arrayList) ;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).endsWith(".cvs") || arrayList.get(i).endsWith(".xls") || arrayList.get(i).endsWith(".rar") || arrayList.get(i).endsWith(".log")){
                list.remove(arrayList.get(i));
            }
        }
        return list;
    }

    private static void reName(String oldName,String newName){
        File file = new File(pack+oldName);
        String[] strings = oldName.split("-");
        String[] newStrings = newName.split("http");
        newName = newStrings[0].replaceAll(regEx,aa);
        newName = newName + "-" + strings[strings.length-1];
        if (file.renameTo(new File(pack+newName))) {
            System.out.println(oldName + "--->" + newName);
        } else{
            newName.split(".");
            System.out.println("修改失败");
        }
    }
}
