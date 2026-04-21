Practical Task – Concurrency – Blocking Queue
Assume you have a thread pool and you want to implement a blocking queue for transferring tasks between threads. Create a BlockingQueue class that provides safe addition and retrieval of elements between producers and consumers in the context of a thread pool.

The BlockingQueue class should contain the methods enqueue() for adding an element to the queue and dequeue() for retrieving an element. If the queue is empty, dequeue() must block the calling thread until a new element appears.

The queue must have a fixed size.

Use the wait() and notify() mechanisms to coordinate between producers and consumers. Implement a size() method that returns the current size of the queue.