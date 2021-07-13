public class Main {

    public static void main(String[] args) {

        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();

        // From above code output we can see different combinations of two threads each time we run the code.
        // So we can't really guarantee the order that how system will handle the execution of threads.
    }
}


class Countdown {

    //////////////////////// THREAD VARIABLES ////////////////////////
    private int i; // Now, if we declare an instance/private variable i here instead declaring it in for loop, then we
    // get different output. As we can see in the output now, we can notice that thread 2 is skipping the count which
    // thread 1 has executed and vice versa.

    // This is because of the HEAP, the Heap is the application's memory that all threads share.
    // But also, every thread has a thread a Thread STACK, which is the memory that only that thread can access.
    // So for e.g.- thread 1 can't access thread 2's Thread Stack and vice versa,
    // BUT they can both Access the Heap.
    // Now local variables are stored in the Thread Stack that means each Thread has its own copy of a local variable,
    // and in contrast, the memory required to store an object instance value is allocated on the heap.
    // In other words, when multiple threads are working with the same object they in fact same object so they don't
    // have their own copy, and so one thread changer the value of one of the objects instance variables, the other
    // threads will see the new value from that point forward.

    // So in this case, as we created private instance variable i instead of a local in for loop, both Thread 1 and Thread 2
    // was sharing same instance of a variable in the Heap. So they were skipping the count which has been already executed
    // and incremented with the another thread.

    // So the point here to note is that, as for can contain multiple statements, the Thread can terminate between any of
    // these statements. Also, in first iteration, Thread 1 could be running and if it terminates, then Thread 2 will be
    // running during second iteration with the decremented value of variable i.
    // So, there can be many suspension points like: thread can be suspended before the condition or just before printing
    // out the value or just before decrementing the variable i.
    // Thread can be also suspended while print statement is in the execution process. So we can also get the output as:
    // Thread 2 : i = 4, Thread 2 : i = 2, Thread 1 : i = 3,Thread 2 : i = 1. So threads can also be suspended while println
    // statement executes and then another thread gets that value and prints it, decrements it and terminates, but previous
    // thread again continues printing the previous non-decremented value.

    // So this two Threads keep interfering each other, So this situation is also called as Thread Interference.
    // This condition is also called as race Condition.
    //////////////////////////////////////////////////////////////////
    public void doCountdown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        for (/**int**/ i = 10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + " : i = " + i);
        }
    }
}


class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    public void run() {
        threadCountdown.doCountdown();
    }
}
