package ru.bet;

import java.util.ArrayList;

public class PageNumberSort {


    /**
     * Сортирует список url по возврастанию и после оставляет в списке только четные номера страниц в кол-ве макс. 20 штук
     *
     * @param urlList изначальный список url
     * @return возвращает отсортированный список по возврастанию только с четными номерами страниц в кол-ве макс. 20 штук
     */
    public ArrayList<String> pageNumberSort(ArrayList<String> urlList) {
        ArrayList<String> sortUrlList = new ArrayList<>();
        boolean isSorted = false;
        String temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < urlList.size() - 1; i++) {
                if (searchPageNumber(urlList.get(i)) > searchPageNumber(urlList.get(i + 1))) {
                    isSorted = false;
                    temp = urlList.get(i);
                    urlList.set(i, urlList.get(i + 1));
                    urlList.set(i + 1, temp);
                }
            }
        }
        for (String url :
             urlList) {
            if (sortUrlList.size() < 20 && searchPageNumber(url) % 2 == 0) {
                sortUrlList.add(url);
            }
        }
        return sortUrlList;
    }

    /**
     * Находит номер страницы из url
     *
     * @param url адрес в котором нужно найти номер страницы
     * @return возвращает номер страницы из url
     */
    private int searchPageNumber(String url) {
        int startIndexPage = url.indexOf("page/") + 5;
        String pageWithoutNumber = url.substring(startIndexPage);
        int lastIndexNumber = pageWithoutNumber.contains("?") ? pageWithoutNumber.indexOf("?") : pageWithoutNumber.indexOf("/");
        return Integer.parseInt(pageWithoutNumber.substring(0, lastIndexNumber));
    }
}
