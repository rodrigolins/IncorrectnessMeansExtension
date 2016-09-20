package incorrectnessMeansExtension.components;

import incorrectnessMeansExtension.types.*;

import incorrectnessMeansExtension.types.*;

import incorrectnessMeansExtension.gen.components.*;

import org.qualitune.smags.adaptation.architecture.types.*;

import org.qualitune.smags.adaptation.architecture.gen.components.*;

import org.qualitune.smags.common.lib.types.*;

import org.qualitune.smags.common.lib.gen.components.*;

import incorrectnessMeansExtension.gen.porttypes.*;

import org.qualitune.smags.adaptation.architecture.gen.porttypes.*;

import org.qualitune.smags.common.lib.gen.porttypes.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.lang.Class;

import java.util.*;
import org.smags.componentmodel.annotations.ParameterA;

public class JApplicationManager extends AbstractApplicationManager {
	
	List<Sensor> sensors;

	public JApplicationManager(String name) {
		super(name);
	}

	public void setup() {
		System.out.println("Starting JApplicationManager");
	}

	public void destroy() {
		System.out.println("Stopping JApplicationManager");
	}

	@Override
	public void handleISensorManagerSensorProviderAdded(
			ISensorManagerSensorProvider connectedItem) {
		//TODO Handle
	}

	@Override
	public void handleISensorManagerSensorProviderRemoved(
			ISensorManagerSensorProvider disconnectedItem) {
		//TODO Handle
	}

	@Override
	public void handleIArduinoSamplingProviderAdded(
			IArduinoSamplingProvider connectedItem) {
		//TODO Handle
	}

	@Override
	public void handleIArduinoSamplingProviderRemoved(
			IArduinoSamplingProvider disconnectedItem) {
		//TODO Handle
	}

	@Override
	public void notifyPropertyChanged(Object sender, String propertyName,
			Object oldValue, Object newValue) {

	}

}
