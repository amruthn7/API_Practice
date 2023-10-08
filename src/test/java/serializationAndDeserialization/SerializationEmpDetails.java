package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForSerializationAndDeserialization.EmployeeDetials;

public class SerializationEmpDetails {

	@Test
	public void serializationEmpTest() throws JsonGenerationException, JsonMappingException, IOException  {
		
		//create object for pojo class
		EmployeeDetials emp= new EmployeeDetials("Amruth", "TY648", 81471456, "amruth@gmail.com", "Bangalore");
		
		//create object for ObjectMapper
		ObjectMapper obMap= new ObjectMapper();
		
		//writing values to the json file
		obMap.writeValue(new File("./Data/EmpDetials.json"), emp);
		
	}
}
