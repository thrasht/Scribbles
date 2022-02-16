import java.util.Random;

public class Producer extends Thread {
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run(){
        Random random = new Random();
        while(true) {
            int data = random.nextInt();
            buffer.produce(data);
        }
    }

}
