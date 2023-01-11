import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        App app = new App();
        app.init();
    }

    private void init() throws FileNotFoundException {

        System.out.println("Welcome to the mega GradeManager 3000!\n" + "To use this manager you need to login:");
        System.out.println("Username:");
        Scanner scanner = new Scanner(System.in);
        final var username = scanner.nextLine();
        System.out.println("Password:");
        final var password = scanner.nextLine();
        Professor.authenticate(username, password);

        //avaliar o resultado de Professor.authenticate e agir de acordo
        //continuação do programa

    }
}