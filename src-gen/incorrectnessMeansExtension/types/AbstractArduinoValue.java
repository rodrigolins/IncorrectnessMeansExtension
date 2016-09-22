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

public abstract class AbstractArduinoValue {

	private Integer id;
	private String sensorType;
	private String model;
	private String manufacturer;
	private List<ArduinoProperty> properties;

	public AbstractArduinoValue() {
	}

	public AbstractArduinoValue(Integer id, String sensorType, String model,
			String manufacturer, List<ArduinoProperty> properties) {
		this.id = id;
		this.sensorType = sensorType;
		this.model = model;
		this.manufacturer = manufacturer;
		this.properties = properties;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSensorType() {
		return this.sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public List<ArduinoProperty> getProperties() {
		return this.properties;
	}

	public void setProperties(List<ArduinoProperty> properties) {
		this.properties = properties;
	}

}
