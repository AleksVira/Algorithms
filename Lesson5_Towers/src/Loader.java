public class Loader {

    private final static int N = 5;         // количество дисков
    private static int[][] towerCells = new int[N][3];
    private static int diskMoveCounter = 0;

    public static void main(String[] args) {

        initTower();
        showTower();
        columnMove(N, 1, 3);
        System.out.println("Выполнено ходов: " + diskMoveCounter);
    }

    private static void columnMove(int n, int source, int dest) {
        if (n == 1) {
            diskMove(source, dest);
            return;
        }
        columnMove(n - 1, source, 6 - source - dest);
        diskMove(source, dest);
        columnMove(n - 1, 6 - source - dest, dest);
    }

    private static void diskMove(int source, int dest) {
        int from = source - 1;
        int to = dest - 1;
        int i = N - 1;
        while (i >= 0) {
            if (towerCells[i][from] > 0) {
                towerCells[i][to] = towerCells[i][from];
                towerCells[i][from] = 0;
                diskMoveCounter++;
                showTower();
                break;
            }
            i--;
        }
    }

    private static void showTower() {
        StringBuilder[] columns = new StringBuilder[3];
        int maxColumnHeight = 0;
        for (int j = 0; j < 3; j++) {
            columns[j] = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (towerCells[i][j] > 0) {
                    columns[j].append(towerCells[i][j]);
                }
            }
            if (columns[j].length() > maxColumnHeight) {
                maxColumnHeight = columns[j].length();
            }
        }
        if (maxColumnHeight > 0) {
            for (int i = 0; i < 3; i++) {
                columns[i].setLength(maxColumnHeight);
            }
            for (int k = maxColumnHeight - 1; k >= 0; k--) {
                StringBuilder outString = new StringBuilder();
                for (int j = 0; j < 3; j++) {
                    String a = String.valueOf(columns[j].charAt(k));
                    if (columns[j].charAt(k) == 0) {
                        outString.append("   ");
                    } else {
                        outString.append(columns[j].charAt(k)).append("  ");
                    }
                }
                System.out.println(outString.toString());
            }
        }
        System.out.println("_  _  _\n");
    }

    private static void initTower() {
        for (int i = 0; i < N; i++) {
            towerCells[i][0] = N - i;
        }
    }

}
