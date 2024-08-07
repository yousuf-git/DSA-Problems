package DSA_Problems.arrays;

class Min_Max {

    static class Pair {
        int min;
        int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }

    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 9, -1 };
        Pair pair = findPair(array);
        System.out.println("Min: " + pair.min);
        System.out.println("Max: " + pair.max);

    }

    public static Pair findPair(int[] array) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i]);
        }
        return new Pair(min, max);

    }
}