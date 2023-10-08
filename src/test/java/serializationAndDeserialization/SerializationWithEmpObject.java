package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForSerializationAndDeserialization.EmpPojoClass;
import pojoClassForSerializationAndDeserialization.SpousePojoClass;

public class SerializationWithEmpObject {

	@Test
	public void serializationWithEmpObject() throws JsonGenerationException, JsonMappingException, IOException {
		
		String name="Amr";
		int[] phoneNo= {987456, 123456};
		String[] email= {"amr@gmail.com", "ruth@gmail.com"};
		
		//create object for spouse pojo class
		SpousePojoClass spouse= new SpousePojoClass("Dee", "dee@qwer.in", 777888);
		
		//create object for emp pojo class
		EmpPojoClass emp=  new EmpPojoClass(name,email, phoneNo, spouse);
		
		//create object of ObjectMapper
		ObjectMapper obj= new ObjectMapper();
		
		//writing values in json file
		obj.writeValue(new File("./Data/EmpDetialsObject.json"), emp);
	}
}
