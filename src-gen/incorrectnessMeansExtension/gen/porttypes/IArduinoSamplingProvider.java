package incorrectnessMeansExtension.gen.porttypes;

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
import org.smags.componentmodel.annotations.PortTypeA;
import org.smags.componentmodel.IPort;
import org.smags.remoting.RemoteProxyComponent;
import org.smags.remoting.AbstractRemotePort;
import org.smags.remoting.RemoteMessageBase;
import org.smags.componentmodel.annotations.Component;

@PortTypeA(name = "IArduinoSamplingProvider", architectureName = "IncorrectnessMeansExtensionMetaArchitecture", architectureNamespace = "incorrectnessMeansExtension")
public interface IArduinoSamplingProvider {

	public static Class remotePortClass = IArduinoSamplingProviderRemote.class;
	public static Class proxyComponentClass = IArduinoSamplingProviderRemoteProxy.class;

	public List<ArduinoValue> getArduinoSamples();

	public <T> T as(Class<T> c);

	/*--------- REMOTE ---------*/

	public class IArduinoSamplingProviderRemote
			extends
				AbstractRemotePort<IArduinoSamplingProvider>
			implements
				IArduinoSamplingProvider {

		public IArduinoSamplingProviderRemote(String name) {
			super(name, IArduinoSamplingProvider.class);
		}

		public List<ArduinoValue> getArduinoSamples() {
			List<ArduinoValue> result = base.getArduinoSamples();
			return result;
		}

		@Override
		public <T> T as(Class<T> c) {
			return base.as(c);
		}
	}

	/*--------- REMOTE PROXY ---------*/
	@Component(name = "IArduinoSamplingProvider", appName = "IncorrectnessMeansExtensionMetaArchitecture", appPackageName = "incorrectnessMeansExtension", componentTypeName = "IArduinoSamplingProviderRemoteProxy", typeArchitectureName = "IncorrectnessMeansExtensionMetaArchitecture", typeArchitectureNamespace = "incorrectnessMeansExtension")
	public class IArduinoSamplingProviderRemoteProxy
			extends
				RemoteProxyComponent<IArduinoSamplingProvider>
			implements
				IArduinoSamplingProvider {
		public IArduinoSamplingProviderRemoteProxy(String name) {
			super(name);
		}

		@Override
		protected boolean innerBindPort(IPort port) {
			return false;
		}

		@Override
		protected boolean innerUnbindPort(IPort port) {
			return false;
		}

		@Override
		protected <T> T innerGetPort(Class<T> type) {
			return null;
		}

		public List<ArduinoValue> getArduinoSamples() {
			GetArduinoSamplesRemoteMessage in = new GetArduinoSamplesRemoteMessage();

			return ((GetArduinoSamplesRemoteMessage) client.send(in,
					GetArduinoSamplesRemoteMessage.class)).getResponseResult();
		}

	}

	public class GetArduinoSamplesRemoteMessage
			extends
				RemoteMessageBase<List<ArduinoValue>> {

		public GetArduinoSamplesRemoteMessage() {
			super("getArduinoSamples");
		}

		@Override
		public List<Object> getArguments() {
			List<Object> result = new ArrayList<Object>();

			return result;
		}
	}

}
