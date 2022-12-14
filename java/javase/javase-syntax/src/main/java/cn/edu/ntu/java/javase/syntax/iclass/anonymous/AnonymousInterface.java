package cn.edu.ntu.java.javase.syntax.iclass.anonymous;

import java.util.function.Consumer;

/**
 * type3: anonymous inner class <br>
 * 1. anonymous in known as implements interface as parameter. <br>
 * 2. anonymous inner class have all access to outer class. <br>
 * 3. outer class have a no access to anonymous inner class: <br>
 * - anonymous inner class can define property，and can only used in local, <br>
 * - and cannot used in outer class due to no class name.<br>
 * 4. even cannot create or get anonymous instance.<br>
 * 5. anonymous just define implements and it will not execute besides call interface method.
 * <br>
 * 6. create anonymous for each interface method call.<br>
 */
interface AnonymousInterface {
    void accept(String tag, Consumer consumer);
}