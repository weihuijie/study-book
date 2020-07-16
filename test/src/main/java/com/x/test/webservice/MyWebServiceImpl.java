package com.x.test.webservice;

import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author whj
 * @date 2019/8/21 16:35
 */

//@WebService表示该类是一个服务类，需要发布其中的public的方法
//@BindingType(SOAPBinding.SOAP12HTTP_BINDING)//标识使用soap1.1 还是1.2协议通信,默认1.1
//http://localhost:8080/ws/getString?wsdl  访问
@WebService(
        serviceName = "MyTestWS", //该webservice服务的名称
        targetNamespace = "http://webservice.example.x.com" ,//与接口中的命名空间一致,一般是接口的包名倒写
        endpointInterface = "com.x.test.webservice.MyWebService" //接口
)
@Component
public class MyWebServiceImpl implements MyWebService {
    @WebMethod(
            operationName = "getString",//发布的方法名称
            exclude = false // 默认fase: 表示发布该方法  true:表示不发布此方法
    )
    @Override
    //WebResult :返回值名称 WebParam:参数名称
    public @WebResult(name = "result") String getString(@WebParam(name = "param") String s) {
        return s;
    }
}
