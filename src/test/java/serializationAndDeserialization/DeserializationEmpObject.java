package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForSerializationAndDeserialization.EmpPojoClass;

public class DeserializationEmpObject {

	@Test
	public void deserializationEmpObject() throws JsonParseException, JsonMappingException, IOException {
	
	//create object of ObjectMapper
	ObjectMapper obj= new ObjectMapper();

	//Read the values from Object Mapper(json file)
	EmpPojoClass emp = obj.readValue(new File("./Data/EmpDetialsObject.json"), EmpPojoClass.class);
	
	//printing the values
	System.out.println(emp.geteName());
	System.out.println(emp.getSpouse().getsName());
	
	}
}
