//package com.x.test.file;
//
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVPrinter;
//import org.apache.commons.csv.CSVRecord;
//
//import java.io.*;
//import java.math.BigDecimal;
//import java.math.MathContext;
//import java.math.RoundingMode;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class 计算2 {
//
//    public static void main(String[] args) throws Exception {
//        cvsRead();
////        BigDecimal s = sqrt(new BigDecimal("2"),50);
////        System.out.println(s);
//    }
//
//    public static void cvsRead() throws Exception {
//        InputStream is = new FileInputStream("D:\\土壤水分数据.csv");
//        InputStreamReader isr = new InputStreamReader(is, "GBK");
//
//        FileOutputStream sdrdfos = new FileOutputStream("D:\\SDRD.csv");
//        OutputStreamWriter sdrdosw = new OutputStreamWriter(sdrdfos, "GBK");
//
//
//        Reader reader = new BufferedReader(isr);
//        //读取
//        CSVParser parser = CSVFormat.EXCEL.withHeader(MyHeaderEnum.class).parse(reader);
//
//        List<String> res = new ArrayList<String>();
//        //存放读取的值
//        Map<String, List<BigDecimal>> resMap = new HashMap<>();
//
//        Map<String, List<BigDecimal>> resultMap = new HashMap<>();
//        Map<String, List<BigDecimal>> mrdMap = new HashMap<>();
//
//        Map<String, List<BigDecimal>> sdrdMap = new HashMap<>();
//        //平均值
//        BigDecimal svg = new BigDecimal("0");
//        //平均值
//        BigDecimal mrd = new BigDecimal("0");
//        BigDecimal sdrd = new BigDecimal("0");
//        //小数点精确位数
//        int xs = 5;
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
//            mrdMap.put(s.toString(), new ArrayList<>());
//            sdrdMap.put(s.toString(), new ArrayList<>());
//        }
//        //共有多少组数据
//        for (int j = 1; j <= n; j++) {
//            //获取第一组数据
//            for (int i = 1; i <= row; i++) {
//                //获取第一行数据的值
//                CSVRecord record = list.get(i + ((j - 1) * row));
//                for (MyHeaderEnum s : MyHeaderEnum.values()) {
//                    if ("Depth".equals(s.toString()) || "Date".equals(s.toString())) {
//                        continue;
//                    }
//                    //resMap赋值
//                    resMap.get(s.toString()).add(new BigDecimal(record.get(s.toString())));
//                }
//            }
//            //计算第一组数据
//            for (MyHeaderEnum s : MyHeaderEnum.values()) {
//                if ("Depth".equals(s.toString()) || "Date".equals(s.toString())) {
//                    continue;
//                }
//                //和
//                BigDecimal b = new BigDecimal("0");
//
//                //resMap赋值
//                List<BigDecimal> list1 = resMap.get(s.toString()).subList((j - 1) * row, j * row);
//                //求和
//                for (BigDecimal b1 : list1) {
//                    b = b.add(b1);
//                }
//                //平均值
//                svg = b.divide(BigDecimal.valueOf(list1.size()), xs, RoundingMode.DOWN);
//                //求值
//                for (int g = 0; g < list1.size(); g++) {
//                    BigDecimal b1 = list1.get(g);
//                    result = (b1.subtract(svg)).divide(svg, xs, RoundingMode.DOWN);
//                    resultMap.get(s.toString()).add(result);
//                }
//            }
//        }
//        for (int j = 0; j < row; j++) {
//            for (MyHeaderEnum s : MyHeaderEnum.values()) {
//                //平均数的和
//                BigDecimal svgSum = new BigDecimal("0");
//                if ("Depth".equals(s.toString()) || "Date".equals(s.toString())) {
//                    continue;
//                }
//                //resMap赋值
//                List<BigDecimal> list2 = resultMap.get(s.toString());
//                for (int i = j; i < list2.size(); i = i + row) {
//                    svgSum = svgSum.add(list2.get(i));
//                }
//                mrd = svgSum.divide(BigDecimal.valueOf(n), xs, RoundingMode.DOWN);
//                mrdMap.get(s.toString()).add(mrd);
//            }
//
//        }
//        parser.close();
//
//        //输出
//        FileOutputStream mrdfos = new FileOutputStream("D:\\MRD.csv");
//        OutputStreamWriter mrdosw = new OutputStreamWriter(mrdfos, "GBK");
//        CSVFormat csvFormat = CSVFormat.EXCEL.withHeader(MyHeaderEnumOut.class);
//
//        CSVPrinter csvPrinter = new CSVPrinter(mrdosw, csvFormat);
//        for (int i = 0; i < row; i++) {
//            StringBuffer sb = new StringBuffer();
//            for (MyHeaderEnumOut s : MyHeaderEnumOut.values()) {
//                sb.append(mrdMap.get(s.toString()).get(i)).append(",");
//            }
//            String resultStr = sb.toString().substring(0, sb.length() - 1);
//            csvPrinter.printRecord(resultStr.split(","));
//        }
//
//        csvPrinter.flush();
//        csvPrinter.close();
//
//        //计算SDRD
//        //一组数据行数
//        // q - q的平均值
//        BigDecimal q = new BigDecimal("0");
//        for (int j = 0; j < row; j++) {
//            //数据列数
//            for (MyHeaderEnum s : MyHeaderEnum.values()) {
//                //q - q的平均值 的平方
//                BigDecimal qFang = new BigDecimal("0");
//                BigDecimal qFangSum = new BigDecimal("0");
//                if ("Depth".equals(s.toString()) || "Date".equals(s.toString())) {
//                    continue;
//                }
//                //resMap赋值
//                List<BigDecimal> listSvg = resultMap.get(s.toString());
//                List<BigDecimal> listMrd = mrdMap.get(s.toString());
//                for (int i = j; i < listSvg.size(); i = i + row) {
//                    q = listSvg.get(i).subtract(listMrd.get(j));
//                    qFang = q.multiply(q);
//                    qFangSum = qFangSum.add(qFang);
//                }
//                sdrd = sqrt(qFangSum.divide((BigDecimal.valueOf(n).subtract(new BigDecimal("1"))), xs, RoundingMode.DOWN), xs);
//                sdrdMap.get(s.toString()).add(sdrd);
//            }
//        }
//
//        //输出
//        FileOutputStream SDRDfos = new FileOutputStream("D:\\SDRD.csv");
//        OutputStreamWriter SDRDdosw = new OutputStreamWriter(SDRDfos, "GBK");
//        CSVFormat csvFormatSDRD = CSVFormat.EXCEL.withHeader(MyHeaderEnumOut.class);
//
//        CSVPrinter csvPrinterSDRD = new CSVPrinter(SDRDdosw, csvFormatSDRD);
//        for (int i = 0; i < row; i++) {
//            StringBuffer sb = new StringBuffer();
//            for (MyHeaderEnumOut s : MyHeaderEnumOut.values()) {
//                sb.append(sdrdMap.get(s.toString()).get(i)).append(",");
//            }
//            String resultStr = sb.toString().substring(0, sb.length() - 1);
//            csvPrinterSDRD.printRecord(resultStr.split(","));
//        }
//
//        csvPrinterSDRD.flush();
//        csvPrinterSDRD.close();
//    }
//
//    private static void out(Map<String, List<BigDecimal>> mrdMap) throws Exception {
//
//    }
//
//    /**
//     * Using an enum to define a header
//     */
//    enum MyHeaderEnum {
//        Depth, Date, S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, S13, S14, S15, S16, S17, S18, S19, S20, S21, S22, S23, S24, S25, S26, S27
//    }
//
//    /**
//     * Using an enum to define a header
//     */
//    enum MyHeaderEnumOut {
//        S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, S13, S14, S15, S16, S17, S18, S19, S20, S21, S22, S23, S24, S25, S26, S27
//    }
//
//    /**
//     * 开方方法(牛顿迭代法)
//     *
//     * @param value
//     * @param xs
//     * @return
//     */
//    public static BigDecimal sqrt(BigDecimal value, int xs) {
//        BigDecimal num2 = BigDecimal.valueOf(2);
//        int precision = 100;
//        MathContext mc = new MathContext(precision, RoundingMode.HALF_UP);
//        BigDecimal deviation = value;
//        int cnt = 0;
//        while (cnt < precision) {
//            deviation = (deviation.add(value.divide(deviation, mc))).divide(num2, mc);
//            cnt++;
//        }
//        deviation = deviation.setScale(xs, BigDecimal.ROUND_HALF_UP);
//        return deviation;
//    }
//}
