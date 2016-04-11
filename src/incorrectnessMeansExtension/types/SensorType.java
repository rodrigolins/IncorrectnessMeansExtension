package incorrectnessMeansExtension.types;

public class SensorType extends AbstractSensorType {

	public SensorType() {
		super();
	}

	public SensorType(Long id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "SensorType [getId()=" + getId() + ", getName()=" + getName()
				+ "]";
	}

	
	
}
