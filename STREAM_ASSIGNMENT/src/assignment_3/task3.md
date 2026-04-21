Practical Assignment – Stream API – ForkJoinPool: Recursive Factorial Calculation
Consider the task of calculating a factorial using ForkJoinPool. The factorial of a number n is denoted as n! and is calculated as the product of all positive integers from 1 to n.

Implement the FactorialTask class that extends RecursiveTask.

In the constructor of FactorialTask, pass the number n whose factorial needs to be calculated.

In the compute() method, split the task into subtasks and use fork() for asynchronous execution.

Use join() to retrieve the results of subtasks and combine them to produce the final result.

In the main method, create an instance of FactorialTask with the number whose factorial should be calculated and execute it using a ForkJoinPool.

Output the result of the factorial calculation.

As a result, the following structure should be obtained: