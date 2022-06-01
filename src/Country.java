public class Country {

    private String countryName;
    private int population;

    public Country(String countryName, int population) {

    }

    public void addCity(String cityName, int population, int timeZone) {

    }

    public String toString() {
        return "" + countryName + "total population: " + population + ", population outside listed cities: " + popNotInCities + ", with cities\n"
    }
}
