[toc]
### zookeeper 安装&版本
zookeeper:3.5

```shell
docker search zookeeper:3.5
docker pull zookeeper:3.5
docker run  -p 2181:2181  zookeeper:3.5
```



### 代码依赖

jdk:1.8  

Spring-boot:2.2.6.RELEASE  
* spring-boot-starter-web

spring-cloud-dependencies:Hoxton.SR4
* spring-cloud-starter-zookeeper-discovery
* spring-cloud-starter-openfeign

### SDK

```xml
<groupId>com.example.demo</groupId>
<artifactId>zookeeper-server-sdk</artifactId>
<version>1.0.0-SNAPSHOT</version>
```

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```
代码：

```java
@Api(value = "测试接口", tags = "测试接口")
@FeignClient(name = "zookeeper注册的名称",
             serviceId = "zookeeper注册的名称")
@RequestMapping("/v1/user_sdk")
public interface UserService {

    /**
     * 根据用户名称-查询用户详情
     * @param name 用户名称
     * @return
     */
    @GetMapping("name/{name}")
    UserDTO findByName(@PathVariable("name") String name);

}
```

​		如果参数为RequestParam,一定要加RequestParam(“参数名”),否则FeignClient的解析有问题。



### Server

```xml
<!-- 依赖的sdk，并实现。 -->
<dependency>
    <groupId>com.example.demo</groupId>
    <artifactId>zookeeper-server-sdk</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
</dependency>
```



代码：

```java
@RestController("com.example.zookeeper.server.feign.UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO findByName(String name) {
        UserDTO user = new UserDTO();
        user.setId(Long.valueOf(RandomStringUtils.randomNumeric(3)));
        user.setName(name);
        user.setPhone(RandomStringUtils.randomNumeric(11));
        return user;
    }
}
```

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

启动

```java
//开启服务发现，允许被其他服务观察到。
@EnableDiscoveryClient
@SpringBootApplication
public class ZookeeperServerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperServerFeignApplication.class, args);
    }

}
```



### Client

```xml
<!-- 依赖的sdk,远程访问 -->
<dependency>
    <groupId>com.example.demo</groupId>
    <artifactId>zookeeper-server-sdk</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
</dependency>
```



代码：

```java
@Slf4j
@Api(value = "远程连接server", tags = "远程连接server")
@RestController
@RequestMapping("/v1/client")
public class ClientController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String findByName(String name) {
        UserDTO user = userService.findByName(name);
        log.error("{}", user);
        return user.toString();
    }
}
```



启动

```java
@EnableSwagger2Doc
//启动FeignClient,参数是注入这个接口
@EnableFeignClients(basePackageClasses = UserService.class)
@SpringBootApplication
public class ZookeeperServerFeignClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperServerFeignClientApplication.class, args);
    }
}
```



通过**Client**   ClientController#findByName 方法访问远程Server 的UserServiceImpl.

​		FeignClient Get请求中带有Body参数就会被强制转换为Post请求，查看**FeignClientRequestInterceptor**类，如何解决这个问题？

