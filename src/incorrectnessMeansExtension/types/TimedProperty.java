package incorrectnessMeansExtension.types;

import java.util.*;

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

import incorrectnessMeansExtension.components.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.lang.Class;
public class TimedProperty extends AbstractTimedProperty {

	public TimedProperty() {
		super();
	}

	public TimedProperty(Long id, PropertyType propertyType, Float value,
			String unit, Long time, TimedPropertyBoundary boundary) {
		super(id, propertyType, value, unit, time, boundary);
	}

}
