package DSA_Problems.arrays;

public class Array {
    public static void printArray(int[] array) {
        if (array.length == 0) {
            return;
        }

        // this will display the array in the format [1, 2, 3, 4, 5]
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "]");
    }
}
