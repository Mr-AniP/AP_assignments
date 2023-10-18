package assignment3AP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static int power(int i, int i2) {
        int m=1;
        while(i2!=0) {
            m=m*i;
            i2--;
        }
        return m;
    }
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        List<Student> myList = new ArrayList<Student>();
        List<Student> myList1;
        Student vi;
        PartA a;
        long start, end;
        int i = 0, k = 0, v;
        System.out.println("Part-A");
        System.out.println();
        miniA ob;
        while (i <= 5) {
            v = power(10, i);
            System.out.println("Case-" + (i + 1) + " ( No. of students = " + v + " )");
            for (; k < v; k++) {
                vi = new Student();
                vi.setName("Student-" + (k + 1));
                vi.setCGPA((float) (rand.nextInt(10001)) / 1000);
                myList.add(vi);
            }
            ob = new miniA();
            ob.setLos1(myList);
            a = new PartA(0, ob);
//			for(int n=0;n<v;n++) {
//				System.out.println(myList.get(n).getCGPA());
//			}
            start = System.nanoTime();
            a.Oddevensort_withoutparallization();
            end = System.nanoTime();
            myList1 = ob.getLos();
//			for(int n=0;n<v;n++) {
//				System.out.println(myList1.get(n).getCGPA());
//			}
            System.out.println("Time elapsed using ODD-EVEN-SORT without parrallization = " + ((end - start)) + " nanoseconds");
            ob = new miniA();
            ob.setLos1(myList);
            a = new PartA(0, ob);
//			for(int n=0;n<v;n++) {
//				System.out.println(myList.get(n).getCGPA());
//			}
            start = System.nanoTime();
            a.Oddevensort_withparallization();
            end = System.nanoTime();
            myList1 = ob.getLos();
//			for(int n=0;n<v;n++) {
//				System.out.println(myList1.get(n).getCGPA());
//			}
            System.out.println("Time elapsed using ODD-EVEN-SORT with parrallization = " + ((end - start)) + " nanoseconds");
            i++;
        }
    }
}
