package ru.bet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PageNumberChangeTest {


    private static final PageNumberChange pageNumberChange = new PageNumberChange();

    final String urlWithoutQuery = "https://lubart-miniatures.com/shop/page/7/";
    final String urlWithQuery = "https://lubart-miniatures.com/shop/page/7?options=true&table=1/";

    /**
     * Проверяет успешную смену номера страницы, если url без query параметров
     */
    @Test
    void checkChangeNumberPageUrlWithoutQuery() {
        final String expectedWithoutQuery = "https://lubart-miniatures.com/shop/page/17/";
        final String resultWithoutQuery = pageNumberChange.changeNumber(urlWithoutQuery, 10);
        Assertions.assertEquals(expectedWithoutQuery, resultWithoutQuery);
    }

    /**
     * Проверяет успешную смену номера страницы, если url с query параметрами
     */
    @Test
    void checkChangeNumberPageUrlWithQuery() {
        final String expectedWithQuery = "https://lubart-miniatures.com/shop/page/17?options=true&table=1/";
        final String resultWithQuery = pageNumberChange.changeNumber(urlWithQuery, 10);
        Assertions.assertEquals(expectedWithQuery, resultWithQuery);
    }
}
