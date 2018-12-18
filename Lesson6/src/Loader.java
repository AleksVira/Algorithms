public class Loader {
    public static void main(String[] args) {
        BinarySearchTree<Character, Integer> bst = new BinarySearchTree<>();

//        int[] testArray = new int[]{50, 25, 75, 12, 37, 6, 18, 3, 2, 4, 8, 9, 15, 22, 14, 23, 31, 43, 34, 27, 40, 46, 39, 28, 62, 87, 68,
//                56, 53, 59, 65, 71, 60, 81, 93, 76, 84, 82, 90, 96, 92, 98, 95, 5};
//        int[] testArray = new int[]{50, 25, 75};
//        int counter = 0;
//        final int treesQuantity = 1;
        final int treesQuantity = 2000000;
        int balancedTreesCounter = 0;
        for (int i = 0; i < treesQuantity; i++) {
            BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
//            while (counter < testArray.length) {
            while (tree.height() < 6) {
//                Integer newKey = testArray[counter];
//                counter++;
                Integer newKey = (int) (Math.random() * 200);
//                Integer newKey = (int) (Math.random() * 200) - 100;
                Integer newVal = newKey * newKey;
                System.out.println("New Node = " + newKey + " :: " + newVal);
                tree.put(newKey, newVal);
//                System.out.println("Tree height = " + tree.height());
//                System.out.println(tree.isBalanced());
            }
            if (tree.isBalanced()) {
                balancedTreesCounter++;
                System.out.println("Tree is balanced");
            } else {
                System.out.println("Tree is NOT balanced");
            }
            System.out.println("---------------------------");
        }
        System.out.println("The percentage of NOT balanced trees is equal to " + (100.0 - 100.0 * balancedTreesCounter / treesQuantity) + ", " + balancedTreesCounter + " at all.");
    }
}
