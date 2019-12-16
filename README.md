# Dubbo 项目升级 Spring Cloud 方案
## 一、目前服务现状：
#### 1. 同时存在两套技术栈的独立微服务集群 
- 老项目技术栈：**Dubbo + Zookeeper**
- 新项目技术栈：**Spring Cloud** 全家桶

![目前服务现状](https://upload-images.jianshu.io/upload_images/12158715-467facea4e74cbd2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 2. 组件不完全对比

| 组件 | Dubbo | Spring Cloud |
| :- | :- | :- |
|  注册中心 | Zookeeper | Eureka Server |
|  服务发现 | Dubbo | Eureka Client |
|  服务调用 | Dubbo | Ribbon、Feign |
|  熔断器 | 无| Hystrix、Sentinel  |
|  集中式配置中心 | 无| Config|
|  服务网关 | 无| Zuul、Gateway|
| 链路追踪 | 无 | Zipkin、Sleuth |

---

## 二、存在的问题及解决方案

#### 1. 目前 dubbo 服务没有统一的接口管理层，每个服务为其他服务提供的功能不明确

解决：抽取公共服务调用包、注释说明接口功能
- 将 Dubbo 中提供服务的接口类抽取为一个公共的 dubbo-api 调用包，并在接口上通过注释说明提供的功能

优势及缺点：
- 明确每个服务各种提供的能力
-  每个服务不再关心自己需要依赖那些服务，只关心需要那些接口
- 可能引入公共 dubbo-api 包维护问题

#### 2. 由于服务调用方式的不同，Dubbo 服务和 Cloud 服务之间不能进行相互调用

解决：为 Dubbo 服务和 Cloud 服务封装一层适配层，从而提供统一的调用方式
- Dubbo 适配器：每个 Dubbo 项目需单独提供，以适配来自 Spring Cloud 服务的调用
- Feign 适配器：采用集中适配器的方式，统一适配来自 Dubbo 服务的调用

优势及缺点：
- 不会破坏现有服务调用规则
- 适配器的编写工作量较大
- 会占用一定的资源

**Dubbo 服务调用 Spring Cloud 服务**
![Dubbo 服务调用 Spring Cloud 服务](https://upload-images.jianshu.io/upload_images/12158715-f7fde9e8e5505d7d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

**Spring Cloud服务调用 Dubbo  服务**
![Spring Cloud服务调用 Dubbo  服务](https://upload-images.jianshu.io/upload_images/12158715-0d3cada2e2ee31f8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

---

## 三、Dubbo 服务向 Spring Cloud 服务升级过程
Dubbo 服务向 Spring Cloud 服务升级过程，主要有两步：
> 1. 新老项目兼容
> 2. 老项目迁移

#### 1. 新老项目兼容：各端提供相应的适配器
![Dubbo 和 Spring Cloud 服务相互兼容](https://upload-images.jianshu.io/upload_images/12158715-4e3c85f3606d10e7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 2. 老项目迁移：将 Dubbo 项目逐步迁移至 Spring Cloud
![Dubbo 服务向 Spring Cloud 服务升级](https://upload-images.jianshu.io/upload_images/12158715-ca5f90d961a118a4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
