package cn.edu.ntu.javase.io;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author zack <br>
 * @create 2020-04-04 22:56 <br>
 */
@Slf4j
public class BufferTest {

  /**
   * 1.非直接缓冲区: allocate() 在JVM的内存中 <br>
   * 2.直接缓冲区: allocateDirect() 系统的物理内存中<br>
   * 2.1 缺点: 资源占用量大，而且数据进去之后，所有的操作权都归了OS<br>
   * 2.2 直接缓冲区是去掉了 copy 的步骤<br>
   */
  @Test
  public void testAllocateDirect() {
    // 1.在系统的物理内存上直接分配空间
    ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
    System.out.println(buffer);
    System.out.println(buffer.isDirect());
  }

  @Test
  /**
   * 功能: <br>
   * 测试 Buffer 的 mark()方法: mark()之后，可以通过 reset()恢复到 mark 时的 position
   */
  public void testMark() {
    String str = "abcdefg";
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    buffer.put(str.getBytes());
    // 从写变为了读
    buffer.flip();
    byte[] b = new byte[buffer.limit()];
    // 将其读入到b中
    buffer.get(b, 0, 2);
    Assert.isTrue(2 == buffer.position());
    buffer.mark();
    // 继续想b中存放，之前的不会覆盖
    buffer.get(b, 2, 2);
    Assert.isTrue(4 == buffer.position());
    buffer.reset();
    Assert.isTrue(2 == buffer.position());
    log.info(new String(b, 0, b.length));
  }

  /**
   * 功能: <br>
   * 1.测试Buffer中的capacity()/limit()/position() <br>
   * 2.缓冲区的操作: <br>
   * 1. put():存数据到缓冲区 <br>
   * 2. get():获取缓冲区的数据 <br>
   * 3. flip():模式的转换:从写变为了读 <br>
   * 4. rewind():表示可以重复读取数据 <br>
   * 5. allocate():分配Buffer大小 <br>
   * 6. clear():清空缓冲区，回到刚分配是的状态，但是缓冲区的数据依旧存在，但是处于遗忘状态 <br>
   * 7. hasRemaining():判断缓冲区中是否还有剩余的数据 <br>
   * 8. remaining():有的话，还有几个 <br>
   */
  @Test
  public void testByteBuffer() {
    // 1. 创建一个指定大小的缓冲区:
    System.out.println("----------allocate--------------");
    ByteBuffer buffer = ByteBuffer.allocate(1024);

    // 2. 相关的属性
    Assert.isTrue(1024 == buffer.capacity());
    Assert.isTrue(1024 == buffer.limit());
    Assert.isTrue(0 == buffer.position());

    // 3. 利用put()方法存数据
    System.out.println("----------put--------------");
    String str = "123456";
    buffer.put(str.getBytes());
    Assert.isTrue(1024 == buffer.capacity());
    Assert.isTrue(1024 == buffer.limit());
    Assert.isTrue(6 == buffer.position());

    // 4.从写的模式转换到读取的模式
    System.out.println("----------flip--------------");
    buffer.flip();
    Assert.isTrue(1024 == buffer.capacity());
    Assert.isTrue(6 == buffer.limit());
    Assert.isTrue(0 == buffer.position());

    // 5. 利用get()方法取数据:
    System.out.println("----------get--------------");
    byte[] b = new byte[buffer.limit() - 1];
    ByteBuffer buffer2 = buffer.get(b);
    Assert.isTrue(1024 == buffer.capacity());
    Assert.isTrue(6 == buffer.limit());
    Assert.isTrue(5 == buffer.position());
    System.out.println(buffer2);
    // 输出读取到的内容:
    Assert.isTrue("12345".equals(new String(b, 0, b.length)));

    // 6.hasRemaining()
    System.out.println("----------hasRemaining--------------");
    if (buffer.hasRemaining()) {
      System.out.println(buffer.remaining());
    }

    // 7.rewind():
    System.out.println("----------rewind--------------");
    Assert.isTrue(1024 == buffer.capacity());
    Assert.isTrue(6 == buffer.limit());
    Assert.isTrue(5 == buffer.position());

    // 8.clear()
    System.out.println("----------clear--------------");
    buffer.clear();
    Assert.isTrue(1024 == buffer.capacity());
    Assert.isTrue(1024 == buffer.limit());
    Assert.isTrue(0 == buffer.position());
    log.info(String.valueOf(buffer.get(0)));
  }
}
