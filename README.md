# kbc-security-login

## 功能

基于spring security的登陆功能

- 登陆成功：

  statusCode: 200

  message: 认证成功

- 登陆失败：

  statusCode: 403

  message: 认证失败

- 登陆超时：

  statusCode: 401

  message: 请重新登陆

- 权限不足：

  statusCode: 403

  message: 权限不足

- 登出成功：

  statusCode: 200

  message: 退出登陆

## 维护者

wangyanan

## 依赖

  ```xml
  <!--安全认证-->
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-security</artifactId>
  </dependency>
  ```

## git拉取

  ```shell
  1. git remote add -f kbc-login git@github.com:k2jf/kbc-security-login.git
  
  2. git subtree add -P src/main/java/com/k2data/kbc/security/login kbc-login master --squash
  
  or
  ./kbc.sh add kbc-security-login master
  ```

## 说明

不拦截："/login" , HttpMethod.OPTIONS

## 初始登录接口

url: http://localhost:9080/login

请求方式：

form表单提交， method: post

| 属性     | 说明   | 类型   | 默认值 |
| -------- | ------ | ------ | ------ |
| username | 用户名 | String | 无     |
| password | 密码   | String | 无     |

