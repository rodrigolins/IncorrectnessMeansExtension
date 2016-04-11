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

@Component(name = "SensorManagerRepository", appName = "IncorrectnessMeansExtensionMetaArchitecture", appPackageName = "incorrectnessMeansExtension", componentTypeName = "SensorManagerRepository", typeArchitectureName = "IncorrectnessMeansExtensionMetaArchitecture", typeArchitectureNamespace = "incorrectnessMeansExtension")
public abstract class AbstractSensorManagerRepository extends AbstractComponent
		implements
			INotifyPropertyChanged,
			ISensorManagerProvider {

	private final List<ISensorManagerProvider> iSensorManagerProviderRoles = new ArrayList<ISensorManagerProvider>();

	public AbstractSensorManagerRepository(String name) {
		super(name);
	}

	@Override
	protected <T> T innerGetPort(Class<T> type) {

		if (type == ISensorManagerProvider.class)
			return iSensorManagerProviderRoles.size() > 0
					? (T) iSensorManagerProviderRoles.get(0)
					: (T) this;

		return null;
	}

	@Override
	public boolean innerBindPort(IPort port) {

		if (port instanceof ISensorManagerProvider) {
			iSensorManagerProviderRoles.add(0, (ISensorManagerProvider) port);
			return true;
		}

		return false;
	}

	@Override
	public boolean innerUnbindPort(IPort port) {

		if (port instanceof ISensorManagerProvider
				&& iSensorManagerProviderRoles.contains(port)) {
			iSensorManagerProviderRoles.remove(port);
			return true;
		}

		return false;
	}

	public List<Sensor> getSensorsConfiguration() {

		int countInCallStack = ReflectionHelper.countContainedInCallStack(
				"getSensorsConfiguration", this);

		if (countInCallStack > 1 || iSensorManagerProviderRoles.size() == 0)
			return getSensorsConfigurationImpl();
		else
			return iSensorManagerProviderRoles.get(0).getSensorsConfiguration();

	}

	public List<TimedProperty> getTimedProperties() {

		int countInCallStack = ReflectionHelper.countContainedInCallStack(
				"getTimedProperties", this);

		if (countInCallStack > 1 || iSensorManagerProviderRoles.size() == 0)
			return getTimedPropertiesImpl();
		else
			return iSensorManagerProviderRoles.get(0).getTimedProperties();

	}

	public abstract List<Sensor> getSensorsConfigurationImpl();
	public abstract List<TimedProperty> getTimedPropertiesImpl();

}
