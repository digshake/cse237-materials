
import java.util.Scanner;

public class GamblersRuin {

public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the start amount: ");
		int s = in.nextInt();
		
		System.out.println("Please enter the win chance: ");
		double w = in.nextDouble();
		
		System.out.println("Please enter the win amount: ");
		int w2 = in.nextInt();
		
		System.out.println("Please enter the number of days: ");
		int d = in.nextInt();
		int r = 0;
		
		for(int i=0; i < d; i++) {
			int p = 0;
			int p2 = s;
			while (w2 > p2 && p2 > 0 ) {
				p++;
				double w3 = Math.random();
				if(w3 < w) { //win
					p2++;
				} else {
					p2--;
				}
			}
			boolean f = p2 == 0;
			if(f) {
				r++;
			}
			System.out.println("Day " + i + ": " + p + " plays, Ruin? " + f);
		}
		double rr = ((double)r) / d;
		System.out.println("Simulated rate: " + rr);
		//expected:
		
		if(w == .5) {
			double e = 1 - (((double)s) / w2);
			System.out.println("Expected: " + e);
		} else {
			double alpha = (1 - w) / w;
			double e = (Math.pow(alpha, s) - Math.pow(alpha, w2)) / (1 - Math.pow(alpha, w2));
			System.out.println("Expected: " + e);
		}
	}
}