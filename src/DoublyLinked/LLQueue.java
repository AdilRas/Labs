package DoublyLinked;

public class LLQueue {
    LNode front, back, temp;
    public LLQueue() {
        clearQueue();
    }
    public void clearQueue() {
        front = back = temp;
    }
    public void enqueue(Object item) {
        temp = new LNode(item, null);
        if(front == null) {
            front = back = temp;
        } else {
            back.setNext(temp);
            back = temp;
        }
    }
    public Object dequeue() {
        if(front == null) return null;
        else {
            Object qItem = front.getValue();
            front = front.getNext();
            return qItem;
        }
    }
    public Object peek() {
        return front == null ? null:front.getValue();
    }
    public boolean emptyQueue() {
        return front==null;
    }
}
