1. [2]synchronized - notifyall-wait
2. [1]join
3. [2]lock + while
4. [2]lock - condition - signal - await
5. [1]semaphore
6. [ababab]blockingqueue: offer - poll

---

1. 三个线程 T1、T2、T3 轮流打印 ABC, 打印 n 次, 如 ABCABCABCABC.......
2. 两个线程交替打印 1-100 的奇偶数
3. N 个线程循环打印 1-100
4. 三个线程循环打印 ACB, 其中 A 打印两次, B 打印三次, C 打印四次
5. 如何用两个线程交叉打印数字和字符呢, 例如 A1B2C3......Z26

---

1. [link](https://mp.weixin.qq.com/s/e_A_qKN_NSLNRwSezfY6vQ)