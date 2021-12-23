package Utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {

	public Map<String, String> getjsonMap(String fileName) throws IOException
	{
		JsonReader obj=new JsonReader();
		String json=obj.getJsonasString(fileName);
		ObjectMapper objectMapper = new ObjectMapper();

		@SuppressWarnings("unchecked")
		LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) objectMapper.readValue(json, Map.class);         
		System.out.println("Map is " + map);
		System.out.println("Map Size is " + map.size());
		return map;
	}

	public String getJsonasString(String fileName) throws IOException
	{
		String filePath = System.getProperty("user.dir");

		String filedata = new String(Files.readAllBytes(Paths.get(filePath+"\\"+fileName)));
		// print the result, i.e., JSON data in form of string  
		System.out.println(filedata);  
		return filedata;
	}  


	//To test	
	public static void main(String[] args)throws IOException { 
		JsonReader obj=new JsonReader();
		Map<String, String> json =obj.getjsonMap("test.json");

		System.out.println(json);

	}
}
