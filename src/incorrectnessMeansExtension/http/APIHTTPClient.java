package incorrectnessMeansExtension.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class APIHTTPClient {

    private String endpoint;
	private static HttpClient httpClient;
	private static final Logger LOGGER = LogManager.getLogger(APIHTTPClient.class.getName());

    public APIHTTPClient(String endpoint) {
        this.endpoint = endpoint;
    }

    public void connect() {
		if (this.endpoint == null) {
            throw new NullPointerException("Endpoint should not be null");
        }
		if (httpClient == null) {
			httpClient = HttpClientBuilder.create().build();
		}
	}

	public String getAllSensorProperties() throws IOException {

		StringBuilder builder = new StringBuilder();

			HttpGet request = new HttpGet(endpoint);
			request.addHeader("accept", "application/json");
			
			HttpResponse response = httpClient.execute(request);
			
			if(response.getStatusLine().getStatusCode() != 200) {
				LOGGER.debug("Response not 200. Response code: " + response.getStatusLine().getStatusCode());
				return null;
			}
		
			BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
			String line;
			
			while((line = br.readLine()) != null) {
				builder.append(line);
			}
		return builder.toString();
	}
	
	public String querySensorProperties(String queryParameter) throws IOException {

		StringBuilder builder = new StringBuilder();

			HttpGet request = new HttpGet(endpoint + "?q=" + queryParameter);
			request.addHeader("accept", "application/json");
			
			HttpResponse response = httpClient.execute(request);
			
			if(response.getStatusLine().getStatusCode() != 200) {
				System.out.println("Response not 200. Response code: " + response.getStatusLine().getStatusCode());
				return null;
			}
		
			BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
			String line;
			
			while((line = br.readLine()) != null){
				builder.append(line);
			}
		return builder.toString();
	}
}
