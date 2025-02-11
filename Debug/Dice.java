public class Dice {

    public static void main(String[] args) {
        int dice = 4;
        int rolls = 7;

        int[][] allDice = new int[rolls][dice];
        int[] frequency = new int[dice * 6  - dice];

        int sum = 0;
        int yahtzee = 0;
        for(int i = 0; i < dice; i++) {
            System.out.print("Roll: ");
            for(int j = 0; j < rolls; j++) {
                int die = (int)(Math.random() * 7);
                allDice[i][j] = die;
                sum += die;
                System.out.print(die + " ");
            }
            System.out.println(" Sum: " + sum);

            for(int j = 0; j < dice; j++) {
                if(allDice[i][j] == allDice[i][j+1]) {
                    yahtzee++;
                }
            }
            frequency[sum]++;
        }
        System.out.println("There were " + yahtzee + " yahtzees");

        for(int i = 0; i < frequency.length; i++) {
            System.out.println("Sum: " + i + " times: " + frequency[i]);
        }

    }

}