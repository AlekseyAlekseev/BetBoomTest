package ru.bet;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class PageAvailabilityTest {


    /**
     * Проверяет доступность страницы
     */
    @Test
    void checkPageAvailability() {
        RestAssured.baseURI = "https://lubart-miniatures.com/shop/page/7/";
        RestAssured.
                when().get().then().
                assertThat().statusCode(200);
    }

}
