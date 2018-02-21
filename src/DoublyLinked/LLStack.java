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
        temp = new LNode(o, null, null);
    }
}
