package com.bh.backend;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

@QuarkusTest
public class AccountResourceIntegrationTest {

    @Test
    void shouldOpenAnAccountWithBalance0() {
        given().body("{\"customerID\": 1, \"initialCredit\": 0}")
                .header("Content-Type", "application/json")
                .when()
                .post("/account")
                .then()
                .statusCode(200)
                .body("size()", is(3),
                        "accountId", is(1),
                        "balance", is(0.0F));
    }

    @Test
    void shouldOpenAnAccountWithBalance4AndSendATransactionOnTheAccount() {
        given().body("{\"customerID\": 1, \"initialCredit\": 4}")
                .header("Content-Type", "application/json")
                .when()
                .post("/account")
                .then()
                .statusCode(200)
                .body("size()", is(3),
                        "accountId", is(1),
                        "balance", is(4.0F),
                        "transactions.size()", is(1),
                        "transactions[0].transactionId", is(1),
                        "transactions[0].accountId", is(1),
                        "transactions[0].amount", is(4.0F));
    }
}