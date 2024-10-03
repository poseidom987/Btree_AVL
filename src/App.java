public class App {
    public static void main(String[] args) throws Exception {
        Btree a = new Btree();

        a.add(42);
        a.add(51);
        a.add(19);
        a.add(37);
        a.add(42);
        a.add(86);
        a.add(71);
        a.add(10);
        a.add(75);
        a.add(22);
        a.add(31);
        a.add(42);

        a.show();

        System.out.println("-----");
        System.out.println(a.size());
        System.out.println("-----");
        System.out.println(a.soma());

    }
}
