package incorrectnessMeansExtension.gen.initialization;

import incorrectnessMeansExtension.types.*;

import incorrectnessMeansExtension.types.*;

import incorrectnessMeansExtension.gen.components.*;

import org.qualitune.smags.adaptation.architecture.types.*;

import org.qualitune.smags.adaptation.architecture.gen.components.*;

import org.qualitune.smags.common.lib.types.*;

import org.qualitune.smags.common.lib.gen.components.*;

import incorrectnessMeansExtension.components.*;

import incorrectnessMeansExtension.gen.porttypes.*;

import org.qualitune.smags.adaptation.architecture.gen.porttypes.*;

import org.qualitune.smags.common.lib.gen.porttypes.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.lang.Class;
import org.smags.runtime.RuntimeEnvironment;
import org.smags.runtime.reconfigurtion.operations.*;
import org.smags.runtime.reconfigurtion.ReconfigurationScript;
import org.smags.runtime.reconfigurtion.ReconfigurtionOperation;
import java.util.ArrayList;
import java.util.List;

public class Initializer {

	public static final String SensorManager = "sensorManager";

	public static final String ArduinoManager = "arduinoManager";

	public static final String ApplicationManager = "applicationManager";

	public static void initialize(RuntimeEnvironment re) {
		List<ReconfigurtionOperation> ops = new ArrayList<ReconfigurtionOperation>();

		ops.add(new CreateComponentInstanceOperation("sensorManager",
				JSensorManagerPropertyRepository.class));

		ops.add(new CreateComponentInstanceOperation("arduinoManager",
				JArduinoSamplingRepository.class));

		ops.add(new CreateComponentInstanceOperation("applicationManager",
				JApplicationManager.class));

		ops.add(new ConnectOperation("sensorManager", "applicationManager",
				"ISensorManagerSensorProvider"));

		ops.add(new ConnectOperation("arduinoManager", "applicationManager",
				"IArduinoSamplingProvider"));

		ops.add(new SetupComponentOperation("sensorManager"));

		ops.add(new SetupComponentOperation("arduinoManager"));

		ops.add(new SetupComponentOperation("applicationManager"));

		re.getReconfigurationEngine().executeScript(
				new ReconfigurationScript(ops));
	}

	public static JSensorManagerPropertyRepository getSensorManager() {
		return RuntimeEnvironment.instance().getRuntimeModel()
				.getComponentByName(Initializer.SensorManager)
				.as(JSensorManagerPropertyRepository.class);
	}

	public static JArduinoSamplingRepository getArduinoManager() {
		return RuntimeEnvironment.instance().getRuntimeModel()
				.getComponentByName(Initializer.ArduinoManager)
				.as(JArduinoSamplingRepository.class);
	}

	public static JApplicationManager getApplicationManager() {
		return RuntimeEnvironment.instance().getRuntimeModel()
				.getComponentByName(Initializer.ApplicationManager)
				.as(JApplicationManager.class);
	}

}
