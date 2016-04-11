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

@PortTypeA(name = "ISensorManagerProvider", architectureName = "IncorrectnessMeansExtensionMetaArchitecture", architectureNamespace = "incorrectnessMeansExtension")
public interface ISensorManagerProvider {

	public static Class remotePortClass = ISensorManagerProviderRemote.class;
	public static Class proxyComponentClass = ISensorManagerProviderRemoteProxy.class;

	public List<Sensor> getSensorsConfiguration();
	public List<TimedProperty> getTimedProperties();

	public <T> T as(Class<T> c);

	/*--------- REMOTE ---------*/

	public class ISensorManagerProviderRemote
			extends
				AbstractRemotePort<ISensorManagerProvider>
			implements
				ISensorManagerProvider {

		public ISensorManagerProviderRemote(String name) {
			super(name, ISensorManagerProvider.class);
		}

		public List<Sensor> getSensorsConfiguration() {
			List<Sensor> result = base.getSensorsConfiguration();
			return result;
		}
		public List<TimedProperty> getTimedProperties() {
			List<TimedProperty> result = base.getTimedProperties();
			return result;
		}

		@Override
		public <T> T as(Class<T> c) {
			return base.as(c);
		}
	}

	/*--------- REMOTE PROXY ---------*/
	@Component(name = "ISensorManagerProvider", appName = "IncorrectnessMeansExtensionMetaArchitecture", appPackageName = "incorrectnessMeansExtension", componentTypeName = "ISensorManagerProviderRemoteProxy", typeArchitectureName = "IncorrectnessMeansExtensionMetaArchitecture", typeArchitectureNamespace = "incorrectnessMeansExtension")
	public class ISensorManagerProviderRemoteProxy
			extends
				RemoteProxyComponent<ISensorManagerProvider>
			implements
				ISensorManagerProvider {
		public ISensorManagerProviderRemoteProxy(String name) {
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

		public List<Sensor> getSensorsConfiguration() {
			GetSensorsConfigurationRemoteMessage in = new GetSensorsConfigurationRemoteMessage();

			return ((GetSensorsConfigurationRemoteMessage) client.send(in,
					GetSensorsConfigurationRemoteMessage.class))
					.getResponseResult();
		}

		public List<TimedProperty> getTimedProperties() {
			GetTimedPropertiesRemoteMessage in = new GetTimedPropertiesRemoteMessage();

			return ((GetTimedPropertiesRemoteMessage) client.send(in,
					GetTimedPropertiesRemoteMessage.class)).getResponseResult();
		}

	}

	public class GetSensorsConfigurationRemoteMessage
			extends
				RemoteMessageBase<List<Sensor>> {

		public GetSensorsConfigurationRemoteMessage() {
			super("getSensorsConfiguration");
		}

		@Override
		public List<Object> getArguments() {
			List<Object> result = new ArrayList<Object>();

			return result;
		}
	}

	public class GetTimedPropertiesRemoteMessage
			extends
				RemoteMessageBase<List<TimedProperty>> {

		public GetTimedPropertiesRemoteMessage() {
			super("getTimedProperties");
		}

		@Override
		public List<Object> getArguments() {
			List<Object> result = new ArrayList<Object>();

			return result;
		}
	}

}
