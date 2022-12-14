## 天坑

1. processor 外不能有 <build/> 脚本
2. 使用时 processor 一定要在 pom 第一个位置: 优先执行自定义的, 之后在执行 lombok 这些(兜底做的比较好)
