## introduce

1. EventBus 并不强制说我们一定要用单例模式
    - 创建销毁成本比较低
    - 所以更多是根据我们的业务场景和上下文自己来选择

2. flow
    - 创建 EventBus/AsyncEventBus{为每个订阅都开启一个线程}
    - 创建 xxHandler + @Subscribe: 参数类型相关联
    - 将 xxHandler 注册到 EventBus

## reference

1. https://mp.weixin.qq.com/s/Rl1hp9szCwtj6NX8bgZUzA