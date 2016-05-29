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

@PortTypeA(name = "ISensorManagerSensorProvider", architectureName = "IncorrectnessMeansExtensionMetaArchitecture", architectureNamespace = "incorrectnessMeansExtension")
public interface ISensorManagerSensorProvider {

	public static Class remotePortClass = ISensorManagerSensorProviderRemote.class;
	public static Class proxyComponentClass = ISensorManagerSensorProviderRemoteProxy.class;

	public List<Sensor> getSensors();

	public <T> T as(Class<T> c);

	/*--------- REMOTE ---------*/

	public class ISensorManagerSensorProviderRemote
			extends
				AbstractRemotePort<ISensorManagerSensorProvider>
			implements
				ISensorManagerSensorProvider {

		public ISensorManagerSensorProviderRemote(String name) {
			super(name, ISensorManagerSensorProvider.class);
		}

		public List<Sensor> getSensors() {
			List<Sensor> result = base.getSensors();
			return result;
		}

		@Override
		public <T> T as(Class<T> c) {
			return base.as(c);
		}
	}

	/*--------- REMOTE PROXY ---------*/
	@Component(name = "ISensorManagerSensorProvider", appName = "IncorrectnessMeansExtensionMetaArchitecture", appPackageName = "incorrectnessMeansExtension", componentTypeName = "ISensorManagerSensorProviderRemoteProxy", typeArchitectureName = "IncorrectnessMeansExtensionMetaArchitecture", typeArchitectureNamespace = "incorrectnessMeansExtension")
	public class ISensorManagerSensorProviderRemoteProxy
			extends
				RemoteProxyComponent<ISensorManagerSensorProvider>
			implements
				ISensorManagerSensorProvider {
		public ISensorManagerSensorProviderRemoteProxy(String name) {
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

		public List<Sensor> getSensors() {
			GetSensorsRemoteMessage in = new GetSensorsRemoteMessage();

			return ((GetSensorsRemoteMessage) client.send(in,
					GetSensorsRemoteMessage.class)).getResponseResult();
		}

	}

	public class GetSensorsRemoteMessage
			extends
				RemoteMessageBase<List<Sensor>> {

		public GetSensorsRemoteMessage() {
			super("getSensors");
		}

		@Override
		public List<Object> getArguments() {
			List<Object> result = new ArrayList<Object>();

			return result;
		}
	}

}
