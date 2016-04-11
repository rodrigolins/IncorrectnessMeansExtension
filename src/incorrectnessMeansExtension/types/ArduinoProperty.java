package incorrectnessMeansExtension.types;

public class ArduinoProperty extends AbstractArduinoProperty {

	public ArduinoProperty() {
		super();
	}

	public ArduinoProperty(String name, Double value, String unit) {
		super(name, value, unit);
	}

	@Override
	public String toString() {
		return "ArduinoProperty [getName()=" + getName() + ", getValue()="
				+ getValue() + ", getUnit()=" + getUnit() + "]";
	}

	
}
