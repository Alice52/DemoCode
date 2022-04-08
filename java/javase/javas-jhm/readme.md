## jmh

1. @WarmUp(iterations=1, time=3)
    - 预热, 由于存在本地优化, 所以预热很重要: 多次执行 JIT 会优化的
2. @Measurement(iterations=1, time=3)
    - 总共执行多少次测试
3. @Timeout
4. @Fork
    - 线程数
5. @BenchmarkMode(Mode.Throughput)
    - 基准测试的模式
    - Throughput: 每秒吞吐量
6. @Benchmark
    - 测试的代码段 