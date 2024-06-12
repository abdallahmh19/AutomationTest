package tests;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APITest {

    @Test
    public void addNewDeviceTest() {
        RestAssured.baseURI = "https://api.restful-api.dev";

        // Request Payload
        Map<String, Object> requestPayload = new HashMap<>();
        requestPayload.put("name", "Apple Max Pro 1TB");
        Map<String, Object> data = new HashMap<>();
        data.put("year", 2023);
        data.put("price", 7999.99);
        data.put("CPU model", "Apple ARM A7");
        data.put("Hard disk size", "1 TB");
        requestPayload.put("data", data);

        // Send POST request
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post("/objects");

        // Verify response
        Assert.assertEquals(response.getStatusCode(), 200);

        String id = response.jsonPath().getString("id");
        String createdAt = response.jsonPath().getString("createdAt");

        // Validate id and createdAt
        Assert.assertNotNull(id);
        Assert.assertNotNull(createdAt);

        // Validate other details from response
        Assert.assertEquals(response.jsonPath().getString("name"), "Apple Max Pro 1TB");
        Assert.assertEquals(response.jsonPath().getInt("data.year"), 2023);
        Assert.assertEquals(response.jsonPath().getDouble("data.price"), 7999.99);
        Assert.assertEquals(response.jsonPath().getString("data.CPU model"), "Apple ARM A7");
        Assert.assertEquals(response.jsonPath().getString("data.Hard disk size"), "1 TB");

        
    }
}
