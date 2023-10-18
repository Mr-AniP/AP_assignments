package assignment3AP;

import java.util.*;

public class PartA implements Runnable{
    private miniA ob;
    private List<Student> los;
    private int k;
    private int s=0;
    public PartA(int ki,miniA o_b) {
        this.k=ki;
        this.los=o_b.getLos();
        this.ob=o_b;
    }
    @Override
    public void run() {
        int v = k;
        if (v == 0||v==1) {
            while(v<=los.size()-2) {
                if (los.get(v).getCGPA() < los.get(v + 1).getCGPA()) {
                    Student tp = los.get(v);
                    los.set(v, los.get(v + 1));
                    los.set(v + 1, tp);
                    ob.setS(0);
                }
                v+=2;
            }
        }
        else{
            while(v>=2) {
                if (los.get(v).getCGPA() > los.get(v - 1).getCGPA()) {
                    Student tp = los.get(v);
                    los.set(v, los.get(v + 1));
                    los.set(v + 1, tp);
                    ob.setS(0);
                }
                v-=2;
            }
        }
    }
    public void Oddevensort_withparallization() throws InterruptedException {
        Thread t1,t2;
        while (ob.getS()==0) {
            ob.setS(1);
            t2=new Thread(new PartA(0,ob));t2.start();
//			t1=new Thread(new PartA((ob.getLos().size()%2==1)?(ob.getLos().size()-1):(ob.getLos().size()-3),ob));t1.start();
            t1=new Thread(new PartA(1,ob));t1.start();
            t1.join();
            t2.join();
        }
    }
    public void Oddevensort_withoutparallization(){
        for(int s=0;s==0;) {
            s=1;
            int i=1;
            while(i<=(los.size()-2)){
                if(los.get(i).getCGPA()<los.get(i+1).getCGPA()) {
                    Student t=los.get(i);
                    los.set(i,los.get(i+1));
                    los.set(i+1,t);
                    s=0;
                }
                i+=2;
            }
            i=0;
            while(i<=(los.size()-2)){
                if(los.get(i).getCGPA()<los.get(i+1).getCGPA()) {
                    Student t=los.get(i);
                    los.set(i,los.get(i+1));
                    los.set(i+1,t);
                    s=0;
                }
                i+=2;
            }
        }
        ob.setLos(los);
    }
}

//	private static List<Student> Oddevensort_withoutparallization(List<Student> los){
//		for(int s=0;s==0;) {
//			s=1;
//			int i=1;
//			while(i<=(los.size()-2)){
//				if(los.get(i).getCGPA()<los.get(i+1).getCGPA()) {
//					Student t=los.get(i);
//					los.set(i,los.get(i+1));
//					los.set(i+1,t);
//					s=0;
//				}
//				i+=2;
//			}
//			i=0;
//			while(i<=(los.size()-2)){
//				if(los.get(i).getCGPA()<los.get(i+1).getCGPA()) {
//					Student t=los.get(i);
//					los.set(i,los.get(i+1));
//					los.set(i+1,t);
//					s=0;
//				}
//				i+=2;
//			}
//		}
//		return los;
//	}

//	private static List<Student> Oddevensort_withparallization(List<Student> los){
//		for(int s=0;s==0;) {
//			s=1;
//			int i=1;
//			while(i<=(los.size()-2)){
//				if(los.get(i).getCGPA()<los.get(i+1).getCGPA()) {
//					Student t=los.get(i);
//					los.set(i,los.get(i+1));
//					los.set(i+1,t);
//					s=0;
//				}
//				i+=2;
//			}
//			i=0;
//			while(i<=(los.size()-2)){
//				if(los.get(i).getCGPA()<los.get(i+1).getCGPA()) {
//					Student t=los.get(i);
//					los.set(i,los.get(i+1));
//					los.set(i+1,t);
//					s=0;
//				}
//				i+=2;
//			}
//		}
//		return los;
//	}

//	private static List<Student> Oddevensort_withparallization(List<Student> los){
////		int noofthread=(los.size()+1)/2;
//		int noofthread=2;
//		Thread []t= new Thread[noofthread];
//		int k;
//		for(int j=0;j<los.size();j++) {
//			if(j%2==0) {
//				k=0;
//				for(int i=0;i<noofthread;i+=1) {
//					t[i]=new Thread(new Runnable1(los,k));
//					t[i].start();
//					k+=2;
//				}
//				for(int i=0;i<noofthread;i+=1) {
//					try {
//						t[i].join();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			else {
//				k=1;
//				for(int i=0;i<noofthread-1;i+=1) {
//					t[i]=new Thread(new Runnable1(los,k));
//					t[i].start();
//					k+=2;
//				}
//				for(int i=0;i<noofthread-1;i+=1) {
//					try {
//						t[i].join();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//
//		}
//		return los;
//	}


