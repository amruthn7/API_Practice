package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForSerializationAndDeserialization.EmpPojoClass;

public class DeserializationEmpArray {

	@Test
	public void deserializationEmpArray() throws JsonParseException, JsonMappingException, IOException {
	
	//create object for ObjectMapper
	ObjectMapper obj= new ObjectMapper();

	//Read the values from Object Mapper(json file)
	EmpPojoClass emp = obj.readValue(new File("./Data/EmpDetialsArray.json"), EmpPojoClass.class);
	
	//printing the values
	System.out.println(emp.getPhNo()[1]);
	}
}
