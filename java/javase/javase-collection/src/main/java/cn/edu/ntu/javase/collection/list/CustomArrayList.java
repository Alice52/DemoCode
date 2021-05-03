package cn.edu.ntu.javase.collection.list;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2021-02-27 21:43 <br>
 * @project javase <br>
 */
@Slf4j
public class CustomArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    transient Object[] elementData;
    private int size;

    public CustomArrayList() {
        this.elementData = EMPTY_ELEMENTDATA;
    }

    public CustomArrayList(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    /**
     * ensureCapacity:
     *
     * <pre>
     *     1. 如果使用无参构造函数创建数组, 则第一次 add 元素时会分配空间 10
     *     2. 如果使用有参构造函数创建数组, 则空间分配发生在创建数组时
     *
     *     3. 接下来就是考虑数组扩容
     *          - 判断 elementData 是否有空余空间, 有就存放
     *          - 没有则扩容 1.5 倍[Arrays.copyOf]之后存放
     * </pre>
     *
     * @param t
     */
    public void add(T t) {
        if (this.elementData == EMPTY_ELEMENTDATA) {
            this.elementData = new Object[DEFAULT_CAPACITY];
        }

        int minCapacity = size + 1;
        if (minCapacity - elementData.length > 0) {
            int newCapacity = elementData.length + (elementData.length >> 1);
            elementData = Arrays.copyOf(elementData, newCapacity);
        }

        elementData[size++] = t;
    }

    public T get(int index) {
        assert index < size;
        return (T) elementData[index];
    }

    public T remove(int index) {
        assert index < size;
        T oldValue = (T) elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[--size] = null;

        return oldValue;
    }

    public boolean remove(T t) {
        for (int index = 0; index < size; index++) {
            if (t.equals(elementData[index])) {
                System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
                elementData[--size] = null;
                return true;
            }
        }

        return false;
    }
}
