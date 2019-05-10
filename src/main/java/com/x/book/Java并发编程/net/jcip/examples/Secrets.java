package com.x.book.Java并发编程.net.jcip.examples;

import java.util.*;

/**
 * Secrets
 *
 * Publishing an object
 *
 * @author Brian Goetz and Tim Peierls
 */
class Secrets {
    public static Set<Secret> knownSecrets;

    public void initialize() {
        knownSecrets = new HashSet<Secret>();
    }
}


class Secret {
}
