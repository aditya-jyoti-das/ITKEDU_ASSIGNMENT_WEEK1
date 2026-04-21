package assignment_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

        CustomBlockingQueue<Double> doubleCustomBlockingQueue = new CustomBlockingQueue<>(16);
        ConsumerRunnableTask<Double> doubleConsumerRunnableTask = new ConsumerRunnableTask<>(doubleCustomBlockingQueue);
        ProducerRunnableTask<Double> doubleProducerRunnableTask = new ProducerRunnableTask<>(doubleCustomBlockingQueue,
                ()->(Math.random()*100),20);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> producerFuture = executorService.submit(doubleProducerRunnableTask);
        Future<?> consumerFuture = executorService.submit(doubleConsumerRunnableTask);
        

    }

}
