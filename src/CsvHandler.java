import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvHandler {


    public static void writeToSchoolClassesCsv(SchoolClass schoolClass) throws IOException {
        File csvOutputFile = new File("src/resources/SchoolClasses.csv");
        FileWriter fw = new FileWriter(csvOutputFile, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(schoolClass);
        pw.flush();
        pw.close();
    }

    public List<SchoolClass> getSchoolClasses() throws FileNotFoundException {
        List<String> records = this.readSchoolClasses();
        // o metodo esta a ler a lista de arrays
        List<SchoolClass> schoolClasses = new ArrayList<>();
        // cria uma nova lista vazia de arrays
        for (String record : records) {
            String[] recordSplit = record.split(",");
            schoolClasses.add(new SchoolClass(recordSplit[0], recordSplit[1]));
            // para cada record separa com uma virgula e cria um objeto "schoolClass" e adiciona a lista nova de arrays
        }

        return schoolClasses;
        // retorna a lista de arrays
    }

    private List<String> readSchoolClasses() throws FileNotFoundException {
        List<String> records = new ArrayList<>();
        // inicia uma lista de arrays
        try {
            Scanner scanner = new Scanner(new File("src/resources/SchoolClasses.csv"));
            scanner.nextLine();
            // usa um scanner object para ler o ficheiro csv e da skip na primeira linha
            while (scanner.hasNextLine()) {
                records.add(scanner.nextLine());
                // enquanto houver uma linha nova o loop, ele lê e adiciona na lista de arrays
            }
            return records;
             // depois do loop o metodo retorna a lista "records"


        } catch (Exception ex) {
            throw new FileNotFoundException("no records found");
            // Se houver uma excepçao a ler o ficheiro , aparece a mensagem
        }
    }
}
