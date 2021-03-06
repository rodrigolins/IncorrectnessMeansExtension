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

public abstract class AbstractSensor {

	private Long id;
	private SensorType sensorType;
	private String model;
	private String manufacturer;
	private List<Property> properties;
	private List<Rule> rules;

	public AbstractSensor() {
	}

	public AbstractSensor(Long id, SensorType sensorType, String model,
			String manufacturer, List<Property> properties, List<Rule> rules) {
		this.id = id;
		this.sensorType = sensorType;
		this.model = model;
		this.manufacturer = manufacturer;
		this.properties = properties;
		this.rules = rules;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SensorType getSensorType() {
		return this.sensorType;
	}

	public void setSensorType(SensorType sensorType) {
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

	public List<Property> getProperties() {
		return this.properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public List<Rule> getRules() {
		return this.rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

}
