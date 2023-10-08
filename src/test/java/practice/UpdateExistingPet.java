package practice;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;



public class UpdateExistingPet {

	@Test
	public void updatePetTest() {

		JSONObject j= new JSONObject();
		j.put("id", 11);
		
		JSONObject j1= new JSONObject();
		j1.put("id", 12 );
		j1.put("name", "amr");
		j.put("category", j1);
		j.put("name", "doggie");
		
		JSONArray jarr=new JSONArray();
		jarr.add("www.xyz.com");
		j.put("photoUrl", jarr);
		
		JSONArray jarr2=new JSONArray();
		JSONObject j3= new JSONObject();
		j3.put("id", 13 );
		j3.put("name", "ruth");
		
		jarr2.add(j3);
		j.put("tags", jarr2);
		j.put("status", "available");

		//precodition
		given().contentType(ContentType.JSON).body(j)

		//peforming action
		.when().put("https://petstore.swagger.io/v2/pet")

		//validation
		.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).log().all();


	}
}

//{
//    "id": 11,
//    "category": {
//        "id": 12,
//        "name": "amr"
//    },
//    "name": "doggie",
//    "photoUrls": [
//        
//    ],
//    "tags": [
//        {
//            "id": 13,
//            "name": "ruth"
//        }
//    ],
//    "status": "available"
//}