package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForSerializationAndDeserialization.EmpPojoClass;

public class SerializationWithEmpArray {

	@Test
	public void serializationWithEmpArray() throws JsonGenerationException, JsonMappingException, IOException {
		
		int[] phoneNo= {987456, 123456};
		String[] email= {"amr@gmail.com", "ruth@gmail.com"};
		
		//create object for emp pojo class
		EmpPojoClass emp=  new EmpPojoClass(email, phoneNo);
		
		//create object of ObjectMapper
		ObjectMapper obj= new ObjectMapper();
		
		//writing values in json file
		obj.writeValue(new File("./Data/EmpDetialsArray.json"), emp);
	}
}
