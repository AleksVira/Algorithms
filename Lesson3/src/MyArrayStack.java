import java.util.NoSuchElementException;

public class MyArrayStack<Item> {
    private Object[] stack = new Object[1];
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = stack[i];
        }
        stack = tmp;
    }

    public void push(Item item) {
        if (size == stack.length) {
            resize(2 * stack.length);
        }
        stack[size++] = item;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = (Item) stack[size - 1];
        stack[size - 1] = null;
        size--;
        if (size > 0 && size == stack.length / 4) {
            resize(stack.length / 2);
//            resize(size * 2);
        }
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (Item) stack[size - 1];
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("< ");
        for (int i = 0; i < size; i++) {
            sb.append(stack[i]).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(" >");
        return sb.toString();
    }
}
