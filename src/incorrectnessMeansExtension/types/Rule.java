package incorrectnessMeansExtension.types;

public class Rule extends AbstractRule {

	public Rule() {
		super();
	}

	public Rule(Long id, PropertyType propertyType, Float value, String unit,
			Long time, RuleBoundary boundary) {
		super(id, propertyType, value, unit, time, boundary);
	}

	@Override
	public String toString() {
		return "Rule [getId()=" + getId() + ", getPropertyType()="
				+ getPropertyType() + ", getValue()=" + getValue()
				+ ", getUnit()=" + getUnit() + ", getTime()=" + getTime()
				+ ", getBoundary()=" + getBoundary() + "]";
	}

}
