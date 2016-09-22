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

@Component(name = "ArduinoSamplingRepository", appName = "IncorrectnessMeansExtensionMetaArchitecture", appPackageName = "incorrectnessMeansExtension", componentTypeName = "ArduinoSamplingRepository", typeArchitectureName = "IncorrectnessMeansExtensionMetaArchitecture", typeArchitectureNamespace = "incorrectnessMeansExtension")
public abstract class AbstractArduinoSamplingRepository
		extends
			AbstractComponent
		implements
			INotifyPropertyChanged,
			IArduinoSamplingProvider {

	private final List<IArduinoSamplingProvider> iArduinoSamplingProviderRoles = new ArrayList<IArduinoSamplingProvider>();

	public AbstractArduinoSamplingRepository(String name) {
		super(name);
	}

	@Override
	protected <T> T innerGetPort(Class<T> type) {

		if (type == IArduinoSamplingProvider.class)
			return iArduinoSamplingProviderRoles.size() > 0
					? (T) iArduinoSamplingProviderRoles.get(0)
					: (T) this;

		return null;
	}

	@Override
	public boolean innerBindPort(IPort port) {

		if (port instanceof IArduinoSamplingProvider) {
			iArduinoSamplingProviderRoles.add(0,
					(IArduinoSamplingProvider) port);
			return true;
		}

		return false;
	}

	@Override
	public boolean innerUnbindPort(IPort port) {

		if (port instanceof IArduinoSamplingProvider
				&& iArduinoSamplingProviderRoles.contains(port)) {
			iArduinoSamplingProviderRoles.remove(port);
			return true;
		}

		return false;
	}

	public List<ArduinoValue> getArduinoSampling() {

		int countInCallStack = ReflectionHelper.countContainedInCallStack(
				"getArduinoSampling", this);

		if (countInCallStack > 1 || iArduinoSamplingProviderRoles.size() == 0)
			return getArduinoSamplingImpl();
		else
			return iArduinoSamplingProviderRoles.get(0).getArduinoSampling();

	}

	public abstract List<ArduinoValue> getArduinoSamplingImpl();

}
