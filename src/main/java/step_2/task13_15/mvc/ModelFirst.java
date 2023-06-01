package step_2.task13_15.mvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Вариант модели. Наследник базового интерфейса ModelBase.
 */
public class ModelFirst implements ModelBase {

    @Override
    public String dateCheck(String innerDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(innerDate);
            return innerDate;
        } catch (Exception e) {
            throw new ParseException("Введена некорректная дата: " + innerDate, -1);
        }
    }
}
