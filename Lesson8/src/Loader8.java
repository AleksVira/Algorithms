public class Loader8 {
    public static void main(String[] args) {
        ChainingHashTable<Character, Integer> chainingHashTable = new ChainingHashTable<>();
        chainingHashTable.put('A', 10);
        chainingHashTable.put('B', 11);
        chainingHashTable.put('C', 12);
        chainingHashTable.put('D', 13);
        chainingHashTable.put('E', 14);
        chainingHashTable.put('F', 15);
        chainingHashTable.put('G', 16);
        chainingHashTable.put('H', 17);
        chainingHashTable.put('J', 18);
        chainingHashTable.put('K', 19);

        LinearProbingHashTable<Character, Integer> hashTable = new LinearProbingHashTable<>();
        hashTable.put('A', 10);
        hashTable.put('B', 11);
        hashTable.put('C', 12);
        hashTable.put('D', 13);
        hashTable.put('E', 14);
        hashTable.put('F', 15);
        hashTable.put('G', 16);
        hashTable.put('H', 17);
        hashTable.put('J', 18);
        hashTable.put('S', 19);
        hashTable.put('A', 100);

        System.out.println(hashTable.get('A'));
        System.out.println(hashTable.get('S'));
    }
}
