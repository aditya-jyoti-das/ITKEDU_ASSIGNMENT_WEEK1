package assignment_2;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.function.Function;

public class ComplexTask<R,T> implements Callable<T> {

    private final CyclicBarrier cyclicBarrier;
    private R data;
    private Function<R,T> funObj;

    public ComplexTask(R data, CyclicBarrier cyclicBarrier, Function<R,T> funObj){
        this.cyclicBarrier=cyclicBarrier;
        this.data=data;
        this.funObj=funObj;
    }

    @Override
    public T call() throws Exception {
        T res = funObj.apply(data);
        System.out.println("TASK EXECUTED NOW WAITING AT CYCLIC BARRIER...");
        cyclicBarrier.await();
        return res;
    }
}
