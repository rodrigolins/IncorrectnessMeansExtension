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

@Component(name = "ApplicationManager", appName = "IncorrectnessMeansExtensionMetaArchitecture", appPackageName = "incorrectnessMeansExtension", componentTypeName = "ApplicationManager", typeArchitectureName = "IncorrectnessMeansExtensionMetaArchitecture", typeArchitectureNamespace = "incorrectnessMeansExtension")
public abstract class AbstractApplicationManager extends AbstractComponent
		implements
			INotifyPropertyChanged {

	@RequirementA
	private List<ISensorManagerProvider> iSensorManagerProviders = new ArrayList<ISensorManagerProvider>();

	public List<ISensorManagerProvider> getISensorManagerProviders() {
		return this.iSensorManagerProviders;
	}

	public void addISensorManagerProvider(ISensorManagerProvider item) {
		this.iSensorManagerProviders.add(item);
		handleISensorManagerProviderAdded(item);
	}

	public void removeISensorManagerProvider(ISensorManagerProvider item) {
		this.iSensorManagerProviders.remove(item);
		handleISensorManagerProviderRemoved(item);
	}

	public abstract void handleISensorManagerProviderAdded(
			ISensorManagerProvider item);
	public abstract void handleISensorManagerProviderRemoved(
			ISensorManagerProvider item);

	@RequirementA
	private List<IArduinoSamplingProvider> iArduinoSamplingProviders = new ArrayList<IArduinoSamplingProvider>();

	public List<IArduinoSamplingProvider> getIArduinoSamplingProviders() {
		return this.iArduinoSamplingProviders;
	}

	public void addIArduinoSamplingProvider(IArduinoSamplingProvider item) {
		this.iArduinoSamplingProviders.add(item);
		handleIArduinoSamplingProviderAdded(item);
	}

	public void removeIArduinoSamplingProvider(IArduinoSamplingProvider item) {
		this.iArduinoSamplingProviders.remove(item);
		handleIArduinoSamplingProviderRemoved(item);
	}

	public abstract void handleIArduinoSamplingProviderAdded(
			IArduinoSamplingProvider item);
	public abstract void handleIArduinoSamplingProviderRemoved(
			IArduinoSamplingProvider item);

	public AbstractApplicationManager(String name) {
		super(name);
	}

	@Override
	protected <T> T innerGetPort(Class<T> type) {

		return null;
	}

	@Override
	public boolean innerBindPort(IPort port) {

		return false;
	}

	@Override
	public boolean innerUnbindPort(IPort port) {

		return false;
	}

}
