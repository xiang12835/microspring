# Spring Cloud

## 启动

- 打开pom.xml
- 运行数据库
- 运行 ApiApplication
- 浏览器打开 http://localhost:9000/swagger-ui.html

## 介绍

>common

公共

- common-swagger（进行中）

[springboot项目集成swagger-bootstrap-ui详细版](https://blog.csdn.net/Xiaodongge521/article/details/102857461)

>office

- 智能办公、知识库

>registry

服务注册与发现

>proxy (进行中)

调用第三方

>gateway

网关工程

>scheduler

定时任务

>identity (进行中)

IDP: Identity Provider

>monitor (进行中)

微服务监控

- log
- trace
- metrics

>admin (进行中)

Spring Boot Admin

目前所有的端点信息都是通过 HTTP 访问的，数据也是 Json 格式的，如果直接通过这些数据来查看某些指标不是很直观，这时我们可以通过 Spring Boot Admin 来对 actuator 信息进行管理。

Spring Boot Admin 是一个开源的 Web 项目，用于管理和监控 Spring Boot 应用程序的运行状态。在 Spring Boot 项目中可以通过集成 Spring Boot Admin Client 向 Spring Boot Admin Server 进行注册，这样我们就可以在Spring Boot Admin Server 统一管理 Spring Boot 应用。

Spring Boot Admin 主要功能点：

- 显示应用程序的监控状态
- 应用程序上下线监控  
- 查看 JVM 和线程信息
- 可视化的查看日志及下载日志文件
- 动态切换日志级别
- HTTP 请求信息跟踪等实用功能
- 将 actuator 提供的数据进行可视化

## 功能

>服务通信 (进行中)

- 服务访问：Feign（RESTful 通信）
- 负载均衡：Ribbon（实现服务间稳定通信）

>服务网关

- Spring Cloud Gateway

[SpringCloud gateway （史上最全）](https://www.cnblogs.com/crazymakercircle/p/11704077.html)

>服务治理

- Eureka

>服务容错

- 超时
- 熔断：Hystrix

通过 Hystrix Dashboard 来进行图形化的展示，能够更直观的看出系统当前的运行状态。

1. 访问 `http://localhost:9090/hystrix` 断路器 web 监控页面。
2. 添加地址 `http://localhost:9090/hystrix.stream`，确定监控。可监控本机 9090 端口的断路器数据。

？：Unable to connect to Command Metric Stream.

Proxy opening connection to: http://localhost:9090/hystrix.stream


- 隔离
- 限流：GateWay + Redis（分布式），Guava（单机）
- 降级
- 重试：网关的过滤器实现

>服务调度

- [Spring Boot(九)：定时任务](http://www.ityouknow.com/springboot/2016/12/02/spring-boot-scheduler.html)

>服务安全

IDP: Identity Provider

主要负责 Oauth 2.0 授权协议的处理，还有 Oauth 2.0 和 JWT 令牌颁发以及管理，使用 Login Svc 来进行用户认证，技术选型 Spring Security OAuth （可以企业定制）和 KeyCloak （开箱即用 + OIDC） 

>服务监控

- ELK
- SkyWalking
- Prometheus
- Spring Boot actuator 健康监控 
