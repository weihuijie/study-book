package com.x.book.Java并发编程.net.jcip.examples;

/**
 * LeftRightDeadlock
 *
 * Simple lock-ordering deadlock
 *
 * @author Brian Goetz and Tim Peierls
 */
public class LeftRightDeadlock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                doSomething();
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                doSomethingElse();
            }
        }
    }

    void doSomething() {
    }

    void doSomethingElse() {
    }
}
