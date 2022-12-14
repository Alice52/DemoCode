package cn.edu.ntu.java.javase.classloader;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @author zack <br>
 * @create 2021-03-02 11:39 <br>
 * @project javase <br>
 */
@Slf4j
public class SpiLoaderWithContextClassLoader {
    static SpiInterface spi = null;

    public static void main(String[] args) {
        spiV1();
    }

    /**
     * 每次使用的时候都需要加载, 可以使用V2 对上下文进行切换不需要每次都加载
     */
    public static void spiV1() {
        // load(class, loader) 进行制定类加载器进行加载
        ServiceLoader<SpiInterface> spis =
                ServiceLoader.load(SpiInterface.class, new SalaryJarClassLoader(""));
        Iterator<SpiInterface> iterator = spis.iterator();

        if (iterator.hasNext()) {
            spi = iterator.next();
        }

        Optional.ofNullable(spi).ifPresent(System.out::println);
    }

    /**
     * 调整类加载器的上下文环境
     */
    public static void spiV2() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();

        try {
            Thread.currentThread().setContextClassLoader(new SalaryJarClassLoader(""));
            ServiceLoader<SpiInterface> spis = ServiceLoader.load(SpiInterface.class);
            Iterator<SpiInterface> iterator = spis.iterator();

            if (iterator.hasNext()) {
                spi = iterator.next();
            }

        } finally {
            Thread.currentThread().setContextClassLoader(cl);
        }

        Optional.ofNullable(spi).ifPresent(System.out::println);
    }
}
