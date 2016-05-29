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

public abstract class AbstractRule {

	private Long id;
	private PropertyType propertyType;
	private Float value;
	private String unit;
	private Long time;
	private RuleBoundary boundary;

	public AbstractRule() {
	}

	public AbstractRule(Long id, PropertyType propertyType, Float value,
			String unit, Long time, RuleBoundary boundary) {
		this.id = id;
		this.propertyType = propertyType;
		this.value = value;
		this.unit = unit;
		this.time = time;
		this.boundary = boundary;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PropertyType getPropertyType() {
		return this.propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public Float getValue() {
		return this.value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getTime() {
		return this.time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public RuleBoundary getBoundary() {
		return this.boundary;
	}

	public void setBoundary(RuleBoundary boundary) {
		this.boundary = boundary;
	}

}
