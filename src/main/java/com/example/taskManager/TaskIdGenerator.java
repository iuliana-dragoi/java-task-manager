package com.example.taskManager;

import java.util.concurrent.atomic.AtomicLong;

public class TaskIdGenerator {

    public static final AtomicLong SEQ = new AtomicLong(1);

    public static long nextId() {
        return SEQ.getAndIncrement();
    }

    public static void reset() {
        SEQ.set(1);
    }
}
