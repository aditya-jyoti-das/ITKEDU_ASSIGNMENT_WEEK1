package assignment_1;

import java.util.function.Supplier;

public class ProducerRunnableTask<T> implements Runnable{

    private final CustomBlockingQueue<T> customBlockingQueue;

    private final Supplier<T> supplierObj;

    private final int iteration;

    public ProducerRunnableTask(CustomBlockingQueue<T> customBlockingQueue,Supplier<T> supplierObj,int iteration) {
        this.customBlockingQueue = customBlockingQueue;
        this.supplierObj=supplierObj;
        this.iteration=iteration;
    }

    @Override
    public void run() {
        for (int i = 0; i <iteration; i++) {
            T genData = supplierObj.get();
            this.customBlockingQueue.waitingEnqueue(genData);
            System.out.println("DATA-PRODUCED: "+genData);
        }
        System.out.println("PRODUCTION HAS FINISHED IT'S WORK");
    }
}
