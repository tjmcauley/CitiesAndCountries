/**
 *
 * Main.java
 * @version 1.4
 * created 01/06/2022
 * last modified 02/06/2022
 * @author tjmcauley
 * Copyrighted
 */

/**
 *
 * Class to test the City and Country classes
 */
public class Main {

    /**
     *
     * Main method to test hte functionality of the City and Country Classes
     *
     * @param args arguments
     */
    public static void main(String args[]) {

        //Level 1 tests
        Country argentina = new Country("Argentina", 45605800);
        argentina.addCity("Buenos Aires", 13588200, -3);
        argentina.addCity("Cordoba", 1454650, -3);
        argentina.addCity("Rosario", 1236000, -3);
        argentina.addCity("Mendoza", 937200, -3);
        argentina.addCity("La Plata", 794300, -3);

        Country usa = new Country("USA", 331449300);
        usa.addCity("New York", 20140470, -5);
        usa.addCity("Dallas", 7637390, -6);
        usa.addCity("Phoenix", 4845800, -7);
        usa.addCity("Los Angeles", 13201000, -8);

        Country russia = new Country("Russia", 146171000);
        russia.addCity("Moscow", 12506500, 3);
        russia.addCity("Vladivostok", 60500, 10);
        russia.addCity("Yekaterinburg", 1350000, 5);
        russia.addCity("Novosibirsk", 143750, 7);

        System.out.println(argentina);
        System.out.println(usa);
        System.out.println(russia);

        //Level 2 tests
        System.out.println(argentina.getCityByName("Cordoba").timeDifference(russia.getCityByName("Novosibirsk")));
        System.out.println(usa.getCityByName("Phoenix").timeDifference(argentina.getCityByName("Buenos Aires")));

        //Level 3 tests
        System.out.println(usa.deleteCity("New York"));
        System.out.println(argentina.deleteCity("Rosario"));
        System.out.println(russia.deleteCity("Vladivostok"));

        System.out.println(usa);
        System.out.println(argentina);
        System.out.println(russia);

        System.out.println(usa.deleteCity("Boston"));
        System.out.println(russia.deleteCity("St Petersburg"));

        Country gulliver = new Country("Gulliver's World", 0);
        gulliver.addCity("Lilliput", 0, 0);
        gulliver.addCity("Brobdingnag", 0, 0);

        System.out.println(gulliver);
    }
}
