package incorrectnessMeansExtension.components;

import incorrectnessMeansExtension.gen.components.AbstractArduinoSamplingRepository;
import incorrectnessMeansExtension.types.ArduinoValue;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class JArduinoSamplingRepository extends AbstractArduinoSamplingRepository {
	
	private static BlockingQueue<String> inputQueue = new ArrayBlockingQueue<String>(1000);
    private static BlockingQueue<String> outputQueue = new ArrayBlockingQueue<String>(1000);

	public JArduinoSamplingRepository(String name) {
		super(name);
	}

	public void setup() {
		System.out.println("Starting JArduinoSamplingRepository");
	}

	public void destroy() {
		//TODO:Implement
	}

	public List<ArduinoValue> getArduinoSamplingImpl() {
		//TODO: IMPLEMENT
		return null;
	}

	@Override
	public void notifyPropertyChanged(Object sender, String propertyName,
			Object oldValue, Object newValue) {

	}

}
