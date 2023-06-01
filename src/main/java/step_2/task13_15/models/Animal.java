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

    public static class Builder {
        protected String kingdom;
        protected String type;
        protected String subtype;
        protected String name;
        protected String birthday;
        protected ArrayList<String> commands = new ArrayList<>();

        public Animal build() {
            Animal animal = new Animal();
            animal.kingdom = this.kingdom;
            animal.type = this.type;
            animal.subtype = this.subtype;
            animal.name = this.name;
            animal.birthday = this.birthday;
            animal.commands = this.commands;
            return animal;
        }

        public Builder setKingdom(String kingdom) {
            this.kingdom = kingdom;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setSubtype(String subtype) {
            this.subtype = subtype;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder setCommands(ArrayList<String> commands) {
            this.commands = commands;
            return this;
        }
    }
}
