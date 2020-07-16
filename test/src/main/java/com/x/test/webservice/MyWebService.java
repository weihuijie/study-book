package com.x.test.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * web service 测试
 *
 * 接口中添加注解，可使用接口客户端调用
 * 实现类添加注解，可使用动态调用
 *
 * @author whj
 * @date 2019/8/21 16:25
 */
@WebService(
//        serviceName = "MyTestWS", //该webservice服务的名称 实现类指定接口的话，这个接口和实现类只需要写一个
        targetNamespace = "http://webservice.example.x.com" //与接口中的命名空间一致,一般是接口的包名倒写
)
public interface MyWebService {
    @WebMethod(
            operationName = "getString",//发布的方法名称
            exclude = false // 默认fase: 表示发布该方法  true:表示不发布此方法
    )
    @WebResult(name = "result")String getString(@WebParam(name = "param")String s);
}
