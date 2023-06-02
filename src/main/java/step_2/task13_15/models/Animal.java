package step_2.task13_15.models;

import java.util.ArrayList;

/**
 * Базовый класс "Животные"
 */
public class Animal {
    protected String kingdom = "animal";
    protected String type;
    protected String subtype;
    protected String name;
    protected String birthday;
    protected ArrayList<String> commands = new ArrayList<>();

    protected Animal() {
    }

    @Override
    public String toString() {
        String text = String.format("" +
                        "          Имя: %s\n" +
                        "Дата рождения: %s\n" +
                        "      Царство: %s\n" +
                        "          Тип: %s\n" +
                        "       Подтип: %s\n" +
                        "      Команды: %s\n\n",
                name, birthday,
                kingdom, type,
                subtype, commands);
        return text;
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }

    public String getKingdom() {
        return this.kingdom;
    }

    public String getType() {
        return this.type;
    }

    public String getSubtype() {
        return this.subtype;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public ArrayList<String> getCommands() {
        return this.commands;
    }
}
