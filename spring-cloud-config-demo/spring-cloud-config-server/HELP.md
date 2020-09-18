[toc]
## zookeeper 注册中心

### 版本
jdk:1.8  
zookeeper:3.5

Spring-boot:2.2.6.RELEASE  
* spring-boot-starter-web

spring-cloud-dependencies:Hoxton.SR4
* spring-cloud-starter-zookeeper-discovery

### zookeeper安装

```shell
docker search zookeeper:3.5
docker pull zookeeper:3.5
docker run  -p 2181:2181  zookeeper:3.5
```

### 说明

@EnableDiscoveryClient,开启服务发现，允许被其他服务观察到。

### 配置说明
application.yml  
```yaml
# 端口
server:
  port: 8081
spring:
  application:
    name: zookeeper-server #作为注册到zookeeper上的名称
  cloud:
    zookeeper:
      connect-string: 192.168.65.129:2181 #zookeeper连接地址
      discovery:
      	# zookeeper上当前服务的地址
        instance-host: ${spring.cloud.client.ip-address} 
        # zookeeper上当前服务的端口
        instance-port: ${server.port}
        
```

**${spring.cloud.client.ip-address}**: 动态获取服务地址

https://www.cnblogs.com/wf614/p/12919800.html

END



