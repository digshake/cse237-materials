public class Cat {
    private boolean isHungry;
    private String name;

    public Cat(String name) {
        this.name = name;
        this.isHungry = false;
    }

    public void play() {
        this.isHungry = true;
    }

    public void eat() {
        this.isHungry = false;
    }

    public String toString() {
        String result = this.name;
        if (this.isHungry) {
            return result + " is hungry!";
        } else {
            return result + " is not hungry!";
        }
    }

    public static void main(String[] args) {
        Cat franklin = new Cat("Franklin");
        franklin.play();
        System.out.println(franklin);
        franklin.eat();
        franklin.eat();
        System.out.println(franklin);
        franklin.play();
    }

}