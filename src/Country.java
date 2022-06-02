/**
 *
 * Country.java
 * @version 1.4
 * created 01/06/2022
 * last modified 02/06/2022
 * @author tjmcauley
 * Copyrighted
 */

import java.util.ArrayList;

/**
 *
 * Class that models a Country
 */

public class Country {

    //Text that's used for the toString method
    public final String COUNTRY_POPULATION_MESSAGE = ": total population: ";
    public final String POP_NOT_IN_CITIES_MESSAGE = ", population outside listed cities: ";
    public final String LISTED_CITIES_MESSAGE = ", with cities\n";

    private String countryName;
    private int countryPopulation;
    private int popNotInCities;
    private ArrayList<City> cities = new ArrayList<>();

    /**
     *
     * Constructs a country object
     *
     * @param countryName the name of the country
     * @param population the population of the country
     */
    public Country(String countryName, int population) {
        if (population < 0) {
            population = 0;
        }
        setCountryName(countryName);
        setCountryPopulation(population);
    }

    /**
     *
     * Method that allows a country object to store references to its cities
     *
     * @param cityName the name of the city
     * @param population the population of the city
     * @param timeZone the time zone of the country
     */
    public void addCity(String cityName, int population, int timeZone) {
        if (!isLegalData()) {
            population = 0;
        }
        City city = new City(cityName, population, timeZone);
        this.cities.add(city);
        this.popNotInCities = calcPopNotInCities(this.countryPopulation, this.cities);
    }

    /**
     *
     * Method to search for a specific city within a country object
     *
     * @param cityName the name of the city
     * @return a city object
     */
    public City getCityByName(String cityName) {
        for (City elem: cities) {
            if (elem.getCityName().equals(cityName)) {
                return elem;
            }
        }
        return null;
    }

    /**
     *
     * Method to delete a city from a country
     *
     * @param cityName the name of a city
     * @return true if the city was deleted, false otherwise
     */
    public boolean deleteCity(String cityName) {
        for (City elem: cities) {
            if (elem.getCityName().equals(cityName)) {
                cities.remove(elem);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * Method that determines if attributes of a country are legal
     *
     * @return true if attributes of a country are legal, false otherwise
     */
    public boolean isLegalData() {
        if (this.getCountryPopulation() > 0) {
            return true;
        }
        return false;
    }

    /**
     *
     * Method that sets the name of a country
     *
     * @param countryName the name of a country
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     *
     * Method that retrieves the name of the country
     *
     * @return the name of the country
     */
    public String getCountryName() {
        return this.countryName;
    }

    /**
     *
     * Method that sets the population of the country
     *
     * @param population the population of the country
     */
    public void setCountryPopulation(int population) {
        this.countryPopulation = population;
    }

    /**
     *
     * Method that returns the population of the country
     *
     * @return the population of the country
     */
    public int getCountryPopulation() {
        return this.countryPopulation;
    }

    /**
     *
     * Method that calculates the population of the country outside the cities provided
     *
     * @param countryPopulation the population of the country
     * @param cities the cities within the country
     * @return the population of the country outside the cities provided
     */
    private int calcPopNotInCities(int countryPopulation, ArrayList<City> cities) {
        int totalPopOfCites = 0;
        for (City elem: cities) {
            totalPopOfCites += elem.getCityPopulation();
        }
        int totalPopNotInCities = countryPopulation - totalPopOfCites;
        return totalPopNotInCities;
    }

    /**
     *
     * Method that retrieves the population of the country outside the cities provided
     *
     * @return the population of the country outside the cities provided
     */
    public int getPopNotInCities() {
        return this.popNotInCities;
    }

    /**
     *
     * Method to format country objects in a nice way
     *
     * @return nicely formatted country object
     */
    public String toString() {
        String buildDisplay = getCountryName() + COUNTRY_POPULATION_MESSAGE + getCountryPopulation()
                + POP_NOT_IN_CITIES_MESSAGE + getPopNotInCities() + LISTED_CITIES_MESSAGE;
        for (City elem: this.cities) {
            buildDisplay += elem + "\n";
        }
        return buildDisplay;
    }
}
