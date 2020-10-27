# aliyun-oss-spring-boot-starter

#### 组件简介

 > 基于 aliyun-sdk-oss 实现的 Spring Boot Starter 实现

裁剪官方实现，仅保留 oss 部分

#### 使用说明

##### 1、Spring Boot 项目添加 Maven 依赖

``` xml
<dependency>
	<groupId>com.github.hiwepy</groupId>
	<artifactId>aliyun-oss-spring-boot-starter</artifactId>
	<version>${project.version}</version>
</dependency>
```


##### 2、在`application.yml`文件中增加如下配置

```yaml
#################################################################################################
### 阿里云Oss配置：
#################################################################################################
aliyun:
  oss:
    authorization-mode: ak-sk
    endpoint: hz.aliyuncs.com
    access-key: test
    secret-key: test    
```

## Jeebiz 技术社区

Jeebiz 技术社区 **微信公共号**、**小程序**，欢迎关注反馈意见和一起交流，关注公众号回复「Jeebiz」拉你入群。

|公共号|小程序|
|---|---|
| ![](https://raw.githubusercontent.com/hiwepy/static/main/images/qrcode_for_gh_1d965ea2dfd1_344.jpg)| ![](https://raw.githubusercontent.com/hiwepy/static/main/images/gh_09d7d00da63e_344.jpg)|