package com.bh.backend;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

@QuarkusTest
public class CustomerResourceIntegrationTest {

    @Test
    void shouldReturnAllCustomers() {

        given().contentType(ContentType.JSON)
                .when().get("/customer")
                .then().statusCode(200)
                .body("size()", is(4));
    }

    @Test
    void shouldReturnTheCustomerWithCustomerID1() {
        given().contentType(ContentType.JSON).param("customerid", 1)
                .when().get("/customer/id")
                .then().statusCode(200)
                .body("size()", is(4))
                .body("name", is("hilarion"))
                .body("surname", is("kodia"));
    }
}
