package incorrectnessMeansExtension.io;

import incorrectnessMeansExtension.constants.Settings;
import incorrectnessMeansExtension.http.APIHTTPClient;
import incorrectnessMeansExtension.parsers.SamplingJsonParser;
import incorrectnessMeansExtension.parsers.SensorManagerSensorJsonParser;
import incorrectnessMeansExtension.types.ArduinoValue;
import incorrectnessMeansExtension.types.Sensor;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class DataProcessor implements Runnable {

    private OutputStream out;
    private BlockingQueue<String> inputQueue;
    private BlockingQueue<String> outputQueue;
    
    private List<Sensor> sensors;

    public DataProcessor(OutputStream out, BlockingQueue<String> inputQueue, BlockingQueue<String> outputQueue) {
        this.out = out;
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }

    @Override
    public void run() {
        while (true) {
            if (!inputQueue.isEmpty()) {
                System.out.println("Processing...");
                
                APIHTTPClient client = new APIHTTPClient(Settings.PROPERTY_MANAGER_ENDPOINT);
	        		client.connect();
	        		
	        		try {
	                    System.out.println("Update sensor properties...");
	                    String sensorProperties = client.getAllSensorProperties();
	                    sensors = SensorManagerSensorJsonParser.parse(sensorProperties);
	                    System.out.println("Sensors update...");
	                } catch (Exception e) {
	                    System.out.println("Error to connect sensor manager");
	                    System.out.println(e);
	                }

                System.out.println("queue lenght: " + inputQueue.toArray().length);
                List<String> elements = new ArrayList<String>();
                int length = inputQueue.drainTo(elements);
                
                System.out.println("Drained lines: " + length);
                for(String line : elements){
                    ArduinoValue sample = SamplingJsonParser.parseLine(line);
                    System.out.println("Sample: " + sample);
                }

                if (length > 0) {
                    try {
                        outputQueue.put("error_on");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Nothing to process...");
            }
            // Wait for 1000 milisseconds.
            try {
                System.out.println("Going to sleep...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}