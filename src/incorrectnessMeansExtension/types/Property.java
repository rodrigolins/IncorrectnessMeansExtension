package incorrectnessMeansExtension.types;

public class Property extends AbstractProperty {

	public Property() {
		super();
	}

	public Property(Long id, PropertyType propertyType, Float value,
			String unit, PropertyBoundary boundary) {
		super(id, propertyType, value, unit, boundary);
	}

	@Override
	public String toString() {
		return "Property [getId()=" + getId() + ", getPropertyType()="
				+ getPropertyType() + ", getValue()=" + getValue()
				+ ", getUnit()=" + getUnit() + ", getBoundary()="
				+ getBoundary() + "]";
	}

}
