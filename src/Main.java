public class Main {

    public static void main(String args[]) {
        Country argentina = new Country("Argentina", -898);
        argentina.addCity("Buenos Aires", -6, 99);
        argentina.addCity("Cordoba", 1454650, -3);
        argentina.addCity("Rosario", 1236000, -3);

        System.out.println(argentina);
    }
}
