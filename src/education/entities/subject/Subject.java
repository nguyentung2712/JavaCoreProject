package education.entities.subject;

public class Subject {
    private int id;
    private String name;
    private int numberOfCredits;
    private Type type;

    public Subject(int id, String name, int numberOfCredits, Type type) {
        this.id = id;
        this.name = name;
        this.numberOfCredits = numberOfCredits;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Subject's information{ id: " + id + ", name: " + name + ", number of credits: " + numberOfCredits + ", type: " + type + " }\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
