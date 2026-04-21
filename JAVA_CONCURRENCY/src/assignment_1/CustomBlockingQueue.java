package assignment_1;

import java.util.ArrayDeque;
import java.util.Queue;

public class CustomBlockingQueue<T> {


    private final Queue<T> deQueue = new ArrayDeque<>();
    private final int size;

    public CustomBlockingQueue(int size) {
        this.size = size;
    }

    public boolean waitingEnqueue(T data) {
        synchronized (this) {
            while (true) {
                boolean added = false;
                if (size() < size) {
                    added = this.deQueue.offer(data);
                    if (added) {
                        this.notify();
                        return true;
                    }
                }
                try {
                    this.notify();
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public T waitingDequeue() {
        synchronized (this) {
            while (true) {
                T data = this.deQueue.poll();
                if (data == null) {
                    this.notify();
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    return data;
                }
            }

        }
    }

    public int size() {
        return this.deQueue.size();
    }


}
