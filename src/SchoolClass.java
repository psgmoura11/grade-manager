public class SchoolClass {

    private String name;
    private String description;

    @Override
    public String toString() {
        return "SchoolClass{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public SchoolClass(String name, String description) {
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
}
