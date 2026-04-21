package assignment_3;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Integer> {

    int n;

    public FactorialTask(int n) {
        this.n=n;
    }

    @Override
    protected Integer compute() {
        if(n==1 || n==0) return 1;
        FactorialTask subTask =new FactorialTask(n-1);
        subTask.fork();
        return n * subTask.join();
    }
}
