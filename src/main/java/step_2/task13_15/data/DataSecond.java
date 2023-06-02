package step_2.task13_15.data;

import step_2.task13_15.models.Animal;
import step_2.task13_15.models.subtypes.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSecond implements BaseData {
    private static final String DATA_PATH = "src/main/java/step_2/task13_15/data/database";
    private static final List<String> SUBTYPES = Arrays.asList(
            "cat", "dog", "hamster", "horse", "camel", "donkey");
    private static final char DELIMITER = ';';

    @Override
    public void dataIn(Animal animal) throws IOException {
        String filePath = DATA_PATH + "/" + animal.getSubtype() + "/" + animal.getName() + ".txt";
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(animal.getName() +
                    DELIMITER + animal.getBirthday() +
                    DELIMITER + animal.getCommands() + "\n");
        } catch (IOException e) {
            throw new IOException("Произошла ошибка записи данных в файл " + filePath);
        }
    }

    @Override
    public ArrayList<Animal> dataOut() throws IOException {
        ArrayList<Animal> animalList = new ArrayList<>();
        for (String subtype : SUBTYPES) {
            File dir = new File(DATA_PATH + "/" + subtype);
            File[] files = dir.listFiles();
            if (files == null) {
                throw new IOException("Произошла ошибка чтения данных из директории: " + dir.getPath());
            }

            for (File file : files) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split(String.valueOf(DELIMITER));
                        Animal animal = createAnimal(subtype, data[0], data[1]);
                        addCommands(animal, data[2]);
                        animalList.add(animal);
                    }
                } catch (Exception e) {
                    throw new IOException("Произошла ошибка чтения данных из директории: " + file.getName(), e);
                }
            }
        }
        return animalList;
    }

    private Animal createAnimal(String subtype, String name, String birthday) {
        return switch (subtype) {
            case "dog" -> new Dog(name, birthday);
            case "cat" -> new Cat(name, birthday);
            case "hamster" -> new Hamster(name, birthday);
            case "horse" -> new Horse(name, birthday);
            case "camel" -> new Camel(name, birthday);
            default -> new Donkey(name, birthday);
        };
    }

    private void addCommands(Animal animal, String commandStr) {
        if (commandStr.equals("[]")) {
            return;
        }
        List<String> commands = List.of(commandStr.
                replace("[", "").
                replace("]", "").
                split(", "));
        for (String command : commands) {
            animal.addCommand(command);
        }
    }
}

