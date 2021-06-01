## @Async

1. source code

    - 可以被标注在类或方法上, 用于实现方法的异步执行
    - 当被标注在类上时, 表明类中的所有方法都被指定的异步执行器执行

2. xml config + TaskNamespaceHandler

   ```xml
   <task:annotation-driven executor="myExecutor" exception-handler="exceptionHandler"/>
   <task:executor id="myExecutor" pool-size="5"/>
   <bean id="exceptionHandler" class="com.abc.MyAsynExceptionHandler"/>
   ```
   - TaskNamespaceHandler: 
3.