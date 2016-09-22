package incorrectnessMeansExtension.gen.components;

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
import org.smags.componentmodel.AbstractComponent;
import org.smags.componentmodel.IPort;
import org.smags.componentmodel.annotations.RequirementA;
import org.smags.componentmodel.annotations.EventListenersA;
import org.smags.componentmodel.annotations.ParameterA;
import org.smags.reflection.ReflectionHelper;
import org.smags.componentmodel.parameter.INotifyPropertyChanged;
import org.smags.componentmodel.annotations.Component;

@Component(name = "SensorManagerPropertyRepository", appName = "IncorrectnessMeansExtensionMetaArchitecture", appPackageName = "incorrectnessMeansExtension", componentTypeName = "SensorManagerPropertyRepository", typeArchitectureName = "IncorrectnessMeansExtensionMetaArchitecture", typeArchitectureNamespace = "incorrectnessMeansExtension")
public abstract class AbstractSensorManagerPropertyRepository
		extends
			AbstractComponent
		implements
			INotifyPropertyChanged,
			ISensorManagerSensorProvider {

	private final List<ISensorManagerSensorProvider> iSensorManagerSensorProviderRoles = new ArrayList<ISensorManagerSensorProvider>();

	public AbstractSensorManagerPropertyRepository(String name) {
		super(name);
	}

	@Override
	protected <T> T innerGetPort(Class<T> type) {

		if (type == ISensorManagerSensorProvider.class)
			return iSensorManagerSensorProviderRoles.size() > 0
					? (T) iSensorManagerSensorProviderRoles.get(0)
					: (T) this;

		return null;
	}

	@Override
	public boolean innerBindPort(IPort port) {

		if (port instanceof ISensorManagerSensorProvider) {
			iSensorManagerSensorProviderRoles.add(0,
					(ISensorManagerSensorProvider) port);
			return true;
		}

		return false;
	}

	@Override
	public boolean innerUnbindPort(IPort port) {

		if (port instanceof ISensorManagerSensorProvider
				&& iSensorManagerSensorProviderRoles.contains(port)) {
			iSensorManagerSensorProviderRoles.remove(port);
			return true;
		}

		return false;
	}

	public List<Sensor> getSensors() {

		int countInCallStack = ReflectionHelper.countContainedInCallStack(
				"getSensors", this);

		if (countInCallStack > 1
				|| iSensorManagerSensorProviderRoles.size() == 0)
			return getSensorsImpl();
		else
			return iSensorManagerSensorProviderRoles.get(0).getSensors();

	}

	public abstract List<Sensor> getSensorsImpl();

}
