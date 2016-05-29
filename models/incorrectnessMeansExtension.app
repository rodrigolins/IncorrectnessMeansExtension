import "platform:/plugin/org.qualitune.smags.architecture.dsl/resources/StandardTypes.madl";
import "platform:/plugin/org.qualitune.smags.platform.dsl/resources/Java7Platform.pdl";
import "../../IncorrectnessMeansExtension/models/incorrectnessMeansExtension.madl";

namespace "incorrectnessMeansExtension";

app IncorrectnessMeansExtension {
	platform: Java7;

	ports:

	components:
	component JSensorManagerPropertyRepository implements SensorManagerPropertyRepository {
		
	}
	
	component JArduinoSamplingRepository implements ArduinoSamplingRepository {
		
	}
	
	component JApplicationManager implements ApplicationManager {
		
	}

	sensors:
	initialization{
		component sensorManager = new JSensorManagerPropertyRepository;
		component arduinoManager = new JArduinoSamplingRepository;
		
		component applicationManager = new JApplicationManager;
		connect applicationManager.ISensorManagerSensorProvider to offer sensorManager;
		connect applicationManager.IArduinoSamplingProvider to offer arduinoManager;
	}
}