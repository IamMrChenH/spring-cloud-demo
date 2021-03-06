[toc]

### 代码依赖

jdk:1.8

Spring-boot:1.5.4.RELEASE  

* spring-boot-starter
* spring-boot-starter-web

spring-cloud-dependencies:Dalston.SR4

* spring-cloud-starter-eureka-server//作为注册中心
* spring-cloud-starter-eureka//
* spring-boot-starter-actuator //健康检查





### eureka-server(注册中心)

* PORT 8080
* @EnableEurekaServer 开启注册中心功能

### eureka-client-server(服务提供者)

* PORT 8081
* @EnableEurekaClient 提供远程服务

### eureka-client-consumer(消费者)

* PORT 8082
* @EnableEurekaClient 提供远程服务

#### eureka-client-ribbon(消费者-服务转换地址-负载均衡)

* PORT 8083
* @EnableEurekaClient 提供远程服务

新增依赖:
```xml
 <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-ribbon</artifactId>
 </dependency>
```
#### eureka-client-feign(消费者-“接口”转“远程访问”-负载均衡)
* PORT 8084
* @EnableEurekaClient 提供远程服务
* @EnableFeignClients 开启FeignClient 接口远程访问功能
新增依赖:
```xml
 <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-feign</artifactId>
 </dependency>
```

#### eureka-client-feign-file(消费者-feign上传文件-负载均衡)
* PORT 8085
* @EnableEurekaClient 提供远程服务
* @EnableFeignClients 开启FeignClient 接口远程访问功能
新增依赖: 上传文件用
```xml
<dependency>
    <groupId>io.github.openfeign.form</groupId>
    <artifactId>feign-form</artifactId>
    <version>3.0.3</version>
</dependency>
<dependency>
    <groupId>io.github.openfeign.form</groupId>
    <artifactId>feign-form-spring</artifactId>
    <version>3.0.3</version>
</dependency>
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.3.3</version>
</dependency>
```
