package apassignment3AP;

public class Threadclassmine implements Runnable {
    private final RBBTnode head;
    private  final long val;
    private RecursiveBalancedBinaryTree ts;

    public Threadclassmine(RBBTnode h,long vali,RecursiveBalancedBinaryTree ti){
        this.head=h;
        this.val=vali;
        this.ts=ti;
    }
    @Override
    public void run() {
        ts.findme(val,head);
    }
}
