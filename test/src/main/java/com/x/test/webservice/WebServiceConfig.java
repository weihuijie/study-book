package com.x.test.webservice;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * 配置发布
 * - 默认服务发布在Host:port/services/*路径下 ，如需改变默认路径可配置ServletRegistrationBean
 * - endpoint.publish("/weather"); 发布的路径，此时访问路径为:localhost:20006/ws-api/weather?wsdl
 * - 多个发布需多个Endpoint @Bean
 *
 * @author whj
 * @date 2019/8/21 16:51
 */
@Configuration
public class WebServiceConfig {
    @Autowired
    private Bus bus;

    @Autowired
    MyWebService myWebService;

    @Bean
    public ServletRegistrationBean dispatcherServlet(){
        return new ServletRegistrationBean(new CXFServlet(), "/ws/*");
    }
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, myWebService);
        endpoint.publish("/getString");
        return endpoint;
    }
}
