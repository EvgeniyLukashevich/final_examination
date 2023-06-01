package step_2.task13_15.mvc;

import java.text.ParseException;
import java.util.Date;

/**
 * Базовый интерфейс модели
 */
interface ModelBase {

    /**
     * Метод проверки корректности формата введенной даты
     *
     * @param innerDate строка, претендующая на звание даты
     * @return экземпляр класса Date
     * @throws ParseException в случае некорретного формата введенной даты
     */
    abstract String dateCheck(String innerDate) throws ParseException;
}
