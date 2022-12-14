package cn.edu.ntu.java.javase.generic.erasure;

/**
 * @author zack <br>
 * @create 2021-01-11<br>
 * @project javase <br>
 */
public class Erasure<T> {
    T object;

    public Erasure() {}

    public Erasure(T object) {
        this.object = object;
    }

    public void add(T object) {}
}
