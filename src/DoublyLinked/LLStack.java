package DoublyLinked;

public class LLStack {
    LNode top, temp;
    public void LLStack() {
        clearStack();
    }
    public void clearStack() {
        top = temp = null;
    }
    public void push(Object o) {
        temp = new LNode(o, top);
        top = temp;
    }
    public Object pop() {
        if(top != null) {
            Object o = top.getValue();
            top = top.getNext();
            return o;
        }
        return null;
    }
}
