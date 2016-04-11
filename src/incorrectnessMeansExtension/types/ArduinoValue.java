package incorrectnessMeansExtension.types;

import java.util.List;
public class ArduinoValue extends AbstractArduinoValue {

	public ArduinoValue() {
		super();
	}

	public ArduinoValue(Integer id, String sensorType, String model,
			String manufacturer, List<ArduinoProperty> properties) {
		super(id, sensorType, model, manufacturer, properties);
	}

	@Override
	public String toString() {
		return "ArduinoValue [getId()=" + getId() + ", getSensorType()="
				+ getSensorType() + ", getModel()=" + getModel()
				+ ", getManufacturer()=" + getManufacturer()
				+ ", getProperties()=" + getProperties() + "]";
	}
	
	

}
