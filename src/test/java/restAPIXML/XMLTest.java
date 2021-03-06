package restAPIXML;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;

public class XMLTest {
	
	@Test
	public void test1() {
		
		RestAssured.given()
		.baseUri("https://chercher.tech/sample/api/books.xml")
		.when()
		.get()
		.then()
		.log()
		.body()
		.statusCode(200);
	}
	
	@Test
	public void test2() {
		
		Response response = RestAssured.given()
										.baseUri("https://chercher.tech/sample/api/books.xml")
										.when()
										.get();
		
		NodeChildrenImpl books = response.then().extract().path("bookstore.book.title");
		
		System.out.println("All the books are: " + books.toString());
		System.out.println("First book is : " + books.get(0).toString());
		
		System.out.println("Language of First book is : " + books.get(0).getAttribute("lang"));
		
		for(int index=0;index<books.size();index++) {
			
			System.out.println("Book is: " + books.get(index).toString());
		}
		
		NodeChildrenImpl price = response.then().extract().path("bookstore.book.price");
		System.out.println("All the prices are: " + price.toString());
		
		System.out.println("First price is : " + price.get(0).children().get("paperback"));
		
		
	}

}
