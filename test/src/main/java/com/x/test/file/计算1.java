//package com.x.test.file;
//
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVPrinter;
//import org.apache.commons.csv.CSVRecord;
//import org.apache.ibatis.annotations.ResultType;
//
//import java.io.*;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class 计算1 {
//
//    public static void main(String[] args) throws Exception {
//        cvsRead();
//    }
//
//    public static void cvsRead() throws IOException {
//        InputStream is = new FileInputStream("D:\\土壤水分数据.csv");
//        InputStreamReader isr = new InputStreamReader(is, "GBK");
//
//        FileOutputStream mrdfos = new FileOutputStream("D:\\MRD.csv");
//        OutputStreamWriter mrdosw = new OutputStreamWriter(mrdfos, "GBK");
//
//        FileOutputStream sdrdfos = new FileOutputStream("D:\\SDRD.csv");
//        OutputStreamWriter sdrdosw = new OutputStreamWriter(sdrdfos, "GBK");
//
//
//        Reader reader = new BufferedReader(isr);
//
//        CSVParser parser = CSVFormat.EXCEL.withHeader(MyHeaderEnum.class).parse(reader);
//
//        List<String> res = new ArrayList<String>();
//        //存放读取的值
//        Map<String, List<BigDecimal>> resMap = new HashMap<>();
//        Map<String, List<BigDecimal>> resultMap = new HashMap<>();
//        //平均值
//        BigDecimal svg = new BigDecimal("0");
//        //和
//        BigDecimal b = new BigDecimal("0");
//        //平均数的和
//        BigDecimal svgSum = new BigDecimal("0");
//        //小数点精确位数
//        int xs = 9;
//        //数据组行数
//        int row = 35;
//        //结果
//        BigDecimal result = new BigDecimal("0");
//
//        List<CSVRecord> list = parser.getRecords();
//        //数据组数
//        int n = list.size() / row;
//        for (MyHeaderEnum s : MyHeaderEnum.values()) {
//            if ("Depth".equals(s.toString()) || "Date".equals(s.toString())) {
//                continue;
//            }
//            //初始胡resMap
//            resMap.put(s.toString(), new ArrayList<>());
//            resultMap.put(s.toString(), new ArrayList<>());
//        }
//        for (int j = 1; j <= row; j++) {
//            for (int i = j; i < list.size(); i = i + row) {
//                //获取第一行数据的值
//                CSVRecord record = list.get(i);
//                for (MyHeaderEnum s : MyHeaderEnum.values()) {
//                    if ("Depth".equals(s.toString()) || "Date".equals(s.toString())) {
//                        continue;
//                    }
//                    //resMap赋值
//                    resMap.get(s.toString()).add(new BigDecimal(record.get(s.toString())));
//                }
//            }
//        }
//        for (int j = 1; j <= row; j++) {
//            for (MyHeaderEnum s : MyHeaderEnum.values()) {
//                if ("Depth".equals(s.toString()) || "Date".equals(s.toString())) {
//                    continue;
//                }
//                //
//                List<BigDecimal> list1 = resMap.get(s.toString()).subList((j - 1) * n, j * n);
//                b = new BigDecimal("0");
//                //求和
//                for (BigDecimal b1 : list1) {
//                    b = b.add(b1);
//                }
//                //平均值
//                svg = b.divide(BigDecimal.valueOf(list1.size()), xs, RoundingMode.DOWN);
//                //求值
//                for (BigDecimal b1 : list1) {
//                    result = (b1.subtract(svg)).divide(svg, xs, RoundingMode.DOWN);
//                    svgSum = svgSum.add(result);
//                    System.out.println(svgSum);
//                }
//                result = svgSum.divide(BigDecimal.valueOf(list1.size()), xs, RoundingMode.DOWN);
//                svgSum = new BigDecimal("0");
//                resultMap.get(s.toString()).add(result);
//            }
//        }
//        parser.close();
//    }
//
//    public static void cvsWrite() throws Exception {
//        FileOutputStream fos = new FileOutputStream("E:/cjsworkspace/cjs-excel-demo/target/abc.csv");
//        OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
//
//        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("姓名", "年龄", "家乡");
//        CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);
//        for (int i = 0; i < 10; i++) {
//            csvPrinter.printRecord("张三", 20, "湖北");
//        }
//
//        csvPrinter.flush();
//        csvPrinter.close();
//
//    }
//
//    /**
//     * Using an enum to define a header
//     */
//    enum MyHeaderEnum {
//        Depth, Date, S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, S13, S14, S15, S16, S17, S18, S19, S20, S21, S22, S23, S24, S25, S26, S27
//    }
//}
