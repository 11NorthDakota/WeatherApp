package by.northdakota.Cities;

public class City {
    private String cityName;
    private String country;
    private String latitude;
    private String longitude;

    public City(String cityName, String latitude, String longitude) {
        this.cityName = cityName;
        this.country = "Россия";
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    @Override
    public String toString() {
        return "Город " + cityName + "\nШирота:" + latitude + " Долгота:" + longitude + "\nCтрана " + country;
    }
}
