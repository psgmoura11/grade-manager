import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Alumni {
    private String name;
    private int age;

    @Override
    public String toString() {
        return this.name + "," + this.age;
    }

    public Alumni(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void addAlumni() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add Name:");
        String name = scanner.nextLine();
        System.out.println("Add Age:");
        int age = Integer.parseInt(scanner.nextLine());
        Alumni newAlumni = new Alumni(name,age);
        CsvHandler.writeToAlumni(newAlumni);
    }

    public static void showAlumni() throws FileNotFoundException {
        CsvHandler alumniList = new CsvHandler();
        List<Alumni> allAlumnis = alumniList.getAlumni();
        for (Alumni alumniRecords : allAlumnis) {
            int index = allAlumnis.indexOf(alumniRecords);
            String name = alumniRecords.getName();
            int age = alumniRecords.getAge();
            System.out.println("-" + name);
            System.out.println("-" + age);
        }

    }
}