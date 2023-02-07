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


    public static void showAllAlumni() throws IOException {
        CsvHandler alumniList = new CsvHandler();
        List<Alumni> allAlumnis = alumniList.getAlumni();
        for (Alumni alumniRecords : allAlumnis) {
            int index = allAlumnis.indexOf(alumniRecords);
            String name = alumniRecords.getName();
            int age = alumniRecords.getAge();
            System.out.println("-" + name + ":" + age + "years old");
        }
    }
}
