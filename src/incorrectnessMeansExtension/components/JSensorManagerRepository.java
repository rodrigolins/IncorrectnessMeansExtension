package incorrectnessMeansExtension.components;

import incorrectnessMeansExtension.constants.Settings;
import incorrectnessMeansExtension.gen.components.AbstractSensorManagerRepository;
import incorrectnessMeansExtension.http.APIHTTPClient;
import incorrectnessMeansExtension.parsers.SensorManagerSensorJsonParser;
import incorrectnessMeansExtension.types.Sensor;
import incorrectnessMeansExtension.types.TimedProperty;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JSensorManagerRepository extends AbstractSensorManagerRepository {
	
	private static final Logger LOGGER = LogManager.getLogger(JSensorManagerRepository.class.getName());
	
	public JSensorManagerRepository(String name) {
		super(name);
	}

	public void setup() {
		LOGGER.debug("Initializing JSensorManagerRepository");
		System.out.println(".Starting HTTP Client");
		APIHTTPClient client = new APIHTTPClient(Settings.PROPERTY_MANAGER_ENDPOINT);
		System.out.println(".Connecting to HTTP Client");
		client.connect();
		
		List<Sensor> sensors = null;
		try {
            System.out.println(".Trying to get all sensor properties");
            String result = client.getAllSensorProperties();
            sensors = SensorManagerSensorJsonParser.parse(result);
            System.out.println(".Sensor List: " + sensors);
        } catch (Exception e) {
            System.out.println(".Error to connect sensor manager");
            System.out.println(e);
            LOGGER.error(".Error to connect sensor manager");
            LOGGER.catching(e);
        }
		
	}

	public void destroy() {
		//TODO:Implement
	}

	public List<Sensor> getSensorsConfigurationImpl() {
		//TODO: IMPLEMENT
		return null;
	}

	public List<TimedProperty> getTimedPropertiesImpl() {
		//TODO: IMPLEMENT
		return null;
	}

	@Override
	public void notifyPropertyChanged(Object sender, String propertyName,
			Object oldValue, Object newValue) {

	}

}
