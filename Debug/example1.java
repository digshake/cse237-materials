public class example1 {

    public static void main(String[] args) {
        Object o = makeAThing();

        printThis(o);
    }

    private static Object makeAThing() {
        Object o = new Object();
        System.out.println(o);

        return null;
    }

    private static void printThis(Object o) {
        System.out.println(o.toString());
    }

}