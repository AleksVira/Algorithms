public class LinearProbingHashTable<Key, Value> {
    private int M = 3;
    private int size = 0;
    private Object[] keys = new Object[M];
    private Object[] values = new Object[M];

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }


    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может равняться Null");
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (((Key) keys[i]).equals(key)) {
                return (Value) values[i];
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может равняться Null");
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (((Key) keys[i]).equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;

        if (size == M) {
            dynamicResize();
        }
    }

    private void dynamicResize() {
        int oldM = M;
        M = nextPrimeNumber(M * 2);
        Object[] tmpKeys = new Object[M];
        Object[] tmpValues = new Object[M];
//        int tmpSize = 0;
        for (int i = 0; i < oldM; i++) {
//            if (keys[i] == null) {
//                continue;
//            }
            int newHash = hash((Key) keys[i]);
            tmpKeys[newHash] = keys[i];
            tmpValues[newHash] = values[i];
//            tmpSize++;
        }
        keys = tmpKeys;
        values = tmpValues;
//        size = tmpSize;
    }

    private int nextPrimeNumber(int n) {
        while (!isPrime(++n)) {
        }
        return n;
    }

    private boolean isPrime(int testNumber) {
        for (int i = 2; i < testNumber; i++)
            if (testNumber % i == 0)
                return false;
        return true;
    }

}
