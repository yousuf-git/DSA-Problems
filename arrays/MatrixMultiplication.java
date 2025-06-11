class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] matrix1 = {
                { 2, 3, 1 },
                { 3, 2, 1 }
            };
        int[][] matrix2 = {
                { 2, 3 },
                { 3, 2 },
                { 4, 2 }
            };

        int[][] res = multiply(matrix1, matrix2);
        if (res == null) {
            System.out.println("Multiplication not possible for order: " + matrix1.length + "-by-" + matrix1[0].length
                    + " and " + matrix2.length + "-by-" + matrix2[0].length);

        } else
            for (int[] row : res) {
                for (int e : row) {
                    System.out.print(e + " ");
                }
                System.out.println();
            }
    }

    private static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        // if column of matrix1 is not equal to row of matrix2, multiplication is not possible
        if (matrix1[0].length != matrix2.length) {
            return null;
        }
        // result matrix will have rows of matrix1 and columns of matrix2
        // e.g. 2-by-3 and 3-by-2 will result in 2-by-2
        // e.g. 2-by-3 and 3-by-4 will result in 2-by-4
        // e.g. 3-by-2 and 2-by-3 will result in 3-by-3

        int[][] res = new int[matrix1.length][matrix2[0].length];

        for (int row = 0; row < matrix1.length; row++) {              // choose the f*cking base row from matrix1

            for (int col = 0; col < matrix2[0].length; col++) {       // repeat for each col in matrix2

                int currSum = 0;

                for (int ptr = 0; ptr < matrix2.length; ptr++) {      // move row wise in matrix2

                    currSum += matrix1[row][ptr] * matrix2[ptr][col];

                }
                res[row][col] = currSum;
            }
        }
        return res;
    }
}