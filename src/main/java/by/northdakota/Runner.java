package by.northdakota;

import by.northdakota.Cities.CitiesParser;
import by.northdakota.Cities.City;
import by.northdakota.Weather.WeatherParser;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Runner {
    private static final String URL_CITIES = "https://alextyurin.ru/2014/04/" +
            "%D0%B3%D0%B5%D0%BE%D0%B3%D1%80%D0%B0%D1%84%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B5-" +
            "%D0%BA%D0%BE%D0%BE%D1%80%D0%B4%D0%B8%D0%BD%D0%B0%D1%82%D1%8B-" +
            "%D0%BE%D1%81%D0%BD%D0%BE%D0%B2%D0%BD%D1%8B%D1%85/";
    public static void main(String[] args) throws IOException {

        CitiesParser citiesParser = new CitiesParser();

        citiesParser.createConnection(URL_CITIES);
        citiesParser.doParse();
        var cityList = citiesParser.getCityList();

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите нужный город");
        var answer = sc.nextLine();
        var city = getCityByName(answer,cityList);

        WeatherParser weatherParser = new WeatherParser();

        assert city != null;
        weatherParser.createConnection("https://yandex.ru/pogoda?lat=" + city.getLatitude() +
                "&lon=" + city.getLongitude());

        weatherParser.doParse();

    }
    public static City getCityByName(String name,List<City> cityList){
        for(City city:cityList){
            if(name.equalsIgnoreCase(city.getCityName())){
                return city;
            }
        }
        return null;
    }
}
