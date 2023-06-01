package step_2.task13_15.data;

import step_2.task13_15.models.Animal;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Базовый интерфейс работы с данными
 */
public interface BaseData {

    /**
     * Метод записи данных
     *
     * @param animal экземпляр класса Animal
     * @throws IOException в случае ошибки записи данных
     */
    abstract void dataIn(Animal animal) throws IOException;

    /**
     * Метод чтения данных
     *
     * @return список ArrayList с экземплярами класса Animal
     * @throws IOException в случае ошибки чтения данных
     */
    abstract ArrayList<Animal> dataOut() throws IOException;

}
