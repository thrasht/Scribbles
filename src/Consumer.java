import java.util.concurrent.CompletionService;

public class Consumer extends Thread {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while(true) {
            buffer.consume();
        }
    }
}
