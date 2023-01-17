import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        App app = new App();
        app.init();
    }

    private void init() throws FileNotFoundException {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Welcome to the mega GradeManager 3000!\n" + "To use this manager you need to login:");
      String username;
      String password;
      boolean userCredentials = false;
      while(!userCredentials) {
          System.out.println("Username:");
          username = scanner.nextLine();
          System.out.println("Password:");
          password = scanner.nextLine();
          userCredentials = Professor.authenticate(username, password);
      }
      while (true) {
          System.out.println("What do you need to do?");
          System.out.println("1. Add a new Class");
          System.out.println("2. Manage a class");
          System.out.println("3. Exit");
          final var getUserResponse = scanner.nextLine();
          switch (getUserResponse) {
              case "1":
              System.out.println("Adding a new Class");
              System.out.println("Class name:");
              String name = scanner.nextLine();
              System.out.println("Description:");
              String description = scanner.nextLine();
              SchoolClass schoolClass = new SchoolClass(name, description);
              CsvHandler.writeToSchoolClassesCsv(schoolClass);
              System.out.println("You've created a new class called " + "\""
                      + name + " " + description + "\" \n");
              break;
              case "2":
                  System.out.println("What class do you want to manage?");
                  break;
              case "3":
                  System.out.println("Quiting \n");
                  System.exit(0);
              default:
                  System.out.println("Invalid command, try again!");
          }
      }
  }
}
