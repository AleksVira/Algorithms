import java.util.Arrays;

public class Loader {
    private final static double NANO_DIVIDER = 1000000000.0;
    private final static int TRY_NUMBERS = 100;
    private final static int ARRAY_SIZE = 50_000;

    public static void main(String[] args) {

        Sorter sorter = new Sorter();

        double startTime;
        double finishTime;
        double selectionSortTime = 0;
        double insertionSortTime = 0;
        double bubbleSortTime = 0;
        MyArray firstArray;
        MyArray secondArray;
        MyArray thirdArray;

        for (int i = 0; i < TRY_NUMBERS; i++) {
            firstArray = new MyArray(ARRAY_SIZE);
            initArray(firstArray);
            secondArray = firstArray.arrayCopy();
            thirdArray = firstArray.arrayCopy();

            startTime = System.nanoTime();
            sorter.selectionSort(firstArray);
            finishTime = (System.nanoTime() - startTime) / NANO_DIVIDER;
            selectionSortTime += finishTime;

            startTime = System.nanoTime();
            sorter.insertionSort(secondArray);
            finishTime = (System.nanoTime() - startTime) / NANO_DIVIDER;
            insertionSortTime += finishTime;

            startTime = System.nanoTime();
//            System.out.println(sorter.bubbleSort(thirdArray));
            sorter.bubbleSort(thirdArray);
            finishTime = (System.nanoTime() - startTime) / NANO_DIVIDER;
            bubbleSortTime += finishTime;
        }

        System.out.println("Array size: " + ARRAY_SIZE);
        System.out.println("Average time for selection sort: " + selectionSortTime / TRY_NUMBERS);
        System.out.println("Average time for insertion sort: " + insertionSortTime / TRY_NUMBERS);
        System.out.println("Average time for bubble sort: " + bubbleSortTime / TRY_NUMBERS);


    }


    private static void initArray(MyArray testArray) {
        for (int i = 0; i < testArray.size(); i++) {
            testArray.set(i, (int) (100000 * Math.random()));
        }
//        System.out.println("Array size: " + testArray.size());
//        System.out.println(testArray.toString());
    }
}
