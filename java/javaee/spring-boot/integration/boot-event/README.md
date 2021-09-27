## legacy code

1. code will be lower

```java

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public void saveOrder() {
        //1.创建订单
        log.info("订单创建成功");
        //2.发送短信
        log.info("恭喜您订单创建成功！----by sms");
        //新需求：微信通知
        // 3.发送微信
        log.info("恭喜您订单创建成功！----by wechat");
    }
}
 ```

2. 违背设计模式的原则
    - 单一职责: 订单保存功能，杂糅了消息通知这些功能
    - 开闭原则: 对拓展开放，对修改关闭

## optimizer

1. 使用观察者模式, 使创建订单和消息通知进行分离低耦合
2. 可以选择消息队列, spring事件机制等

## reference

1. [spring event transaction](https://blog.pragmatists.com/spring-events-and-transactions-be-cautious-bdb64cb49a95)