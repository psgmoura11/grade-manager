import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolClass {

    private String name;
    private String description;

    private ArrayList<Alumni> alumniList;

    @Override
    public String toString() {
      return this.name + "," + this.description;
    }

    public SchoolClass(String name, String description) {
        this.alumniList = new ArrayList<Alumni>();
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Alumni> getAlumniList() {
        return this.alumniList;
    }
    public void addAlumni(Alumni alumni) throws IOException {
        this.alumniList.add(alumni);
        System.out.println("the alumni:" + alumni.getName() + " " + "is associated to the" + this.getName());
        //CsvHandler.writeToAlumni(newAlumni);
    }
}
