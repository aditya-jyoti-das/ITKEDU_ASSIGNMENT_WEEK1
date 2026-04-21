package assignment_2;

import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ComplexTaskExecutor<List<Integer>, Integer> listIntegerComplexTaskExecutor = new ComplexTaskExecutor<>(
                List.of(
                        List.of(1, 2, 3, 4),
                        List.of(3, 4, 2, 3),
                        List.of(6, 4, 2, 1),
                        List.of(7, 5)
                ),
                Collections::max,
                Collections::max
        );

        Integer finalRes = listIntegerComplexTaskExecutor.executeTasks(listIntegerComplexTaskExecutor.size);
        System.out.println("FINAL_RESULT: "+finalRes);
    }
}
