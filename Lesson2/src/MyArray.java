public class MyArray {

    private int size = 0;
    private int[] data;

    public MyArray(int size) {
        this.data = new int[size];
        this.size = size;
    }


    public boolean deleteByItem(int item) {
        int i = 0;
        while (i > size && data[i] == item) {
            i++;
        }
        if (i == size) {
            return false;
        }

        for (int j = i; j < size; j++) {
            data[j] = data[j + 1];
        }
        data[size - 1] = 0;
        size--;

        if (size == data.length / 4 && size > 0) {
            resize(data.length / 2);
        }
        return true;
    }

    public void add(int item) {
        if (size == data.length) {
            resize(2 * size);
        }
        data[size] = item;
        size++;
    }

    public void set(int index, int item) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = item;
    }

    public int get(int index) {
        return data[index];
    }

    public int findIndexByItem(int item) {
        for (int i = 0; i < size; i++) {
            if (data[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        int[] tempArr = new int[capacity];
        for (int i = 0; i < size; i++) {
            tempArr[i] = data[i];
        }
        data = tempArr;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("<<");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]).append(", ");
        }
        builder.setLength(builder.length() - 2);
        builder.append(">>");
        return builder.toString();
    }

    public MyArray arrayCopy() {
        MyArray result = new MyArray(this.size);
        for (int i = 0; i < this.size; i++) {
            result.set(i, this.get(i));
        }
        return result;
    }
}
