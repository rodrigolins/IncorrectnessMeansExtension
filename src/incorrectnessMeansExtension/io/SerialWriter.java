package incorrectnessMeansExtension.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class SerialWriter implements Runnable {
	
	private OutputStream out;
	private BlockingQueue<String> outputQueue;
	
	public SerialWriter(OutputStream out, BlockingQueue<String> outputQueue) {
		this.out = out;
		this.outputQueue = outputQueue;
	}

	public void run() {
        try {
            while (true) {
                if (outputQueue.size() > 0) {
                    System.out.println("Preparing to write...");
                    List<String> messages = new ArrayList<String>();
                    outputQueue.drainTo(messages);
                    for (String message : messages) {
                        System.out.println("Writing message: " + message);
                        this.out.write(message.getBytes(), 0, message.length());
                        System.out.println("Finish to write message.");
                    }
                }
                try {
                    System.out.println("Going to sleep...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
