/**
 *
 * City.java
 * @version 1.4
 * created 01/06/2022
 * last modified 02/06/2022
 * @author tjmcauley
 * Copyrighted
 */

/**
 *
 * Class that models a city
 */
public class City {

    //Text that's used for the toString method
    public final String CITY_POPULATION_MESSAGE = ": has population ";
    public final String CITY_TIME_ZONE_MESSAGE = " and is in time zone ";
    public final String IS_MEGACITY_MESSAGE = " It IS a megacity ";
    public final String IS_NOT_MEGACITY_MESSAGE = " It IS NOT a megacity ";

    private String cityName;
    private int cityPopulation;
    private int timeZone;
    private boolean isMegacity;

    /**
     *
     * Constructs a city object
     *
     * @param cityName the name of a city
     * @param population the population of the city
     * @param timeZone the time zone of the city
     */
    public City(String cityName, int population, int timeZone) {
        if (population <= 0) {
            population = 0;
        }
        if (timeZone < -12 || timeZone > 11) {
            timeZone = 0;
        }
        setCityName(cityName);
        setCityPopulation(population);
        setTimeZone(timeZone);
        setMegacity(population);
    }

    /**
     *
     * Method that calculates the time difference between two given cities
     *
     * @param city the city you want to compare with
     * @return the time difference between the two cities
     */
    public int timeDifference(City city) {
        int timeDifference = this.getTimeZone() - city.getTimeZone();
        return timeDifference;
    }

    /**
     *
     * Method that determines if attributes of a city are legal
     *
     * @return true if attributes of a city are legal, false otherwise
     */
    public boolean isLegalData() {
        if (this.getCityPopulation() > 0 && (this.getTimeZone() >= -12 && this.getTimeZone() <= 11)) {
            return true;
        }
        return false;
    }

    /**
     *
     * Method that sets the name of a city
     *
     * @param cityName the name of the city
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     *
     * Method that retrieves the name of the city
     *
     * @return the name of the city
     */
    public String getCityName() {
        return this.cityName;
    }

    /**
     *
     * Method that sets the population of the city
     *
     * @param population the population of the city
     */
    public void setCityPopulation(int population) {
        this.cityPopulation = population;
    }

    /**
     *
     * Method that retrieves the population of the city
     *
     * @return the population of the city
     */
    public int getCityPopulation() {
        return this.cityPopulation;
    }

    /**
     *
     * Method that sets the time zone of the city
     *
     * @param timeZone the time zone of the city
     */
    public void setTimeZone(int timeZone) {
        this.timeZone = timeZone;
    }

    /**
     *
     * Method that retrieves the time zone of the city
     *
     * @return the time zone of the city
     */
    public int getTimeZone() {
        return this.timeZone;
    }

    /**
     *
     * Method that sets if the city is considered a mega-city
     *
     * @param population the population of the city
     */
    public void setMegacity(int population) {
        if (population >= 10000000) {
            this.isMegacity = true;
        } else {
            this.isMegacity = false;
        }
    }

    /**
     *
     * Method that retrieves if the city is a mega-city or not
     *
     * @return true if city is a mega-city, false otherwise
     */
    public boolean getMegacity() {
        return this.isMegacity;
    }

    /**
     *
     * Method to format country objects in a nice way
     *
     * @return nicely formatted country object
     */
    public String toString() {
        String buildDisplay = getCityName() + CITY_POPULATION_MESSAGE + getCityPopulation() + CITY_TIME_ZONE_MESSAGE + getTimeZone();
        if (this.getMegacity()) {
            buildDisplay += IS_MEGACITY_MESSAGE;
        } else {
            buildDisplay += IS_NOT_MEGACITY_MESSAGE;
        }
        return buildDisplay;
    }
}
