class Ting {
    public static void main(String[] args) {
        List l = new List(10);
        l.displayList();
        l.deleteNode(6);
        l.displayList();
        l.deleteNode(90);
        l.insertNode(90);
        l.displayList();
    }
}
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int value, ListNode n) {
        next = n;
        val = value;
    }
    public void setNext(ListNode n) {
        next = n;
    }
    public void setVal(int n) {
        val = n;
    }
    public ListNode getNext() {
        return next;
    }
    public int getValue() {
        return val;
    }
}

class List {
    ListNode front;
    int size;

    public List(int n) {
        size = n;
        ListNode temp, p;
        front = new ListNode(1, null);
        temp = front;
        for (int k = 2; k <= size; k++) {
            p = new ListNode(k, null);
            temp.setNext(p);
            temp = p;
        }
    }
    public void deleteNode(int key) {
        ListNode temp1 = front, temp2 = null;
        boolean exists = false;
        while(temp1 != null && !exists) {
            exists = temp1.getValue() == key;
            if(!exists) {
                temp2 = temp1;
                temp1 = temp1.getNext();
            }
        }
        if(exists) {
            temp2.setNext(temp1.getNext());
        } else {
            System.out.println("Node not found");
        }
    }
    public void insertNode(int val) {
        ListNode p = null, t1 = null, t2 = null;
        p = new ListNode(val, null);
        if(front == null) front = p;
        else {
            if(p.getValue() < front.getValue()) {
                p.setNext(front);
                front = p;
            } else {
                t1 = front;
                while(t1!=null && p.getValue() > t1.getValue()) {
                    t2 = t1;
                    t1 = t1.getNext();
                }
                t2.setNext(p);
                p.setNext(t1);
            }
        }
    }
    public void insNode(int key) {
        ListNode p = new ListNode(key, null), t1 = null, t2 = null;
        if(front == null) {
            front = p;
        } else {
            if(p.getValue() < front.getValue()) {
                p.setNext(front);
                front = p;
            } else {
                t1 = front;
                while(t1 != null && p.getValue() > t1.getValue()) {
                    t2 = t1;
                    t1 = t1.getNext();
                }
            }
        }
    }
    public void displayList() {
        System.out.println(
                "\nDisplay of linked list elements\n");
        ListNode p = front;
        while (p != null) {
            System.out.print(p.getValue() + "   ");
            p = p.getNext();
        }
        System.out.println();
    }
}