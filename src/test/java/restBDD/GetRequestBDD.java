package restBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequestBDD {
	
	@Test
	public void test1() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.when()
					.get()
					.then()
					.log()
					.status()//.all() 
					.statusCode(200);
	}
	
	@Test
	public void test2() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.when()
					.get("/12")
					.then()
					.log()
					.body()
					.statusCode(200);
	}
	
	@Test
	public void test3() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.queryParam("name", "Mercy")
					.when()
					.get()
					.then()
					.log()
					.body()
					.statusCode(200);
	}
	
	@Test
	public void test4() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					//.queryParam("id", "1")
					.when()
					.get()
					.then()
					.log()
					.body()
					.statusCode(200)
					.body("[0].name", Matchers.equalTo("Mercy"));
	}

}
