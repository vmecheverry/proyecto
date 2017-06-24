package com.mkyong.json;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson3Example {

	public static void main(String[] args) {
		Jackson3Example obj = new Jackson3Example();
		obj.run();
	}

	private void run() {
		ObjectMapper mapper = new ObjectMapper();

		try {

			// Convert JSON string from file to Object
			
			@SuppressWarnings("unchecked")
			List<Staff> staff= (List<Staff>) mapper.readValue(new File("D:\\staff.json"), List.class);
			System.out.println(staff);

			// Convert JSON string to Object
			/*String jsonInString = "{\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
			Staff staff1 = mapper.readValue(jsonInString, Staff.class);
			System.out.println(staff1);*/

			//Pretty print
			/*String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
			System.out.println(prettyStaff1);*/

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}