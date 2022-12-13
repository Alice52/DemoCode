## 注册中心

1. zookeeper:docker

   ```yml
   version: '3.0'
   services:
     zookepper:
       image: wurstmeister/zookeeper
       restart: on-failure
       container_name: dev-zookeeper
       #domainname:
       ports:
         - 2181:2181
       volumes:
         - /root/zookeeper/data:/data
         - /root/zookeeper/datalog:/datalog
   ```

## layout

1. dubbo-common: 公共模块
2. dubbo-provider: 服务提供方
3. dubbo-consumer: 服务调用方

## dubbo

![avatar](https://camo.githubusercontent.com/e11a2ff9575abc290657ba3fdbff5d36f1594e7add67a72e0eda32e449508eef/68747470733a2f2f647562626f2e6170616368652e6f72672f696d67732f6172636869746563747572652e706e67)

1. intros
    - 底层推荐默认使用 dubbo 协议: [link](https://blog.csdn.net/hjy930226173/article/details/125770252)
    - dubbo 协议是 TCP 协议上包裹的协议, 采用单一**长连接**和 **NIO 异步**通讯
    - 适合场景: 小数据量**大并发**的服务调用 | 消费者数量远大于提供者的情况

2. flow

    - 服务容器负责启动, 加载, 运行服务提供者
    - 服务提供者在启动时, 向注册中心注册自己提供的服务
    - 服务消费者在启动时, 向注册中心订阅自己所需的服务
    - 注册中心返回服务提供者地址列表给消费者
        1. 如果有变更, 注册中心将基于长连接推送变更数据给消费者
    - 服务消费者, 从提供者地址列表中基于软负载均衡算法, 选一台提供者进行调用
        1. 如果调用失败, 再选另一台调用
    - 服务消费者和提供者, 在内存中累计调用次数和调用时间, 定时每分钟发送一次统计数据到监控中心

3. RPC(Remote Procedure Call): 远程过程调用

    - 是一种`通过网络`从远程计算机程序上请求服务, 而不需要了解底层网络技术的协议
    - 解决部署在两台机器上的相互调用问题: Http 也可但是性能不好

4. feature
    - 负载均衡: 同一个服务部署在不同的机器时该调用那一台机器上的服务
    - 服务调用链路生成: 服务之间互相是如何调用的
    - 服务访问压力以及时长统计: 当前系统的压力主要在哪里, 如何来扩容和优化
    - 服务降级： 某个服务挂掉之后调用备用服务

## reference

1. http://dubbo.apache.org/zh-cn/
2. https://segmentfault.com/a/1190000017178722
