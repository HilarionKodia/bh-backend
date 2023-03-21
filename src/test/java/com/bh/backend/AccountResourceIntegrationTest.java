package com.bh.backend;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

@QuarkusTest
public class AccountResourceIntegrationTest {

    @Test
    void shouldOpenAnAccountWithBalance0AndNotSendATransactionOnTheAccount() {
        given().body("{\"customerID\": 1, \"initialCredit\": 0}")
                .header("Content-Type", "application/json")
                .when()
                .post("/account")
                .then()
                .statusCode(200)
                .body("size()", is(3),
                        "accountId", notNullValue(),
                        "balance", is(0.0F),
                        "transactions", nullValue());
    }

    @Test
    void shouldOpenAnAccountWithBalance4AndSendOneTransactionOnTheAccount() {
        given().body("{\"customerID\": 1, \"initialCredit\": 4}")
                .header("Content-Type", "application/json")
                .when()
                .post("/account")
                .then()
                .statusCode(200)
                .body("size()", is(3),
                        "accountId", notNullValue(),
                        "balance", is(4.0F),
                        "transactions", notNullValue(),
                        "transactions.size()", is(1),
                        "transactions[0].transactionId", is(1),
                        "transactions[0].accountId", notNullValue(),
                        "transactions[0].amount", is(4.0F));
    }
}