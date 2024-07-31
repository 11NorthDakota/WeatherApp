package by.northdakota.Weather;

import by.northdakota.Cities.City;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WeatherParser {
    /*Document doc = Jsoup.connect(URL)
            .userAgent(USER_AGENT)
            .get();

    Elements data = doc.selectXpath("//*[@id=\"content_left\"]/div[4]/div[3]/ul/li");
        for(Element element:data){
        var time = element
                .select("a")
                .attr("aria-label");
        System.out.println(time);
        System.out.println("/////////////////////////////////////////////////////////////////////////");
    }*/
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0)" +
            "AppleWebKit/537.36 " +
            "(KHTML, like Gecko)" +
            "Chrome/124.0.0.0 " +
            "Safari/537.36";

    private static Document doc;

    public void createConnection(String URL) throws IOException {
        doc = Jsoup.connect(URL)
                .userAgent(USER_AGENT)
                .get();
    }

    public void doParse() {
        Elements data = doc.selectXpath("//*[@id=\"content_left\"]/div[4]/div[3]/ul/li");
        for (Element element : data) {
            var time = element
                    .select("a")
                    .attr("aria-label");
            System.out.println(time);
        }
    }
}
