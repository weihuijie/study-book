package com.x.test.webservice;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * WebService 客户端
 *
 * @author whj
 * @date 2019/8/21 17:25
 */

public class MyWebServiceClient {
    public static void main(String[] args) {
        getString1("hello1");
        getString2("hello2");
    }

    /**
     * 方式1.代理类工厂的方式,需要拿到对方的接口
     */
    public static String getString1(String s){
        try {
            // 接口地址
            String address = "http://localhost:8080/ws/getString?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(MyWebService.class);
            // 创建一个代理接口实现
            MyWebService cs = (MyWebService) jaxWsProxyFactoryBean.create();
            // 数据准备
            // 调用代理接口的方法调用并返回结果
            String result = cs.getString(s);
            System.out.println("返回结果:" + result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 动态调用
     * @param s
     * @return
     */
    public static String getString2(String s){
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/ws/getString?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
        // PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("getString", s);
            System.out.println("返回数据:" + objects[0]);
            return String.valueOf(objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
