
// There is another method to create a thread which is by using Runnable instead of creating of subclassing a Thread class
// like we did in Main class by creating anotherThread.
// We have to implement Runnable Interface and then implement run() method to create a new thread and write code in that
// run() method which we want to execute on new thread.
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_RED + "Hello from MyRunnable's implementation of run()");
    }
}
