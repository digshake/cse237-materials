public class example2 {
    public static void main(String[] args) {
        //make a big array
        int[] array = new int[100000];

        processElementAtIndex(array, 0);

        processElementAtIndex(array, 100000 / 2);

        processElementAtIndex(array, 100000);
    }

    private static void processElementAtIndex(int[] array, int index)
    {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException("Out of bounds!");
        }

        //nothing to do, really just an example
    }
}