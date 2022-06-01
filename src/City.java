public class City {

    public final String CITY_POPULATION_MESSAGE = ": has population ";
    public final String CITY_TIME_ZONE_MESSAGE = " and is in time zone ";
    public final String IS_MEGACITY_MESSAGE = " It IS a megacity ";
    public final String IS_NOT_MEGACITY_MESSAGE = " It IS NOT a megacity ";

    private String cityName;
    private int cityPopulation;
    private int timeZone;
    private boolean isMegacity;

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

    public int timeDifference(City city) {
        int timeDifference = this.getTimeZone() - city.getTimeZone();
        return timeDifference;
    }

    public boolean isLegalData() {
        if (this.getCityPopulation() > 0 && (this.getTimeZone() >= -12 && this.getTimeZone() <= 11)) {
            return true;
        }
        return false;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityPopulation(int population) {
        this.cityPopulation = population;
    }

    public int getCityPopulation() {
        return this.cityPopulation;
    }

    public void setTimeZone(int timeZone) {
        this.timeZone = timeZone;
    }

    public int getTimeZone() {
        return this.timeZone;
    }

    public void setMegacity(int population) {
        if (population >= 10000000) {
            this.isMegacity = true;
        }
        this.isMegacity = false;
    }

    public boolean getMegacity() {
        return this.isMegacity;
    }

    public String toString() {
        String buildDisplay = getCityName() + CITY_POPULATION_MESSAGE + getCityPopulation() + CITY_TIME_ZONE_MESSAGE + getTimeZone();
        if (getMegacity()) {
            buildDisplay += IS_MEGACITY_MESSAGE;
        } else {
            buildDisplay += IS_NOT_MEGACITY_MESSAGE;
        }
        return buildDisplay;
    }
}
