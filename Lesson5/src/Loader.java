public class Loader {
    static int simpleMethodCounter = 0;
    static int fastMethodCounter = 0;


    public static void main(String[] args) {

        double startTime = System.nanoTime();
        System.out.println(exp(7, 107));
        double stopTime = System.nanoTime();
        System.out.println("Time = " + (stopTime - startTime) / 1000000000 + "\n");

        startTime = System.nanoTime();
        System.out.println(expRec(7, 107));
        stopTime = System.nanoTime();
        System.out.println("Time = " + (stopTime - startTime) / 1000000000);
        System.out.println("Simple recursion method calls: " + simpleMethodCounter  + "\n");

        startTime = System.nanoTime();
        System.out.println(expFastRec(7, 107));
        stopTime = System.nanoTime();
        System.out.println("Time = " + (stopTime - startTime) / 1000000000);
        System.out.println("Fast recursion method calls: " + fastMethodCounter);
    }

    private static long exp(int multiplier, int degree) {
        long result = multiplier;
        if (multiplier == 0) {
            return 0;
        } else if (multiplier == 1) {
            return 1;
        }
        if (degree == 0) {
            return 1;
        } else {
            for (int i = 1; i < degree; i++) {
                result *= multiplier;
            }
        }
        return result;
    }

    private static long expRec(int multiplier, int degree) {
        simpleMethodCounter++;
//        System.out.println("Simple degree = " + degree);
        if (degree == 0) {
            return 1;
        } else if (degree == 1) {
            return multiplier;
        } else return expRec(multiplier, degree - 1) * multiplier;
    }


    private static long expFastRec(int multiplier, int degree) {
        fastMethodCounter++;
//        System.out.println("Fast degree = " + degree);
        if (degree == 0) {
            return 1;
        } else if (degree == 1) {
            return multiplier;
        }
        if (degree % 2 == 0) {
            long tmp = expFastRec(multiplier, degree / 2);
            return tmp * tmp;
        } else {
            long tmp = expFastRec(multiplier, degree - 1);
            return multiplier * tmp;
        }
    }
}
