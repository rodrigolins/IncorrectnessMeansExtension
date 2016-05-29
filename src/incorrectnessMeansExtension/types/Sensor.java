package incorrectnessMeansExtension.types;

import java.util.List;
public class Sensor extends AbstractSensor {

	public Sensor() {
		super();
	}

	public Sensor(Long id, SensorType sensorType, String model,
			String manufacturer, List<Property> properties, List<Rule> rules) {
		super(id, sensorType, model, manufacturer, properties, rules);
	}

	@Override
	public String toString() {
		return "Sensor [getId()=" + getId() + ", getSensorType()="
				+ getSensorType() + ", getModel()=" + getModel()
				+ ", getManufacturer()=" + getManufacturer()
				+ ", getProperties()=" + getProperties() + ", getRules()="
				+ getRules() + "]";
	}
	
	

}
