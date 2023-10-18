package apassignment3AP;

public class PartB implements Runnable{
    private RBBTnode head;
    private RBBTnode tli1=null,tli2=null;
    private final long []arr;
    private final int l;
    private final int h;
    private final RecursiveBalancedBinaryTree ts;
    public PartB(long []ar,int k,int y,RecursiveBalancedBinaryTree ti,RBBTnode root){
        this.arr=ar;
        this.l=k;
        this.ts=ti;
        this.h=y;
        this.head=root;
    }
    public void construct_withoutparallelization(long valu){
        ts.setStart1(System.nanoTime());
        for(int i=l;i<h;i++){
            head=ts.insert(head,arr[i]);
        }
        ts.setHead(head);
        ts.setEnd1(System.nanoTime());
        ts.setHeighty(head.height);
        ts.setStart(System.nanoTime());
        ts.findme(valu,head);
        ts.setEnd(System.nanoTime());
    }
    public void construct_withparallelization_2(long valu) throws InterruptedException {
        RecursiveBalancedBinaryTree ts1=new RecursiveBalancedBinaryTree();
        RecursiveBalancedBinaryTree ts2=new RecursiveBalancedBinaryTree();
        PartB right=new PartB(arr,(1+(h/2)),h,ts2,ts2.getHead());
        PartB left=new PartB(arr,1,(1+(h/2)),ts1,ts1.getHead());
        ts.setStart1(System.nanoTime());
        Thread t1=new Thread(left);t1.start();
        Thread t2=new Thread(right);t2.start();
        t1.join();
        t2.join();
        head=ts.insert(head,arr[0]);
        head=ts.insert(head,ts1.getHead(),ts2.getHead());
        ts.setHead(head);
        ts.setEnd1(System.nanoTime());
        ts.setHeighty(head.height);
        ts.setStart(System.nanoTime());
        if(head.val==valu)ts.setResult(head);
        else{
            t1=new Thread(new Threadclassmine(ts1.getHead(),valu,ts));t1.start();
            t2=new Thread(new Threadclassmine(ts2.getHead(),valu,ts));t2.start();
            t1.join();
            t2.join();
        }
        ts.setEnd(System.nanoTime());
    }
    public void construct_withparallelization_4(long valu,int m) throws InterruptedException {
        RecursiveBalancedBinaryTree ts1=new RecursiveBalancedBinaryTree();
        RecursiveBalancedBinaryTree ts2=new RecursiveBalancedBinaryTree();
        RecursiveBalancedBinaryTree ts3=new RecursiveBalancedBinaryTree();
        RecursiveBalancedBinaryTree ts4=new RecursiveBalancedBinaryTree();
        PartB rightleft=new PartB(arr,(3+((h-2)/2)),(3+(3*(h-2)/4)),ts3,ts3.getHead());
        PartB leftleft=new PartB(arr,3,(3+((h-2)/4)),ts1,ts1.getHead());
        PartB leftright=new PartB(arr,(3+((h-2)/4)),(3+((h-2)/2)),ts2,ts2.getHead());
        PartB rightright=new PartB(arr,(3+(3*(h-2)/4)),h,ts4,ts4.getHead());
        ts.setStart1(System.nanoTime());
        Thread t1=new Thread(leftleft);t1.start();
        Thread t2=new Thread(leftright);t2.start();
        Thread t3=new Thread(rightleft);t3.start();
        Thread t4=new Thread(rightright);t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        head=ts.insert(head,arr[0]);
        tli1=ts.insert(tli1,arr[1]);
        tli2=ts.insert(tli2,arr[2]);
        tli1=ts.insert(tli1,ts1.getHead(),ts2.getHead());
        tli2=ts.insert(tli2,ts3.getHead(),ts4.getHead());
        head=ts.insert(head,tli1,tli2);
        ts.setEnd1(System.nanoTime());
        ts.setHead(head);
        ts.setHeighty(head.height);
        ts.setStart(System.nanoTime());
        if(head.val==valu)ts.setResult(head);
        else{
            if(tli1.val==valu)ts.setResult(tli1);
            else{
                if(tli2.val==valu)ts.setResult(tli2);
                else{
                    t1=new Thread(new Threadclassmine(ts1.getHead(),valu,ts));t1.start();
                    t2=new Thread(new Threadclassmine(ts2.getHead(),valu,ts));t2.start();
                    t3=new Thread(new Threadclassmine(ts3.getHead(),valu,ts));t3.start();
                    t4=new Thread(new Threadclassmine(ts4.getHead(),valu,ts));t4.start();
                    t1.join();
                    t2.join();
                    t3.join();
                    t4.join();
                }
            }
        }
        ts.setEnd(System.nanoTime());
    }
    @Override
    public void run() {

        for(int i=l;i<h;i++){
            head=ts.insert(head,arr[i]);
        }
        ts.setHead(head);
    }
}