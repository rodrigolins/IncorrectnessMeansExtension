package incorrectnessMeansExtension.components;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import incorrectnessMeansExtension.constants.Settings;
import incorrectnessMeansExtension.gen.components.AbstractArduinoSamplingRepository;
import incorrectnessMeansExtension.io.DataProcessor;
import incorrectnessMeansExtension.io.SerialReader;
import incorrectnessMeansExtension.types.ArduinoValue;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qualitune.smags.repository.types.Application;

public class JArduinoSamplingRepository
		extends
			AbstractArduinoSamplingRepository {
	
	private static final Logger LOGGER = LogManager.getLogger(JArduinoSamplingRepository.class.getName());
	
	private static BlockingQueue<String> inputQueue = new ArrayBlockingQueue<String>(1000);
    private static BlockingQueue<String> outputQueue = new ArrayBlockingQueue<String>(1000);

	public JArduinoSamplingRepository(String name) {
		super(name);
	}

	public void setup() {
		System.out.println("Starting JArduinoSamplingRepository");
		/*try {
            LOGGER.trace("Creating connection...");
            System.setProperty("gnu.io.rxtx.SerialPorts", Settings.PORT_NAME);

            LOGGER.trace("initializing SerialConnector");
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(Settings.PORT_NAME);

            if (portIdentifier.isCurrentlyOwned()) {
                LOGGER.error("Port is currently in use");
            } else {
                CommPort commPort = portIdentifier.open(Application.class.getName(), Settings.TIMEOUT);

                if (commPort instanceof SerialPort) {
                    SerialPort serialPort = (SerialPort) commPort;
                    serialPort.setSerialPortParams(Settings.DATA_RATE, SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                    InputStream in = serialPort.getInputStream();
                    OutputStream out = serialPort.getOutputStream();

                    LOGGER.trace("Spanning SerialReader thread...");
                    Thread serialReader = new Thread(new SerialReader(in, inputQueue));

//                    LOGGER.trace("Spanning SerialWriter thread...");
//                    Thread serialWriter = new Thread(new SerialWriter(out, outputQueue));

                    LOGGER.trace("Spanning DataProcessor thread...");
                    Thread dataProcessor = new Thread(new DataProcessor(out, inputQueue, outputQueue));

                    serialReader.start();
//                    serialWriter.start();
                    dataProcessor.start();

                } else {
                    LOGGER.error("Only serial ports can be handled.");
                }
            }
        } catch (PortInUseException e) {
            LOGGER.catching(e);
        } catch (Exception e) {
            LOGGER.error("It was not possible to connect with arduino.");
            LOGGER.catching(e);
        }*/
	}

	public void destroy() {
		System.out.println("Stopping JArduinoSamplingRepository");
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
