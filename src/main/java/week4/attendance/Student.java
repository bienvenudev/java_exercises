package week4.attendance;

public class Student {
    private final String name;
    private boolean isPresent;

    public Student(String name, boolean isPresent) {
        this.name = name;
        this.isPresent = isPresent;
    }

    public String getName() { return this.name; };
    public boolean isPresent() { return this.isPresent; };
    public void setPresent(boolean present) { this.isPresent = present; }
}
