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

public class JSensorManagerDisplay extends AbstractSensorManagerDisplay {

	public JSensorManagerDisplay(String name) {
		super(name);
	}

	public void setup() {
		//TODO:Implement
	}

	public void destroy() {
		//TODO:Implement
	}

	@Override
	public void handleISensorManagerProviderAdded(
			ISensorManagerProvider connectedItem) {
		//TODO Handle
	}

	@Override
	public void handleISensorManagerProviderRemoved(
			ISensorManagerProvider disconnectedItem) {
		//TODO Handle
	}

	@Override
	public void notifyPropertyChanged(Object sender, String propertyName,
			Object oldValue, Object newValue) {

	}

}
