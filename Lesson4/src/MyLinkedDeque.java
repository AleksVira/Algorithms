public class MyLinkedDeque<Item> {
    private MyLinkedList<Item> deque = new MyLinkedList<>();

    public int size() {
        return deque.size();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public void insertLeft(Item item) {
        deque.insertFirst(item);
    }

    public void insertRight(Item item) {
        deque.insertLast(item);
    }

    public Item removeLeft() {
        return deque.deleteFirst();
    }

    public Item removeRight() {
        return deque.deleteLast();
    }

    public Item peekLeft() {
        return deque.getFirst();
    }

    public Item peekRight() {
        return deque.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < deque.size(); i++) {
            sb.append(deque.get(i)).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
