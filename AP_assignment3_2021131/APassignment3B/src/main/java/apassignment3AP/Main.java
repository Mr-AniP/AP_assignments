package apassignment3AP;

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
        int i;
        System.out.println("Part-A");
        System.out.println();
        System.out.println("Part-B");
        System.out.println();
        System.out.println("Case-1 ( No. of nodes = 10 )");
        long []m=new long[10];
        for(i=0;i<10;i++){
            m[i]=rand.nextLong(2000000001)-1000000000;
        }
        PartB b;
        RecursiveBalancedBinaryTree ts=new RecursiveBalancedBinaryTree();
        b=new PartB(m,0,10,ts,ts.getHead());
        b.construct_withoutparallelization(m[6]);
        System.out.println("Time elapsed in construc ting Recursive Balanced Binary Tree  without parrallization = "+ ((ts.getEnd1()-ts.getStart1())) +" nanoseconds");
        System.out.println("Height of the constructed Recursive Balanced Binary Tree  without parrallization = "+ts.getHeighty());
        System.out.println("Time elapsed in finding a specific element in constructed Recursive Balanced Binary Tree  without parrallization = "+ ((ts.getEnd()-ts.getStart())) +" nanoseconds");
        ts=new RecursiveBalancedBinaryTree();
        b=new PartB(m,0,10,ts,ts.getHead());
        b.construct_withparallelization_2(m[6]);
        System.out.println("Time elapsed in constructing Recursive Balanced Binary Tree  with parrallization using 2 threads = "+ ((ts.getEnd1()-ts.getStart1())) +" nanoseconds");
        System.out.println("Height of the constructed Recursive Balanced Binary Tree  with parrallization using 2 threads = "+ts.getHeighty());
        System.out.println("Time elapsed in finding a specific element in constructed Recursive Balanced Binary Tree  with parrallization using 2 threads = "+ ((ts.getEnd()-ts.getStart())) +" nanoseconds");
        ts=new RecursiveBalancedBinaryTree();
        b=new PartB(m,0,10,ts,ts.getHead());
        b.construct_withparallelization_4(m[6],1);
        System.out.println("Time elapsed in constructing Recursive Balanced Binary Tree  with parrallization using 4 threads = "+ ((ts.getEnd1()-ts.getStart1())) +" nanoseconds");
        System.out.println("Height of the constructed Recursive Balanced Binary Tree  with parrallization using 4 threads = "+ts.getHeighty());
        System.out.println("Time elapsed in finding a specific element in constructed Recursive Balanced Binary Tree  with parrallization using 4 threads = "+ ((ts.getEnd()-ts.getStart())) +" nanoseconds");
        System.out.println("Case-2 ( No. of nodes = 1000 )");
        m=new long[1000];
        for(i=0;i<1000;i++){
            m[i]=rand.nextLong(2000000001)-1000000000;
        }
        ts=new RecursiveBalancedBinaryTree();
        b=new PartB(m,0,1000,ts,ts.getHead());
        b.construct_withoutparallelization(m[20]);
        System.out.println("Time elapsed in constructing Recursive Balanced Binary Tree  without parrallization = "+ ((ts.getEnd1()-ts.getStart1())) +" nanoseconds");
        System.out.println("Height of the constructed Recursive Balanced Binary Tree  without parrallization = "+ts.getHeighty());
        System.out.println("Time elapsed in finding a specific element in constructed Recursive Balanced Binary Tree  without parrallization = "+ ((ts.getEnd()-ts.getStart())) +" nanoseconds");
        ts=new RecursiveBalancedBinaryTree();
        b=new PartB(m,0,1000,ts,ts.getHead());
        b.construct_withparallelization_2(m[20]);
        System.out.println("Time elapsed in constructing Recursive Balanced Binary Tree  with parrallization using 2 threads = "+ ((ts.getEnd1()-ts.getStart1())) +" nanoseconds");
        System.out.println("Height of the constructed Recursive Balanced Binary Tree  with parrallization using 2 threads = "+ts.getHeighty());
        System.out.println("Time elapsed in finding a specific element in constructed Recursive Balanced Binary Tree  with parrallization using 2 threads = "+ ((ts.getEnd()-ts.getStart())) +" nanoseconds");
        ts=new RecursiveBalancedBinaryTree();
        b=new PartB(m,0,1000,ts,ts.getHead());
        b.construct_withparallelization_4(m[20],0);
        System.out.println("Time elapsed in constructing Recursive Balanced Binary Tree  with parrallization using 4 threads = "+ ((ts.getEnd1()-ts.getStart1())) +" nanoseconds");
        System.out.println("Height of the constructed Recursive Balanced Binary Tree  with parrallization using 4 threads = "+ts.getHeighty());
        System.out.println("Time elapsed in finding a specific element in constructed Recursive Balanced Binary Tree  with parrallization using 4 threads = "+ ((ts.getEnd()-ts.getStart())) +" nanoseconds");
        System.out.println("Case-3 ( No. of nodes = 1000000 )");
        m=new long[1000000];
        for(i=0;i<1000000;i++){
            m[i]=rand.nextLong(2000000001)-1000000000;
        }
        ts=new RecursiveBalancedBinaryTree();
        b=new PartB(m,0,1000000,ts,ts.getHead());
        b.construct_withoutparallelization(m[20]);
        System.out.println("Time elapsed in constructing Recursive Balanced Binary Tree  without parrallization = "+ ((ts.getEnd1()-ts.getStart1())) +" nanoseconds");
        System.out.println("Height of the constructed Recursive Balanced Binary Tree  without parrallization = "+ts.getHeighty());
        System.out.println("Time elapsed in finding a specific element in constructed Recursive Balanced Binary Tree  without parrallization = "+ ((ts.getEnd()-ts.getStart())) +" nanoseconds");
        ts=new RecursiveBalancedBinaryTree();
        b=new PartB(m,0,1000000,ts,ts.getHead());
        b.construct_withparallelization_2(m[20]);
        System.out.println("Time elapsed in constructing Recursive Balanced Binary Tree  with parrallization using 2 threads = "+ ((ts.getEnd1()-ts.getStart1())) +" nanoseconds");
        System.out.println("Height of the constructed Recursive Balanced Binary Tree  with parrallization using 2 threads = "+ts.getHeighty());
        System.out.println("Time elapsed in finding a specific element in constructed Recursive Balanced Binary Tree  with parrallization using 2 threads = "+ ((ts.getEnd()-ts.getStart())) +" nanoseconds");
        ts=new RecursiveBalancedBinaryTree();
        b=new PartB(m,0,1000000,ts,ts.getHead());
        b.construct_withparallelization_4(m[20],0);
        System.out.println("Time elapsed in constructing Recursive Balanced Binary Tree  with parrallization using 4 threads = "+ ((ts.getEnd1()-ts.getStart1())) +" nanoseconds");
        System.out.println("Height of the constructed Recursive Balanced Binary Tree  with parrallization using 4 threads = "+ts.getHeighty());
        System.out.println("Time elapsed in finding a specific element in constructed Recursive Balanced Binary Tree  with parrallization using 4 threads = "+ ((ts.getEnd()-ts.getStart())) +" nanoseconds");
    }
}
