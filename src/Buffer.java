public class Buffer {
    private int data;
    private boolean empty;

    public Buffer() {
        this.empty = true;
    }

    public synchronized void consume() {

        while (this.empty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.empty = true;
        System.out.println("Consuming data: " + data);
        this.notify();
    }

    public synchronized void produce(int number) {
        while (!this.empty) {
            try {
                this.wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.data = number;
        this.empty = false;
        System.out.println("Producing data: " + data);
        notify();
    }
}
