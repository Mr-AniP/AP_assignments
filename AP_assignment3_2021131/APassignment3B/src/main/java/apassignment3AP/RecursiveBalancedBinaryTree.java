package apassignment3AP;

public class RecursiveBalancedBinaryTree {
    private long start1;
    private long end1;
    private int heighty;
    private long start;
    private RBBTnode head=null;
    private long end;
    private RBBTnode result=null;
    private boolean ty=true;
    public boolean isTy() {
        return ty;
    }
    public void setTy(boolean ty) {
        this.ty = ty;
    }
    public RBBTnode getHead() {return head;}
    public void setHead(RBBTnode head) {this.head = head;}
    public RBBTnode getResult() {return result;}
    public void setResult(RBBTnode result) {this.result = result;}
    public int getHeighty() {
        return heighty;
    }
    public void setHeighty(int heighty) {
        this.heighty = heighty;
    }
    public long getStart1() {return start1;}
    public void setStart1(long start1) {this.start1 = start1;}
    public long getEnd1() {return end1;}
    public void setEnd1(long end1) {this.end1 = end1;}
    public long getEnd() {
        return end;
    }
    public void setEnd(long end) {
        this.end = end;
    }
    public long getStart() {
        return start;
    }
    public void setStart(long start) {
        this.start = start;
    }
    private RBBTnode LLrotation(RBBTnode n){
        RBBTnode newnode = n.left;
        n.left = newnode.right;
        newnode.right = n;
        set_height(n);
        set_height(newnode);
        return newnode;

    }
    private RBBTnode RRrotation(RBBTnode n){
        RBBTnode newnode = n.right;
        n.right = newnode.left;
        newnode.left = n;
        set_height(n);
        set_height(newnode);
        return newnode;
    }
    private RBBTnode LRrotation(RBBTnode n){
        RBBTnode mid = n.left;
        RBBTnode newnode = mid.right;
        mid.right = newnode.left;
        n.left = newnode.right;
        newnode.left = mid;
        newnode.right = n;
        set_height(n);
        set_height(mid);
        set_height(newnode);
        return newnode;
    }
    private RBBTnode RLrotation(RBBTnode n){
        RBBTnode mid = n.right;
        RBBTnode newnode = mid.left;
        mid.left = newnode.right;
        n.right = newnode.left;
        newnode.left = n;
        newnode.right = mid;
        set_height(n);
        set_height(mid);
        set_height(newnode);
        return newnode;
    }
    private int get_balance(RBBTnode root){
        int l = (root.left!=null) ? root.left.height : 0;
        int r = (root.right!=null) ? root.right.height : 0;
        return l - r;
    }
    private void set_height(RBBTnode n){
        int l = (n.left!=null) ? n.left.height : 0;
        int r = (n.right!=null) ? n.right.height : 0;
        n.height = (l > r) ? l + 1: r + 1;
    }
    private RBBTnode rotate( RBBTnode n) {
        int b = get_balance(n);
        if (b > 1) {
            b = get_balance(n.left);
            if (b < 0)
                n = LRrotation(n);
            else
                n = LLrotation(n);
        }
        else if (b < -1) {
            b = get_balance(n.right);
            if (b > 0)
                n = RLrotation(n);
            else
                n = RRrotation(n);
        }
        return n;
    }
    public RBBTnode insert(RBBTnode root, long val) {
        if (root == null) {
            root = new RBBTnode(val);
            set_height(root);
            return root;
        }
        else {
//            if(val>=root.val)
//                root.right = insert(root.right, val);
//            else
            root.left = insert(root.left, val);
            RBBTnode newroot;
            set_height(root);
            newroot = rotate(root);
            return newroot;
        }
    }
    public RBBTnode insert(RBBTnode root, RBBTnode li,RBBTnode ri) {
        RBBTnode n;
        root.left = li;
        root.right= ri;
        set_height(root);
        n = rotate(root);
        return n;
    }
    public void findme(long v,RBBTnode hi) {
        if(hi==null || !this.isTy())
            return;
        if(hi.val==v){
            this.setResult(hi);
            this.setTy(false);
            return;
        }
        if(hi.left!=null)
            this.findme(v,hi.left);
        if(hi.right!=null)
            this.findme(v,hi.right);
    }
//    public void printtree(RBBTnode t){
//        if(t!=null){
//        System.out.print(t.height+" ");
//        printtree(t.left);
//        printtree(t.right);
//        }
//    }
//    public void myfunction(RBBTnode t){
//        if(t.left!=null){
//            myfunction(t.left);
//            if(t.right!=null)
//                myfunction(t.right);
//        }
//        set_height(t);
//    }
}
