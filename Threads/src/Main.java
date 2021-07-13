public class Main {

    // Our program runs on one process, and one process can have one or more threads.
    // By default, program runs on the MAIN thread.
    public static void main(String[] args) {

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.start(); // start() method tells JVM to run the run() method.
        // So for using thread, we have to create an instance of Thread which we created above (on line 7) and then we have to
        // start the thread independent of that which we did on line 8.

        anotherThread.setName("== Another Thread =="); // We can set the name to thread by setName() method.

        /** System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread."); **/

        // Here, we can sometimes not see the above print statements displayed in the order as we have written them because,
        // it depends on each thread how much time it takes to execute, and depending on that our output will vary.
        // So sometime we can see 3rd print statement (on line 16) got executed before 2nd print statement which is called by start() (on line 10).

        // We can give priority to any thread to execute BUT again, we can't assume that threads will execute in same order as we wish.

        // We are not allowed to start the same instance of a thread more than once.
        // For e.g.:
//      anotherThread.start(); // We will see exception (IllegalThreadStateException) here, since anotherThread is already started before this.

        // Creating thread as a Anonymous class.
        // We create a Thread as a Anonymous class when we want to use it only once and immediately.
            new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class thread.");
            }
        }.start();

        // If we do not mention a color for any output of any thread then it will use the color of previously executed line
        // which can be of any thread.

        // Calling thread we created by using Runnable Interface
        /**Thread myRunnableThread = new Thread(new MyRunnable()); // So we create a new instance of Thread and pass the newly created
                                                                // class which implements Runnable Interface which is MyRunnable in this case.
        myRunnableThread.start();**/

        // Instead of above code, we can create anonymous class implementing Runnable and pass an instance of it to the Thread constructor.
        /**Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
//              super.run(); // This super.run() will execute code from run() method of MyRunnable class.
                System.out.println(ThreadColor.ANSI_RED + "Hello from the anonymous class's implementation of run()");
            }
        });
        myRunnableThread.start();**/

    // If we call .run() instead of .start(), then it will run on same Main thread and not on what we have written code.
    // So we should call start() instead of run() directly.


        /////////////////////////// Interrupting Thread ///////////////////////////
        anotherThread.interrupt(); // Interrupting anotherThread.
        // We are also adding the 'return' statement in catch block in the run() method of AnotherThread class to terminate
        // the code if the that thread is interrupted.
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread.");


        /////////////////////////// Joining Threads ///////////////////////////
        // We know that a thread cannot continue to execute until another thread is terminated for e.g.- we might know
        // that there won't be any data to process until the thread that's fetching the data has completed executing.
        // So in this scenario, rather than waking up the thread periodically to see if there is any data, we can
        // JOIN the Thread to the thread that's fetching the data and when we join a thread to a second thread, the
        // first ever thread will wait for th second thread to terminate and then it will continue to execute.
        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
//              super.run(); // This super.run() will execute code from run() method of MyRunnable class.
                System.out.println(ThreadColor.ANSI_RED + "Hello from the anonymous class's implementation of run()");
                try {
                    anotherThread.join(); // Joining this myRunnableThread to anotherThread.
                    // So this thread will stop executing until anotherThread is terminated.
                    // But what if anotherThread never terminates, in this scenario we ca pass the value(time in milliseconds)
                    // in the join() as parameter, and after that time, this thread will start executing without waiting for
                    // anotherThread to terminate.
                    //anotherThread.join(2000);
                    System.out.println(ThreadColor.ANSI_RED + "anotherThread terminated, so I am running again.");
                } catch (InterruptedException e) {
                    System.out.println(ThreadColor.ANSI_RED + "I couldn't wait after all. I was Interrupted.");
                }
            }
        });
        myRunnableThread.start();
    }
}
