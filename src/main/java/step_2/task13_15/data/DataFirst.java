package step_2.task13_15.data;

import step_2.task13_15.models.Animal;
import step_2.task13_15.models.subtypes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Дочерний класс интерфейса BaseData,
 * ориентированный на чтение/запись данных из/в файл(-а)
 */
public class DataFirst implements BaseData {
    private final String DATA_PATH = "src/main/java/step_2/task13_15/data/database";
    private final ArrayList<String> SUBTYPES = new ArrayList<>(
            Arrays.asList("cat", "dog", "hamster", "horse", "camel", "donkey"));
    private final char DELIMITER = ';';

    @Override
    public void dataIn(Animal animal) throws IOException {
        String filePath = DATA_PATH + "/" + animal.getSubtype() + "/" + animal.getName() + ".txt";

        try {
            FileWriter writer = new FileWriter(filePath, false);
            writer.write(animal.getName() + DELIMITER +
                    animal.getBirthday() + DELIMITER +
                    animal.getCommands() + "\n");
            writer.close();
        } catch (IOException e) {
            throw new IOException(
                    "Произошла ошибка записи данных в файл " + filePath);
        }
    }

    @Override
    public ArrayList<Animal> dataOut() throws IOException {
        ArrayList<Animal> animalList = new ArrayList<>();
        Animal animal;

        for (String subtype : SUBTYPES) {
            File dir = new File(DATA_PATH + "/" + subtype);
            File[] files = dir.listFiles();

            for (File file : files) {
                try (BufferedReader read = new BufferedReader(new FileReader(file))) {
                    String line;

                    while ((line = read.readLine()) != null) {
                        String[] data = line.split(String.valueOf(DELIMITER));

                        switch (subtype) {
                            case "dog" -> animal = new Dog(data[0], data[1]);
                            case "cat" -> animal = new Cat(data[0], data[1]);
                            case "hamster" -> animal = new Hamster(data[0], data[1]);
                            case "horse" -> animal = new Horse(data[0], data[1]);
                            case "camel" -> animal = new Camel(data[0], data[1]);
                            default -> animal = new Donkey(data[0], data[1]);
                        }

                        if (data[2].equals("[]")) {
                            animalList.add(animal);
                            continue;
                        } else {
                            ArrayList<String> commands = new ArrayList<>();
                            commands.addAll(List.of(data[2]
                                    .replace("[", "")
                                    .replace("]", "")
                                    .split(", ")));

                            for (String command : commands)
                                animal.addCommand(command);

                            animalList.add(animal);
                        }
                    }

                } catch (Exception e) {
                    throw new IOException(
                            "Произошла ошибка чтения данных из файла "
                                    + DATA_PATH + file.getName());
                }
            }
        }
        return animalList;
    }
}
