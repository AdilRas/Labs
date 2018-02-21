package DoublyLinked;

public class LNode {
    LNode next, previous;
    Object value;
    public LNode(Object value, LNode next) {
        this.next = next;
        this.previous = previous;
        this.value = value;
    }

    public LNode getNext() {
        return next;
    }

    public void setNext(LNode next) {
        this.next = next;
    }

    public LNode getPrevious() {
        return previous;
    }

    public void setPrevious(LNode previous) {
        this.previous = previous;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
