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
        String getUserResponse;
        while (true) {
            startMenu();
            getUserResponse = scanner.nextLine();
            switch (getUserResponse) {
                case "1":
                    userAddClass();
                    break;
                case "2":
                    System.out.println("What class do you want to manage?");
                    List<SchoolClass> schoolClasses = getCsvClassesList();
                    for (SchoolClass classList : schoolClasses) {
                        int index = schoolClasses.indexOf(classList);
                        String listName = classList.getName();
                        System.out.println((index) + "." + listName);
                    }
                    int schoolClassChoice = scanner.nextInt();
                    scanner.nextLine();
                    SchoolClass schoolClassToOperate = schoolClasses.get(schoolClassChoice);
                    classManageMenu(schoolClassToOperate);
                    int schoolClassOperation = scanner.nextInt();
                    scanner.nextLine();
                    switch (schoolClassOperation) {
                        case 1:
                            System.out.println("Our Alumnis are: ");
                            System.out.println(schoolClassToOperate.getAlumniList());
                            for (Alumni alumni : schoolClassToOperate.getAlumniList()) {
                                System.out.println(alumni.getName());
                            }
                            break;
                        case 2:
                            System.out.println("Alumni name");
                            String alumniName = scanner.nextLine();
                            System.out.println("Alumni age");
                            int alumniAge = scanner.nextInt();
                            scanner.nextLine();
                            Alumni newAlumni = new Alumni(alumniName, alumniAge);
                            schoolClassToOperate.addAlumni(newAlumni);
                            break;
                        case 3:
                            break;
                    }
                    break;
                case "3":
                    SchoolClass turma1 = new SchoolClass("Shit","class");
                    Alumni george = new Alumni("george", 29);
                    Alumni joao = new Alumni("joao", 12);
                    System.out.println(joao);
                    turma1.addAlumni(george);
                    turma1.addAlumni(joao);
                    System.out.println(turma1.getAlumniList());
                    // getAllClassesList();
                    break;
                case "4":
                    System.out.println("Quiting \n");
                    System.exit(0);
                default:
                    System.out.println("Invalid command, try again!");
            }
        }
    }

    private void startMenu() {
        System.out.println("What do you need to do?");
        System.out.println("1. Add a new Class");
        System.out.println("2. Manage a class");
        System.out.println("3. List all Classes");
        System.out.println("4. Exit");
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

    private List<SchoolClass> getCsvClassesList() throws FileNotFoundException {
        CsvHandler csvList = new CsvHandler();
        List<SchoolClass> allClassesList = csvList.getSchoolClasses();
        return allClassesList;
    }

    private List<SchoolClass> getAllClassesList() throws FileNotFoundException {
        CsvHandler csvList = new CsvHandler();
        List<SchoolClass> allClassesList = csvList.getSchoolClasses();
        System.out.println("Here are the classes:");
        for (SchoolClass schoolClass : allClassesList) {
            System.out.println(schoolClass.toString());
        }
        return allClassesList;
    }
    public void classManageMenu(SchoolClass schoolClass) {
        System.out.println("What do you want to do to class: " + schoolClass.getName() + "?");
        System.out.println("1. Show alumni");
        System.out.println("2. Add alumni");
        System.out.println("3. Back");
    }
}
