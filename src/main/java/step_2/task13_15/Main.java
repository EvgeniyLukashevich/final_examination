package step_2.task13_15;


import step_2.task13_15.data.DataFirst;
import step_2.task13_15.mvc.Controller;
import step_2.task13_15.mvc.ModelFirst;
import step_2.task13_15.mvc.ViewConsole;

public class Main {
    public static void main(String[] args) {
        DataFirst data = new DataFirst();
        ModelFirst model = new ModelFirst();
        ViewConsole view = new ViewConsole();
        Controller controller = new Controller(data,model,view);
        controller.start();

    }
}
