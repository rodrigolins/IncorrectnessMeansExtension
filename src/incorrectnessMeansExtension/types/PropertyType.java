package incorrectnessMeansExtension.types;

public class PropertyType extends AbstractPropertyType {

	public PropertyType() {
		super();
	}

	public PropertyType(Long id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "PropertyType [getId()=" + getId() + ", getName()=" + getName()
				+ "]";
	}

}
