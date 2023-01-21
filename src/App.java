import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        App app = new App();
        app.init();
    }

    private void init() throws IOException {
      Scanner scanner = new Scanner(System.in);
       /* System.out.println("Welcome to the mega GradeManager 3000!\n" + "To use this manager you need to login:");
      String username;
      String password;
      boolean userCredentials = false;
      while(!userCredentials) {
          System.out.println("Username:");
          username = scanner.nextLine();
          System.out.println("Password:");
          password = scanner.nextLine();
          userCredentials = Professor.authenticate(username, password);
      }*/
      while (true) {
          startMenu();
          String getUserResponse = scanner.nextLine();
          switch (getUserResponse) {
              case "1":
                  userAddClass();
                  break;
              case "2":
                  System.out.println("What class do you want to manage?");
                  getCsvClassesList();
                  managingClassMenu();
                  //classManageMenu(selectedClass);
                  break;
              case "3":
                  getCsvClassesList();
                  backMenu();
                  break;
              case "4":
                  System.out.println("Quiting \n");
                  System.exit(0);
              default:
                  System.out.println("Invalid command, try again!");
          }
      }
  }

     private static void startMenu() {
          System.out.println("What do you need to do?");
          System.out.println("1. Add a new Class");
          System.out.println("2. Manage a class");
          System.out.println("3. List all Classes");
          System.out.println("4. Exit");
     }
    private static void backMenu() {
        System.out.println("5- back");
        // fala buscar o index
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 5:
                startMenu();
                break;
        }
    }
    private static void userAddClass() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding a new Class");
        System.out.println("Class name:");
        String name = scanner.nextLine();
        System.out.println("Description:");
        String description = scanner.nextLine();
        SchoolClass schoolClass = new SchoolClass(name, description);
        CsvHandler.writeToSchoolClassesCsv(schoolClass);
        System.out.println("You've created a new class called " + "\""
              + name + " " + description + "\" \n");
    }

  private static void getCsvClassesList() throws FileNotFoundException {
      CsvHandler csvList = new CsvHandler();
      List<SchoolClass> allClassesList = csvList.getSchoolClasses();
      for (SchoolClass classList : allClassesList) {
          int index = allClassesList.indexOf(classList);
          String listName = classList.getName();
          System.out.println((index+1) + "." + listName);
      }
  }
  private static void managingClassMenu() throws FileNotFoundException {
      Scanner scanner = new Scanner(System.in);
      int userSelection = scanner.nextInt();
      CsvHandler csvList = new CsvHandler();
      List<SchoolClass> allClassesList = csvList.getSchoolClasses();
      if (userSelection > 0 && userSelection <= allClassesList.size()) {
          SchoolClass selectedClass = allClassesList.get(userSelection - 1);
          System.out.println("You have selected: " + selectedClass);
      } else {
          System.out.println("Invalid selection, please try again.");
      }
  }
  private  static void classManageMenu(SchoolClass selectedClass){

        System.out.println(selectedClass);
  }
}
