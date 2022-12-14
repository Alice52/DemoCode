package cn.edu.ntu.java.javase.collection.list;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2021-02-27 21:43 <br>
 * @project javase <br>
 */
@Slf4j
public class CustomLinkedList<E> {

    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;
    transient int modCount = 0;

    /**
     * Constructs an empty list.
     */
    public CustomLinkedList() {
    }

    /**
     * 尾插法
     *
     * @param e
     */
    public void add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {

            l.next = newNode;
        }
        size++;
        modCount++;
    }

    /**
     * 折半查找
     *
     * @param index
     * @return
     */
    public Node get(int index) {
        Node<E> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = last;
            for (int i = size - 1; i > 0; i--) {
                x = x.prev;
            }
        }

        return x;
    }

    public E remove(int index) {

        Node delNode = get(index);
        Node prev = delNode.prev;
        Node next = delNode.next;

        // 删除的节点是头结点
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        // 删除的节点是尾结点
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }

        E oldValue = (E) delNode.item;

        delNode = null;
        return oldValue;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
