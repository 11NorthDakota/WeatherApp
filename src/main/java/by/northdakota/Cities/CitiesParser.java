package by.northdakota.Cities;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CitiesParser {
    private static List<City> cityList = new ArrayList<>();
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0)" +
            "AppleWebKit/537.36 " +
            "(KHTML, like Gecko)" +
            "Chrome/124.0.0.0 " +
            "Safari/537.36";

    private static Document doc;

    public void createConnection(String URL) throws IOException{
        doc = Jsoup.connect(URL)
                .userAgent(USER_AGENT)
                .get();
    }
    public void doParse(){
        Elements cities = doc.selectXpath("/html/body/div/main/article/div/div[1]/table/tbody/tr");
        for(var city:cities){
            Elements data = city.select("td");
            String cityName = data.get(0).text();
            var lat = data.get(1).text();
            var lon = data.get(2).text();
            cityList.add(new City(cityName,lat,lon));
        }
    }
    public List<City> getCityList(){
        return cityList;
    }

}
