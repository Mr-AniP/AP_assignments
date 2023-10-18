package assignment3AP;

public class Student {
    private String name;
    private float cgpa;
    public float getCGPA() {
        return cgpa;
    }
    public String getName() {
        return name;
    }
    public void setCGPA(float c) {
        this.cgpa=c;
    }
    public void setName(String v) {
        this.name=v;
    }
}
