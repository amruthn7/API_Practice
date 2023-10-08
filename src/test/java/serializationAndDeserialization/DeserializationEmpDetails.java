package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForSerializationAndDeserialization.EmployeeDetials;

public class DeserializationEmpDetails {
	@Test
	public void deserializationEmpTest() throws JsonParseException, JsonMappingException, IOException {
		
		//create object of ObjectMapper
		ObjectMapper obj= new ObjectMapper();
		
		//Read the values from Object Mapper(json file)
		EmployeeDetials emp= obj.readValue(new File("./Data/EmpDetials.json"), EmployeeDetials.class);
		
		//printing the values 
		System.out.println(emp.geteName());
		System.out.println(emp.geteID());
		System.out.println(emp.getPhNo());
		System.out.println(emp.getAddress());
	}
}
