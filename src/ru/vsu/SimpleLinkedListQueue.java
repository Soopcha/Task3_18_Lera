package ru.vsu;

public class SimpleLinkedListQueue<T> implements SimpleQueue<T> {

    private class SimpleLinkedListNode {
        public T value;
        public SimpleLinkedListNode next;

        public SimpleLinkedListNode(T value, SimpleLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(T value) {
            this(value, null);
        }

    }

    private SimpleLinkedListNode head = null;
    private SimpleLinkedListNode tail = null;
    private int count = 0;


    @Override
    public void add(T value) {
        if (count == 0) {
            head = tail = new SimpleLinkedListNode(value);
        } else {
            tail.next = new SimpleLinkedListNode(value);
            tail = tail.next;
        }
        count++;
    }

    @Override
    public T remove() throws Exception {
        T result = element();
        head = head.next;
        if (count == 1) {
            tail = null;
        }
        count--;
        return result;
    }

    @Override
    public T element() throws Exception {
        if (count() == 0) {
            throw new Exception("Queue is empty");
        }
        return head.value;
    }

    @Override
    public int count() {
        return count;
    }


}
