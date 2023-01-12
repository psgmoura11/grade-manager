import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        App app = new App();
        app.init();
    }

    private void init() throws FileNotFoundException {
      Scanner scanner = new Scanner(System.in);
      boolean logged = false;
      outerloop:
      while(true) {
        System.out.println("Welcome to the mega GradeManager 3000!\n" + "To use this manager you need to login:");
        System.out.println("Username:");
        final var username = scanner.nextLine();
        System.out.println("Password:");
        final var password = scanner.nextLine();
        Professor.authenticate(username, password);
          if (Professor.authenticate(username, password)) {
              logged = true;
              System.out.println("Login Successful!");
          } else {
              System.out.println("Invalid Login!");
          }
          while (true) {
              System.out.println(logged ? "What do you need to do?" : "");
              System.out.println("1. Add a new Class");
              System.out.println("2. Manage a class");
              System.out.println("3. Exit");
              final var getUserResponse = scanner.nextLine();
              if (getUserResponse.equals("1")) {
                  System.out.println("Adding a new Class");
                  System.out.println("Class name:");
                  String UserClass = scanner.nextLine();
                  System.out.println("Description:");
                  String UserClassDescription = scanner.nextLine();
                  System.out.println("You've created a new class called " + "\""
                          + UserClass + " " + UserClassDescription + "\"");
              } else if (getUserResponse.equals("2")) {
                  System.out.println("What class do you want to manage?");
              } else if (getUserResponse.equals("3")) {
                  System.out.println("Quiting");
                  break outerloop;
              } else {
                  System.out.println("Invalid command, try again!");
              }
          }
      }
  }
}
