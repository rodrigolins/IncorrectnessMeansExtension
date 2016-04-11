package incorrectnessMeansExtension;

import org.smags.runtime.RuntimeEnvironment;

public class Starter {
	public static void main(String[] args) {
		RuntimeEnvironment re = RuntimeEnvironment.instance();

		//Initializing the MAPE-K Feedback loop 
		re.initializeAdaptationArchitecture();

		//Uncomment this after code generation
		incorrectnessMeansExtension.gen.initialization.Initializer.initialize(re);
		
	}
}