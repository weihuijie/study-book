BUS消息总线解决配置更新问题（向服务发送 POST请求告知配置信息改变）。
只需在 spring cloud server 端发出 refresh，就可以触发所有微服务更新。

spring cloud bus 内嵌至 spring cloud config server,spring cloud config client