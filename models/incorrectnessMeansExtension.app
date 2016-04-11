import "platform:/plugin/org.qualitune.smags.architecture.dsl/resources/StandardTypes.madl";
import "platform:/plugin/org.qualitune.smags.platform.dsl/resources/Java7Platform.pdl";
import "../../IncorrectnessMeansExtension/models/incorrectnessMeansExtension.madl";

namespace "incorrectnessMeansExtension";

app IncorrectnessMeansExtension {
	platform: Java7;

	ports:

	components:
	component JSensorManagerRepository implements SensorManagerRepository {
		
	}
	
	component JArduinoSamplingRepository implements ArduinoSamplingRepository {
		
	}
	
	component JApplicationManager implements ApplicationManager {
		
	}

	sensors:

	initialization{
		component sensorManager = new JSensorManagerRepository;
		component arduinoManager = new JArduinoSamplingRepository;
		component applicationManager = new JApplicationManager;
		
		connect applicationManager.ISensorManagerProvider to offer sensorManager;
		connect applicationManager.IArduinoSamplingProvider to offer arduinoManager;
	}
}