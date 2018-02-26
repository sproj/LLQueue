package sll;

public class LLQueue implements Queue {

    private SLinkedList list;

    public LLQueue() {
        this.list = new SLinkedList();
    }

    public void enqueue(Object o) {
        if(!this.isFull()) {
            this.list.insertNext(o);
        }
    }

    public Object dequeue() {
        Object o = null;
        if(this.list.gotoHead()) {
            o = this.list.head;
            this.list.deleteHead();
        }
        return o;
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public boolean isFull() {
        return false;
    }

    public Object front() {
        Object o = null;
        if(!this.list.isEmpty()) {
            o = this.list.head;
        }
        return o;
    }
}
