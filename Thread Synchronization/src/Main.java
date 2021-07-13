public class Main {

    public static void main(String[] args) {

        /**
        Countdown countdown1 = new Countdown();
        Countdown countdown2 = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown1);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown2);
        t2.setName("Thread 2");

         t1.start();
         t2.start();
         **/
        //////////////////////////// THREAD SYNCHRONIZATION ////////////////////////////
        // Above, as a solution to Thread Interference, we are creating 2 separate Countdown variables for 2 Threads, now each
        // Thread will be executed for each value of variable i, i.e. from 10 to 1.
        // So there is no Thread Interference here.

        // But this solution may not work in real World applications, So for example, if the objects represented here were
        // bank accounts or employee records, we can't provide each thread with a different object, it wouldn't make sense.
        // So every time a bank manager or employee file is accessed and changed, we have to us ethe same object to maintain
        // integrity of the data. SO in the case of bank account, there could be several threads waiting to change the bank
        // balance at the same time like there could be making an deposit, payment, online banking, etc..
        // So in order to ensure the integrity if the bank balance value we need to allow multiple threads to change it,
        // But we also need to prevent a Race Condition which is Thread Interference.

        // So, the process of controlling when Threads execute code and therefore when they can access the Heap
        // is called SYNCHRONIZATION.

        // We can Synchronize methods and statements. When a method is Synchronized, only one thread can execute that at
        // a time, So when the thread is executing the method, all other threads that want to call the method or any other
        // Synchronized method in that class will SUSPEND until the thread running the method exits it then another thread
        // can run a Synchronized method then another etc..
        // For e.g. if a class has 3 Synchronized methods then only one of these methods can ever run at a time and only
        // on one Thread.
        // So, Thread Interference will not occur inside these Synchronized methods but still it can occur outside these methods
        // if we are calling Threads outside.

        // Below, we will change above code for creating 2 separate Countdown variables to only one variable again to
        // see Interference as we want to implement Synchronization to solve it.
        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();

        // Now, we will make doCountdown() method of Countdown class Synchronized.


    }
}


class Countdown {

    private int i;

    /**public synchronized void doCountdown() { // Making this method Synchronized by adding 'synchronized' keyword.
        // So, as we have made this method Synchronized now, in the output we can see that Thread 1 is executing first
        // with all values of variable i and then Thread 2 is executing with all values of variable i.

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

        for (i = 10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + " : i = " + i);
        }
    }**/


    // Another way to avoid Race Condition is to Synchronize a block of statements rather than an entire method.
    // So every Java object has what's called its our call and its intrinsic lock and will see this reference to as
    // a monitor.
    // Threads can acquire lock before they execute the statement block. now only one thread can hold the lock at a
    // time so other threads that want the lock will be suspended until the running thread releases it.

    // So, in doCountdown() method, we only want to Synchronize the for loop.
    // We need an object to synchronize, but we can't use counter variable 'i' because its a primitive type and not
    // an object. And Primitive types DON'T have Intrinsic Locks.
    // We can't also use 'color' variable because that is a local variable which is stored separately for each Thread
    // in its Thread Stack.
    // The only local variable exception here is String, this is because String objects are reused within the JVM.
    // When using a local object variable the, object reference is stored in the Thread Stack but the object values
    // are stored on the Heap.
    // Now since the threads will each create their own copy of the object, so object references will be different and
    // there will not be any Interference even though the object values are in the Heap.
    // Essentially, the Thread Stack will only ever contain Primitive values and object references and function references(not related to race conditions).
    // We can also Synchronize Static methods and Static objects and when we do that the lock that used is owned by the class object
    // associated with the objects class.
    
    // So, lets use Countdown class object itself for synchronized block by using 'this' keyword which will refer to current
    // Countdown class object.

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

        synchronized(this) { // Creating Synchronized block with Countdown object (this).
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + " : i = " + i);
            }
        }
        // Now we can see that the Thread 1 is executing first with all values of variable i and then Thread 2 is
        // executing with all values of variable i. So the interference problem is solved here.
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
