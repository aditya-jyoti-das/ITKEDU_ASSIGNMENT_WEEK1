package assignment_1;


public class ConsumerRunnableTask<T> implements Runnable {

    private final CustomBlockingQueue<T> customBlockingQueue;

    public ConsumerRunnableTask(CustomBlockingQueue<T> customBlockingQueue) {
        this.customBlockingQueue = customBlockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            T dequeue = this.customBlockingQueue.waitingDequeue();
            System.out.println("CONSUMER-PROCESSED-ELEMENTS: " + dequeue);
        }
    }
}
