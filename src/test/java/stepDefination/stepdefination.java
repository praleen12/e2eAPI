package stepDefination;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.*;
import io.cucumber.messages.JSON;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class stepdefination {
	
	RequestSpecification res;
	ResponseSpecification resspec;

	@Given("Add Place Payload")
	public void add_place_payload() {	
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		p.setName("Frontline");
		
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		p.setTypes(myList);
		

		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
//		================
		
	RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123v").setContentType(ContentType.JSON).build();
	ResponseSpecification resspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
		RequestSpecification res = given().spec(req).body(p);
		
		Response response = res.when().post("maps/api/place/add/json").
				then().spec(resspec).extract().response();
//		
		
		System.out.println("&&&&&&&&&&&"+ response.asString());
//		String response = given().log().all().queryParam("key", "qaclick123v")
//				.header("Content-Type", "application/json")
//				.body(p).when().post("maps/api/place/add/json").then().log().all().assertThat()
//				.statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract()
//				.response().asString();

	}


	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String string, String string2) {
		

	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
	}

	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String string, String string2) {
	}

}
