package incorrectnessMeansExtension.components;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import incorrectnessMeansExtension.constants.Settings;
import incorrectnessMeansExtension.gen.components.AbstractArduinoSamplingRepository;
import incorrectnessMeansExtension.io.DataProcessor;
import incorrectnessMeansExtension.io.SerialReader;
import incorrectnessMeansExtension.io.SerialWriter;
import incorrectnessMeansExtension.types.ArduinoValue;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.qualitune.smags.repository.types.Application;

public class JArduinoSamplingRepository extends AbstractArduinoSamplingRepository {
	
	private static BlockingQueue<String> inputQueue = new ArrayBlockingQueue<String>(1000);
    private static BlockingQueue<String> outputQueue = new ArrayBlockingQueue<String>(1000);

	public JArduinoSamplingRepository(String name) {
		super(name);
	}

	public void setup() {
		System.out.println("Starting JArduinoSamplingRepository");
		try {
	        System.out.println("Creating connection...");
	        System.setProperty("gnu.io.rxtx.SerialPorts", Settings.PORT_NAME);
	
	        System.out.println("initializing SerialConnector");
	        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(Settings.PORT_NAME);
	
	        if (portIdentifier.isCurrentlyOwned()) {
	            System.out.println("Port is currently in use");
	        } else {
	            CommPort commPort = portIdentifier.open(Application.class.getName(), Settings.TIMEOUT);
	
	            if (commPort instanceof SerialPort) {
	                SerialPort serialPort = (SerialPort) commPort;
	                serialPort.setSerialPortParams(Settings.DATA_RATE, SerialPort.DATABITS_8,
	                        SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
	
	                InputStream in = serialPort.getInputStream();
	                OutputStream out = serialPort.getOutputStream();
	
	                System.out.println("Spanning SerialReader thread...");
	                Thread serialReader = new Thread(new SerialReader(in, inputQueue));
	
	                System.out.println("Spanning SerialWriter thread...");
	                Thread serialWriter = new Thread(new SerialWriter(out, outputQueue));
	
	                System.out.println("Spanning DataProcessor thread...");
	                Thread dataProcessor = new Thread(new DataProcessor(out, inputQueue, outputQueue));
	
	                serialReader.start();
	                serialWriter.start();
	                dataProcessor.start();
	
	            } else {
	                System.out.println("Only serial ports can be handled.");
	            }
	        }
	    } catch (PortInUseException e) {
	        System.out.println(e);
	    } catch (Exception e) {
	        System.out.println("It was not possible to connect with arduino.");
	        System.out.println(e);
	    }
	}

	public void destroy() {
		//TODO:Implement
	}

	public List<ArduinoValue> getArduinoSamplingImpl() {
		//TODO: IMPLEMENT
		return null;
	}

	@Override
	public void notifyPropertyChanged(Object sender, String propertyName,
			Object oldValue, Object newValue) {

	}

}
