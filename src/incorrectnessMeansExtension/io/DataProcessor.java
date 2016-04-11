package incorrectnessMeansExtension.io;

import incorrectnessMeansExtension.parsers.SamplingJsonParser;
import incorrectnessMeansExtension.types.ArduinoValue;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataProcessor implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(DataProcessor.class.getName());

    private OutputStream out;
    private BlockingQueue<String> inputQueue;
    private BlockingQueue<String> outputQueue;


    public DataProcessor(OutputStream out, BlockingQueue<String> inputQueue, BlockingQueue<String> outputQueue) {
        this.out = out;
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }

    @Override
    public void run() {
        while (true) {
            if (!inputQueue.isEmpty()) {
                LOGGER.trace("Processing...");
                System.out.println("Processing...");

                LOGGER.trace("queue lenght: " + inputQueue.toArray().length);
                System.out.println("queue lenght: " + inputQueue.toArray().length);
                List<String> elements = new ArrayList<String>();
                int length = inputQueue.drainTo(elements);
                LOGGER.trace("Drained lines: " + length);
                System.out.println(length);

                for(String line : elements){
                    ArduinoValue sample = SamplingJsonParser.parseLine(line);
                    LOGGER.trace(sample);
                    System.out.println(sample);

                }

                if (length > 0) {
                    try {
                        outputQueue.put("Caralhooooo!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                LOGGER.trace("Nothing to process...");
                System.out.println("Nothing to process...");
            }
            // Wait for 1000 milisseconds.
            try {
                LOGGER.trace("Going to sleep...");
                System.out.println("Going to sleep...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}