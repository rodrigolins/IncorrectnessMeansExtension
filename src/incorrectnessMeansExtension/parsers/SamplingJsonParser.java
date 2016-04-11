package incorrectnessMeansExtension.parsers;

import incorrectnessMeansExtension.types.ArduinoValue;

import com.google.gson.Gson;

public class SamplingJsonParser {
	private static Gson gson = new Gson();
	
	/*
	 * Return only Sample objects
	 * 
	 * If the line is not well formed, return null
	 */
	public static ArduinoValue parseLine(String line) {
		if(!line.startsWith("{")){
			return null;
		}
		try {
			return gson.fromJson(line, ArduinoValue.class);
		} catch (Exception e) {
			System.out.println("Error parsing arduino value line");
		}
		return null;
	}
}
