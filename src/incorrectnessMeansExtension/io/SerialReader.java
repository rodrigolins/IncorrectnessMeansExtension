package incorrectnessMeansExtension.io;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;

public class SerialReader implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(SerialReader.class.getName());

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
            LOGGER.trace("Reading lines...");
            int len = 0;
            int lines = 1;
            while ((data = this.in.read()) > -1) {
                if (data == '\n') {
                    String line = new String(buffer, 0, len);
                    LOGGER.trace("Lines read: " + lines++);
                    LOGGER.trace(line.replace("\n", "").replace("\r", ""));
                    try {
                        inputQueue.put(line.replace("\n", "").replace("\r", ""));
                    } catch (InterruptedException e) {
                        // Happens when queue is full, can use add instead if you dont want to wait for space.
                        e.printStackTrace();
                    }
                    LOGGER.trace("Queue size:" + inputQueue.size());
                    len = 0;
                    buffer = new byte[1024];
                }
                buffer[len++] = (byte) data;
            }
        } catch (IOException e) {
            LOGGER.catching(e);
            System.exit(-1);
        }
    }

}