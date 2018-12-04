import java.util.NoSuchElementException;

public class MyDequeArray<Item> {
    private Object[] deque = new Object[2];
    private int size = 0;
    private int start = 0;
    private int end = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = deque[(start + i) % deque.length];
        }
        deque = tmp;
        start = 0;
        end = size;
    }


    public void insertLeft(Item item) {
        if (size == deque.length) {
            resize(2 * deque.length);
        }
        start = (start + deque.length - 1) % deque.length;
        deque[start] = item;
        size++;
    }

    public void insertRight(Item item) {
        if (size == deque.length) {
            resize(2 * deque.length);
        }
        deque[end++] = item;
        end %= deque.length;
        size++;
    }

    public Item removeLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = (Item) deque[start];
        deque[start] = null;
        size--;
        start++;
        start %= deque.length;
        if (size > 0 && size == deque.length / 4) {
            resize(deque.length / 2);
        }
        return item;
    }

    public Item removeRight() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int point = (end + deque.length - 1) %deque.length;
        Item item = (Item) deque[point];
        deque[point] = null;
        size--;
        end = point;
        if (size > 0 && size == deque.length / 4) {
            resize(deque.length / 2);
        }
        return item;
    }

    public Item peekLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (Item) deque[start];
    }

    public Item peekRight() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int point = (end - 1 + deque.length) % deque.length;
        return (Item) deque[point];
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("< ");
        for (int i = 0; i < size; i++) {
            sb.append(deque[(start + i) % deque.length]).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(" >");
        return sb.toString();
    }

}
