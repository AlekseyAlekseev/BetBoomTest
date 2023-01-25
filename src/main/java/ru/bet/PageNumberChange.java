package ru.bet;

public class PageNumberChange {


    /**
     * Метод обновляет номер страницы на тот, который передан во входные параметры
     *
     * @param url        адрес в котором нужно изменить номер страницы
     * @param pageNumber число, на которое будет увеличен изначальный номер страницы
     * @return возвращает URL с обновленным номером страницы
     */
    public String changeNumber(String url, int pageNumber) {
        int startIndexPage = url.indexOf("page/") + 5;
        String pageWithoutNumber = url.substring(startIndexPage);
        int lastIndexNumber = pageWithoutNumber.contains("?") ? pageWithoutNumber.indexOf("?") : pageWithoutNumber.indexOf("/");
        int oldPageNumber = Integer.parseInt(pageWithoutNumber.substring(0, lastIndexNumber));
        int newPageNumber = oldPageNumber + pageNumber;
        return url.replaceFirst(String.valueOf(oldPageNumber), String.valueOf(newPageNumber));
    }
}
