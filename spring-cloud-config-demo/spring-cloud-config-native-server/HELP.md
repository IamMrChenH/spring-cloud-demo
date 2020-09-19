[toc]

# Spring Cloud Config的使用(配置中心)



## 依赖

Spring Boot : 2.2.6.RELEASE

* spring-cloud-config-server

## 使用本地配置

```yaml
spring:
  application:
    name: spring-cloud-config-demo
  profiles:
    active: native #表示读取本地文件
  cloud:
    config:
      server:
        native:
          #application 默认会自动转换应用的名称
          search-locations: classpath:config/{application}/ 
          #不启用git
          add-label-locations: false 
        git:
          #寻找路径
          search-paths: {application}
```



### 配置存放

* resources/config
  * user
    * application-dev.yml
    * application-test.yml
    * application-prod.yml
  * account
    * application-dev.yml
    * application-test.yml
    * application-prod.yml

### 配置获取

**application**: 应用名称
**profile**： 环境 dev、test、prod

例：localhost:port/{application}/{profile}

* 127.0.0.1:8080/user/dev



## 使用git远程配置仓库

```yaml
spring:
  application:
    name: spring-cloud-config-demo
  cloud:
    config:
      server:
        git:
          # 根目录/应用名称(文件夹名称)
          search-paths: config/{application}
          # 仓库地址
          uri: https://github.com/IamMrChenH/spring-cloud-config-demo/
```



根目录/config

* user
  * application-dev.yml
  * application-test.yml
  * application-prod.yml
* account
  * application-dev.yml
  * application-test.yml
  * application-prod.yml

### 配置获取

**application**: 应用名称
**profile**： 环境 dev、test、prod

例：localhost:port/{application}/{profile}

* 127.0.0.1:8080/user/dev

  

## 启动

```java
//启动配置中心
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigDemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigDemoServerApplication.class, args);
    }

}
```











