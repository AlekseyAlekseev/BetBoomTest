package ru.bet;

import java.util.ArrayList;

public class PageNumberSort {


    public ArrayList<String> pageSort(ArrayList<String> urlList) {
        ArrayList<String> sortUrlList = new ArrayList<>();
        for (String url :
                urlList) {
            int pageNumber = searchPageNumber(url);
            if (!(sortUrlList.size() >= 20) && pageNumber % 2 == 0) {
                sortUrlList.add(url);
            }
        }
        return sortUrlList;
    }

    /**
     * Находит номер страницы из url
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
