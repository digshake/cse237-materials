
public class example3 {

    public static void main(String[] args) {
        int[] myArray = makeArray(100);

        boolean everythingIsOK = true;
        int i = 0;
        while (i < myArray.length && everythingIsOK) {
            everythingIsOK = processElementAtIndex(myArray, i);
            i++;
        }

        if (!everythingIsOK) {
            throw new RuntimeException(
                    "Found a bad value...see console for more information.");
        }
    }

    /*
        Pretend that we don't have direct access to this code - it is
        in an external library
     */
    private static boolean processElementAtIndex(int[] array, int index)
    {
        if(array[index] == 0) {
            System.out.println("Bad value at index: " + index);
            return false;
        } else {
            return true;
        }
    }

    /*
    Pretend that we don't have direct access to this code - it is
    in an external library
    */
    private static int[] makeArray(int length) {
        int[] theArray = new int[100];

        for(int i = 0; i < length; i++) {
            theArray[i] = (int)(Math.random() * 10 + 1);
        }
        theArray[(int)(Math.random() * length)] = 0;
        return theArray;
    }

}