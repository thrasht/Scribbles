import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class MyFirstClass {

    public static final int number = 500;
    public static long counter = 0;
    public static Customer customer = new Customer(0);

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Thread t1 = new Thread(MyFirstClass::printNumbers);
        t1.start();

        Thread t2 = new Thread( () ->
                printNumbers()
                );

        t2.start();

        System.out.println(customer.getValue());

        Buffer buffer = new Buffer();
        Consumer consumer = new Consumer(buffer);
        Producer producer = new Producer(buffer);

        //consumer.start();
        //producer.start();

        try {
            System.out.println("Sleeping for 5 seconds...");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("I woke up");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Deque<Integer> deque = new ArrayDeque<>();

    }

    public static void printNumbers() {
        for(int i = 0; i < number; i++) {
            increaseCustomer();
        }
    }

    public synchronized static void increaseCustomer() {
        int val = customer.getValue();
        val = val + 1;
        customer.setValue(val);
        try {
            MyFirstClass.class.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
