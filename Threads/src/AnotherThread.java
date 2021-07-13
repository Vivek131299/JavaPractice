public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_BLUE + "Hello from " + currentThread().getName());
        // We can get the current thread and its name by using currentThread().getName() method which we have set in Main
        // class on line 14.

        try {
            Thread.sleep(3000); // To sleep the Thread for 3 seconds to give time for other threads to execute.
        } catch (InterruptedException e) {
            System.out.println(ThreadColor.ANSI_BLUE + "Another thread woke me up");
            return; // To terminate the program if thread is interrupted. (See comments from line 59 in Main class.)
        }

        System.out.println(ThreadColor.ANSI_BLUE + "3 seconds are passed and I am awake");
        // Above print statement will be executed after 3 seconds as we have given 3 seconds sleep for this Thread.

        // So the thread will be awake after 3 seconds BUT it can also wake up before given time if any other thread
        // interrupts it for doing something else.
        // So the first way to notice that the thread is interrupted is by using try catch block and catching the
        // exception (InterruptedException) as we did above (on line 11).
    }
}
