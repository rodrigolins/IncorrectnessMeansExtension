package incorrectnessMeansExtension.io;


import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;

public class SerialReader implements Runnable {

    private InputStream in;
    private BlockingQueue<String> inputQueue;

    public SerialReader(InputStream in, BlockingQueue<String> inputQueue) {
        this.in = in;
        this.inputQueue = inputQueue;
    }

    public void run() {
        byte[] buffer = new byte[1024];
        int data = -1;

        try {
            System.out.println("Reading lines...");
            int len = 0;
            int lines = 1;
            while ((data = this.in.read()) > -1) {
                if (data == '\n') {
                    String line = new String(buffer, 0, len);
                    System.out.println("Lines read: " + lines++);
                    System.out.println(line.replace("\n", "").replace("\r", ""));
//                    System.out.println("Actual line: " + line);
                    try {
                        inputQueue.put(line.replace("\n", "").replace("\r", ""));
                    } catch (InterruptedException e) {
                        // Happens when queue is full, can use add instead if you dont want to wait for space.
                        e.printStackTrace();
                    }
                    System.out.println("Queue size:" + inputQueue.size());
                    len = 0;
                    buffer = new byte[1024];
                }
                buffer[len++] = (byte) data;
            }
        } catch (IOException e) {
            System.out.println(e);
            System.exit(-1);
        }
    }

}