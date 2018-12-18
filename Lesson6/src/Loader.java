public class Loader {
    public static void main(String[] args) {
        BinarySearchTree<Character, Integer> bst = new BinarySearchTree<>();

//        int[] testArray = new int[]{-53, 90, 48, -47, 31, 0, 36, -56, 66, -67, -75, -70, -48, -5};
//        int counter = 0;
//        final int treesQuantity = 1;
        final int treesQuantity = 2000000;
        int balancedTreesCounter = 0;
        for (int i = 0; i < treesQuantity; i++) {
            BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
            while (tree.height() < 6) {
//                Integer newKey = testArray[counter];
//                counter++;
                Integer newKey = (int) (Math.random() * 200) - 100;
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
        System.out.println("The percentage of NOT balanced trees is equal to " + (100.0 - 100.0 * balancedTreesCounter / treesQuantity));
    }
}
