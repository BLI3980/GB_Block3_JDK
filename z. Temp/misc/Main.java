public class Main {
    public static void main(String[] args) {
//        int[][] array = fillArray(4, 5);
//        System.out.println(Arrays.deepToString(array));
//        horizontalTraverse(array);
//        verticalTraverse(array);

//        // Horizontal win situation:
//        int[][] array1 = new int[][]{{0, 2, 2, 0, 0},
//                                    { 0, 0, 0, 0, 0},
//                                    { 1, 1, 1, 1, 1},
//                                    { 0, 2, 2, 2, 0}};
//        horizontalTraverse(array1);
//        System.out.println(horizontalWinSituation(array1, 4, 1));
//        System.out.println(horizontalWinSituation(array1, 4, 1, 2));
//        System.out.println();
//
//        // Vertical win situation:
//        int[][] array2 = new int[][]{{0, 0, 2, 0, 0},
//                                    { 0, 0, 2, 0, 0},
//                                    { 1, 1, 2, 1, 0},
//                                    { 1, 1, 2, 1, 0},
//                                    { 1, 1, 2, 1, 0},
//                                    { 0, 2, 2, 0, 2}};
//        verticalTraverse(array2);
//        System.out.println(verticalWinSituation(array2, 4, 2));
//        System.out.println(verticalWinSituation(array2, 4, 1, 2));



    }

    public static int[][] fillArray(int fieldSizeX, int fieldSizeY) {
        int[][] array = new int[fieldSizeX][fieldSizeY];
        int count = 1;
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                array[i][j] = count;
                count++;
            }
        }
        return array;
    }

    public static void horizontalTraverse(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("\t" + array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void verticalTraverse(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print("\t" + array[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean horizontalWinSituation(int[][] array, int winLen, int X) {
        int countX = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length - 1; j++) {
                if (array[i][j] == X && array[i][j+1] == X) {
                    countX++;
                }
                if (countX == winLen) return true;
            }
            countX = 1;
        }
        return false;
    }

    public static String horizontalWinSituation(int[][] array, int winLen, int X, int Y) {
        int countX = 1; int countY = 1;
        String xWin = "Player 1 has won!";
        String yWin = "Player 2 has won!";
        String noWin = "No win situation";

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length - 1; j++) {
                if (array[i][j] == X && array[i][j+1] == X) {
                    countX++;
                } else if (array[i][j] == Y && array[i][j+1] == Y) {
                    countY++;
                }
                if (countX == winLen) return xWin;
                if (countY == winLen) return yWin;
            }
            countX = 1;
            countY = 1;
        }
        return noWin;
    }

    public static boolean verticalWinSituation(int[][] array, int winLen, int X) {
        int rows = array.length;
        int cols = array[0].length;
        int countX = 1;


        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows - 1; j++) {
                if (array[j][i] == X && array[j+1][i] == X) {
                    countX++;
                }
                if (countX == winLen) return true;
            }
            countX = 1;
        }
        return false;
    }

    public static String verticalWinSituation(int[][] array, int winLen, int X, int Y) {
        int rows = array.length;
        int cols = array[0].length;
        int countX = 1; int countY = 1;
        String xWin = "Player 1 has won!";
        String yWin = "Player 2 has won!";
        String noWin = "No win situation";


        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows - 1; j++) {
                if (array[j][i] == X && array[j+1][i] == X) {
                    countX++;
                } else if (array[j][i] == Y && array[j+1][i] == Y) {
                    countY++;
                }
                if (countX == winLen) return xWin;
                if (countY == winLen) return yWin;
            }
            countX = 1;
            countY = 1;
        }
        return noWin;
    }

    public static int byteShift(int value) {
        return value >>1;
    }
}
