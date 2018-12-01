public class Sorter {
    private MyArray result;


    public MyArray selectionSort(MyArray source) {
        result = source;
        for (int i = 0; i < result.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < result.size(); j++) {
                if (result.get(j) < result.get(minIndex)) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
        return result;
    }

    public MyArray insertionSort(MyArray source) {
        result = source;
        for (int i = 0; i < result.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (result.get(j) < result.get(j - 1)) {
                    swap(j, j - 1);
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public MyArray bubbleSort(MyArray source) {
        result = source;
        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = 0; j < result.size() - i - 1; j++) {
                if (result.get(j) > result.get(j + 1)) {
                    swap(j, j + 1);
                }
            }
        }
        return result;
    }

    private void swap(int i, int j) {
        int tmp = result.get(i);
        result.set(i, result.get(j));
        result.set(j, tmp);
    }
}

