package com.x.test.template.dao;

import com.google.common.base.CaseFormat;

import java.util.Arrays;
import java.util.List;

/**
 * @author: weihuijie
 * @date: 2020/12/4
 * @description: 增删改查模板
 */
public class MybatisEX {
    public static void main(String[] args) {
        String s = "personRecId,personId,isTransfer,recName,recDocType,recDocCode,recBankNo,recOpenBank";
        List<String> list = Arrays.asList(s.split(","));
        sql(list,"a");
//        insertInto(list);
//        insertValues(list);
//        updateSet(list);
//        tableADD(list,"pcac_merchant_riskinfo");
    }


    private static void sql(List<String> list,String alias){
        for (String s : list) {
            String str = alias+"."+ CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,s)+" AS \""+s+"\",\r\n";
            System.out.print(str);
        }
    }

    private static void insertInto(List<String> list){
        for (String s : list) {
            String str = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,s)+",\r\n";
            System.out.print(str);
        }
    }

    private static void insertValues(List<String> list){
        for (String s : list) {
            String str = "#{"+s+"},\r\n";
            System.out.print(str);
        }
    }

    private static void updateSet(List<String> list){
        for (String s : list) {
            String str = "<if test=\""+s+" != null and "+s+" != \'\'\">\r\n    "+CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,s)+" = "+"#{"+s+"},\r\n</if>\r\n";
            System.out.print(str);
        }
    }

    private static void tableADD(List<String> list,String table){
        for (String s : list) {
            String str = "alter table "+table+" add "+CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,s)+" varchar () null comment '';\r\n";
            System.out.print(str);
        }
    }

}
