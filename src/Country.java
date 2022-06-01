import java.util.ArrayList;

public class Country {

    public final String COUNTRY_POPULATION_MESSAGE = ": total population: ";
    public final String POP_NOT_IN_CITIES_MESSAGE = ", population outside listed cities: ";
    public final String LISTED_CITIES_MESSAGE = ", with cities\n";

    private String countryName;
    private int countryPopulation;
    private int popNotInCities;
    private static ArrayList<City> cities = new ArrayList<>();

    public Country(String countryName, int population) {
        if (population <= 0) {
            population = 0;
        }
        setCountryName(countryName);
        setCountryPopulation(population);
    }

    public void addCity(String cityName, int population, int timeZone) {
        if (population > this.getCountryPopulation()) {
            population = 0;
        }
        City city = new City(cityName, population, timeZone);
        this.cities.add(city);
        this.popNotInCities = calcPopNotInCities(this.countryPopulation, this.cities);
    }

    public City getCityByName(String cityName) {
        for (City elem: cities) {
            if (elem.getCityName().equals(cityName)) {
                return elem;
            }
        }
        return null;
    }

    public boolean deleteCity(String cityName) {
        for (City elem: cities) {
            if (elem.getCityName().equals(cityName)) {
                cities.remove(elem);
                return true;
            }
        }
        return false;
    }

    public boolean isLegalData() {
        if (this.getCountryPopulation() > 0) {
            return true;
        }
        return false;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryPopulation(int population) {
        this.countryPopulation = population;
    }

    public int getCountryPopulation() {
        return this.countryPopulation;
    }

    private int calcPopNotInCities(int countryPopulation, ArrayList<City> cities) {
        int totalPopOfCites = 0;
        for (City elem: cities) {
            totalPopOfCites += elem.getCityPopulation();
        }
        int totalPopNotInCities = countryPopulation - totalPopOfCites;
        return totalPopNotInCities;
    }

    public int getPopNotInCities() {
        return this.popNotInCities;
    }

    public String toString() {
        String buildDisplay = getCountryName() + COUNTRY_POPULATION_MESSAGE + getCountryPopulation()
                + POP_NOT_IN_CITIES_MESSAGE + getPopNotInCities() + LISTED_CITIES_MESSAGE;
        for (City elem: this.cities) {
            buildDisplay += elem + "\n";
        }
        return buildDisplay;
    }
}
