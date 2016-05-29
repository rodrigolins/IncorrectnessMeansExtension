package incorrectnessMeansExtension.components;

import incorrectnessMeansExtension.gen.components.AbstractApplicationManager;
import incorrectnessMeansExtension.gen.porttypes.IArduinoSamplingProvider;
import incorrectnessMeansExtension.gen.porttypes.ISensorManagerSensorProvider;
import incorrectnessMeansExtension.types.Sensor;

import java.util.List;

public class JApplicationManager extends AbstractApplicationManager {
	
	List<Sensor> sensors = null;

	public JApplicationManager(String name) {
		super(name);
	}

	public void setup() {
		System.out.println("Starting JApplicationManager");
//		System.out.println(sensors);
	}

	public void destroy() {
		System.out.println("Stopping JApplicationManager");
	}

	@Override
	public void handleISensorManagerSensorProviderAdded(ISensorManagerSensorProvider connectedItem) {
		sensors = connectedItem.getSensors();
		System.out.println(sensors);
		//TODO Handle
	}

	@Override
	public void handleISensorManagerSensorProviderRemoved(ISensorManagerSensorProvider disconnectedItem) {
		//TODO Handle
	}

	@Override
	public void handleIArduinoSamplingProviderAdded(IArduinoSamplingProvider connectedItem) {
		//TODO Handle
	}

	@Override
	public void handleIArduinoSamplingProviderRemoved(IArduinoSamplingProvider disconnectedItem) {
		//TODO Handle
	}

	@Override
	public void notifyPropertyChanged(Object sender, String propertyName, Object oldValue, Object newValue) {

	}

}
