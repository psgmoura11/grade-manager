import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvHandler {


    public void writeToSchoolClassesCsv(SchoolClass schoolClass) {
        //escrever na última linha do csv
    }

    public List<SchoolClass> getSchoolClasses() throws FileNotFoundException {
        var records = this.readSchoolClasses();
        List<SchoolClass> schoolClasses = new ArrayList<>();
        for (String record : records) {
            String[] recordSplit = record.split(",");
            schoolClasses.add(new SchoolClass(recordSplit[0], recordSplit[1]));
        }

        return schoolClasses;
    }

    private List<String> readSchoolClasses() throws FileNotFoundException {
        List<String> records = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/resources/SchoolClasses.csv"));
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                records.add(scanner.nextLine());
            }
            return records;

        } catch (Exception ex) {
            throw new FileNotFoundException("no records found");
        }
    }
}