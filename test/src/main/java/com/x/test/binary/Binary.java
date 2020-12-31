package com.x.test.binary;

/**
 * @author: weihuijie
 * @date: 2020/12/25
 * @description: 生成二进制
 */
public class Binary {
    public static void main(String[] args) {
        String i = "2";
        int n = 100;
        while (n >0){
            n--;
            i = AddLongInteger(i,i);
            System.out.println(i);
        }
    }

    /**
     *  超长整数相加
     * @param addend
     * @param augend
     * @return
     */
    public static String AddLongInteger(String addend,String augend){
        char[] a1=addend.toCharArray();
        char[] a2=augend.toCharArray();
        //获取最大长度
        int result=a1.length>a2.length?a1.length+1:a2.length+1;
        //创建存放结果数组
        char[] c1=new char[result];
        //创建存储翻转后数据的数组
        char[] b1=new char[a1.length];
        char[] b2=new char[a2.length];
        //将输入值1进行翻转存储
        for(int i=0;i<a1.length;i++){
            b1[i]=a1[a1.length-1-i];
        }
        //将输入值2进行翻转存储
        for(int i=0;i<a2.length;i++){
            b2[i]=a2[a2.length-1-i];
        }
        //初始化c1数组
        for(int i=0;i<c1.length;i++){
            c1[i]='0';
        }
        //相加存储
        for(int i=0;i<result-1;i++){
            //逐位相加
            int count=0;
            if(b1.length-1-i>=0 && b2.length-1-i>=0){
                count=b1[i]-'0'+b2[i]-'0';
            }
            else if(b1.length-1-i>=0 && b2.length-1-i<0){
                count=b1[i]-'0';
            }
            else if(b1.length-1-i<0 && b2.length-1-i>=0){
                count=b2[i]-'0';
            }
            int value=c1[i]-'0'+count;
            c1[i]=(char)(value%10+'0');
            c1[i+1]+=value/10;
        }
        //判断最后一位是否为0
        while (c1[result-1]=='0'){
            result--;
        }
        char[] c2=new char[result];
        for(int i=0;i<result;i++){
            c2[result-1-i]=c1[i];
        }
        String str=new String(c2);
        return str;
    }
}
