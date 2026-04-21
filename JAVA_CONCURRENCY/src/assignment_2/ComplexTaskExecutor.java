package assignment_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;

public class ComplexTaskExecutor<R,T> {

    private CyclicBarrier cyclicBarrier;
    private ExecutorService executorService;
    private  List<R> taskList;
    private final Function<R,T> subTaskFunObj;
    private final Function<List<T>,T> finalTaskFunObj;
    public int size=0;

    public ComplexTaskExecutor(List<R> taskList, Function<R,T> subTaskFunObj,Function<List<T>,T> finalTaskFunObj){
        this.subTaskFunObj =subTaskFunObj;
        this.taskList=taskList;
        this.finalTaskFunObj=finalTaskFunObj;
        this.size=taskList.size();
    }


    public T executeTasks(int numberOfTasks){
        this.executorService= Executors.newFixedThreadPool(numberOfTasks);
        this.cyclicBarrier= new CyclicBarrier(numberOfTasks);
        List<Future<T>> resultList= new ArrayList<>();
        List<T> finalResList=new ArrayList<>();
        for (R task : this.taskList) {
            // number of threads available and task should be same or greater, otherwise deadlock
            resultList.add(this.executorService.submit(new ComplexTask<R,T>(task,this.cyclicBarrier,this.subTaskFunObj)));
        }

        for (Future<T> future : resultList){
            try {
                finalResList.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
        return this.finalTaskFunObj.apply(finalResList);
    }
}
