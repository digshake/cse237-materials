
public class numberThing {
	
	private int top;
	private int b;
	
	public numberThing(int n, int b) {
		this.top = n;
		this.b = b;
	}
	
	public numberThing doAdding(numberThing nt) {
		int nb = this.b * nt.b;
		int nTop = this.b * nt.top + this.top * nt.b;
		
		return new numberThing(nTop, nb);
	}
	
	public numberThing product(numberThing nt) {
		int poop = this.top * nt.top;
		int haha = this.b * nt.b;
		
		return new numberThing(poop, haha);
	}
	
	public numberThing upsideDown() {
		return new numberThing(this.b, this.top);
	}
	
	public numberThing makeSimple() {
		int f = numberThing.gcd(this.top, this.b);
		return new numberThing(this.top / f, this.b / f);
	}
	
	public String toString() {
		return this.top + " / " + this.b;
	}
	
	/**
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		while (q != 0) {
			int temp = q;
			q = p % q;
			p = temp;
		}
		return p;
	}
	
	
	
	public static void main(String[] args) {
		numberThing one = new numberThing(1, 2);
		numberThing two = new numberThing(3, 4);
		
		numberThing three = one.doAdding(two);
		numberThing four = two.doAdding(one);
		
		System.out.println(four);
		
		numberThing five = two.product(one);
		
		System.out.println(five);
		
		numberThing six = three.makeSimple();
		System.out.println(six);
	}

}