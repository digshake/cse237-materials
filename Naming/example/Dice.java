public class Dice {

    public static void main(String[] args) {
        int d = 4;
        int r = 7;

        int[][] array = new int[r][d];
        int[] f = new int[d * 6  - d];

        int s = 0;
        int yaht = 0;
        for(int i = 0; i < d; i++) {
            System.out.print("Roll: ");
            for(int j = 0; j < r; j++) {
                int d2 = (int)(Math.random() * 7);
                array[i][j] = d2;
                s += d2;
                System.out.print(d + " ");
            }
            System.out.println(" Sum: " + s);

            for(int j = 0; j < d; j++) {
                if(array[i][j] == array[i][j+1]) {
                    yaht++;
                }
            }
            f[s]++;
        }
        System.out.println("There were " + yaht + " yahtzees");

        for(int i = 0; i < f.length; i++) {
            System.out.println("Sum: " + i + " times: " + f[i]);
        }

    }

}