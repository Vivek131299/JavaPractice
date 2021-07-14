
////////////////////////// Producer and Consumer //////////////////////////

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Message message = new Message();

        // Starting/running Writer and Reader Threads.
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();

        ////////////////////////////// DEADLOCK //////////////////////////////
        // After running this code till here, we see that only one line prints in the output and and program waits for unknown
        // time it appears to be hung.
        // We have synchronized read() and write() method in Message class but still there is some problem which is causing
        // problem and our program is waiting continuously / hung after printing one line.

        // So the problem is, once one of the thread starts looping, the other one can't change the value of 'empty' because
        // the thread is blocked. As we know only one Synchronized method can run at a time.
        // So the Thread that is looping is holding the LOCK for the Message object and the other one blocked waiting for the
        // other/first Thread to release the LOCK.
        // This is called as a DEADLOCK.

        ////////////////////////////// Wait, Notify, NotifyAll Methods //////////////////////////////
        // So to solve this DEADLOCK problem, we use Wait, Notify and NotifyAll methods.
        // When a Thread calls the Wait method, it will suspend execution and release whatever locks it's holding until
        // another Thread issues a Notification that something important has happened.
        // So another Thread issues a Notification by calling the Notify and NotifyAll methods.


        // So we are going to call the Wait method inside the Message class's read() and write() methods inside while block(on line 59 and 72).
        // We will also have each Thread called NotifyAll after it's change the value of the empty variable(on line 65 and 79).
    }
}


class Message {

    private String message;
    private boolean empty = true; // empty will be true when there is no message to read.
    // And we want consumer to read each message before we write another one.
    // So in write() method we are checking if the message is empty.
    // In read() after loop, we again set empty to true to show that we have read the message
    // and then we return the message to the consumer.
    // In write() after loop, we set empty to false and then we write the message.

    // Now, we have synchronized these both methods because when a Thread is running one of these methods, we don't want
    // another Thread to be able able to run either(read() and write() both) method.
    // So we don't want the reader Thread to run while the writer Thread is writing a message and vice versa.

    public synchronized String read() { // Synchronized read() method.

        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) { // Synchronized write() method.
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }

    // We always call a wait() within a loop so that when it returns because there is been a notification of some sort we will
    // go back to teh beginning of the loop we check whatever condition we are interested in and then we call wait() again if
    // the condition hasn't changed.

    // So now, as we see in the output, code is running fine.
    // So each Thread now waits and releases its lock on the Message object when the loop condition passes and that gives the
    // other thread the opportunity to run.
    // So it can now process a message and change the value of the empty variable. When it calls the notifyAll() method, the
    // thread that's waiting can now proceed. So the two Threads go back and forth like this until all the messages have been printed.
}


class Writer implements Runnable {
    // This Writer class (Producer in this example), writes 4 messages and to give the reader (Consumer) a chance to run.

    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String messages[] = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the King's horses and all the King's men",
                "Couldn't put Humpty together again"
        };

        Random random = new Random();

        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000)); // Sleep thread for a random time upto 2 seconds after writing a message.
            } catch (InterruptedException e) {

            }
        }
        message.write("Finished");
    }
}


class Reader implements Runnable {

    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    // In run() method, we are going to read the message and just printing it out and then we will give delay like
    // above(run() from Writer class) for a random period of time.
    public void run() {
        Random random = new Random();
        // Below, we are looping through all the messages received until we reach the last message which is "Finished".
        for (String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
    }
}
