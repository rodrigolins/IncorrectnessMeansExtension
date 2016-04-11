package incorrectnessMeansExtension.parsers;

import incorrectnessMeansExtension.types.Sensor;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class SensorManagerSensorJsonParser {

	private static Gson gson = new GsonBuilder().create();
	private static JsonParser parser = new JsonParser();
	
	/*
	 * Return only Sample objects
	 * 
	 * If the line is not well formed, return null
	 */
	public static List<Sensor> parse(String line) {
        // Check if the read line started with formed json string or ignore it.
		if(!line.startsWith("[{")){
			return null;
		}

		List<Sensor> sensors = new ArrayList<Sensor>();
		try {
            JsonArray jArray = parser.parse(line).getAsJsonArray();

            for(JsonElement element: jArray){
                sensors.add(gson.fromJson(element, Sensor.class));
			}
			
			return sensors;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
