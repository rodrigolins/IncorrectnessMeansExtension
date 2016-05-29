package incorrectnessMeansExtension.components;

import incorrectnessMeansExtension.constants.Settings;
import incorrectnessMeansExtension.gen.components.AbstractSensorManagerPropertyRepository;
import incorrectnessMeansExtension.http.APIHTTPClient;
import incorrectnessMeansExtension.parsers.SensorManagerSensorJsonParser;
import incorrectnessMeansExtension.types.Sensor;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JSensorManagerPropertyRepository extends AbstractSensorManagerPropertyRepository {
	
	private static final Logger LOGGER = LogManager.getLogger(JSensorManagerPropertyRepository.class.getName());
	
	List<Sensor> sensors = null;

	public JSensorManagerPropertyRepository(String name) {
		super(name);
	}

	public void setup() {
		System.out.println("Starting JSensorManagerPropertyRepository");
		LOGGER.debug("Starting JSensorManagerPropertyRepository");
		System.out.println("Starting HTTP Client");
		APIHTTPClient client = new APIHTTPClient(Settings.PROPERTY_MANAGER_ENDPOINT);
		System.out.println("Connecting to HTTP Client");
		client.connect();
		
		try {
            System.out.println("Trying to get all sensor properties");
            String result = client.getAllSensorProperties();
            sensors = SensorManagerSensorJsonParser.parse(result);
            System.out.println("Sensor List: " + sensors);
        } catch (Exception e) {
            System.out.println("Error to connect sensor manager");
            System.out.println(e);
            LOGGER.error("Error to connect sensor manager");
            LOGGER.catching(e);
        }
	}

	public void destroy() {
		LOGGER.debug("Stopping JSensorManagerPropertyRepository");
	}

	public List<Sensor> getSensorsImpl() {
		if(sensors.isEmpty()){
			return null;
		} else {
			return sensors;
		}
	}

	@Override
	public void notifyPropertyChanged(Object sender, String propertyName,
			Object oldValue, Object newValue) {

	}

}
