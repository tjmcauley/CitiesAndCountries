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
        setCityName(cityName);
        setCityPopulation(population);
        setTimeZone(timeZone);
        setMegacity(population);
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
        if (this.getCityPopulation() >= 10000000) {
            buildDisplay += IS_MEGACITY_MESSAGE;
        } else {
            buildDisplay += IS_NOT_MEGACITY_MESSAGE;
        }
        return buildDisplay;
    }
}
