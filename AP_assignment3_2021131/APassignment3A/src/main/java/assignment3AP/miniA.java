package assignment3AP;

import java.util.ArrayList;
import java.util.List;

public class miniA {
    private int s=0;

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public List<Student> getLos() {
        return los;
    }

    public void setLos(List<Student> los) {
        this.los = los;
    }
    public void setLos1(List<Student> los) {
        this.los = new ArrayList<>(los);
    }

    private List<Student>los;
}
