package Scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ScrapEpicGames {

    private Map<String, String> items;
    protected static final String WEBSITE = "https://store.steampowered.com/charts/topselling/global";//ingresar a la url

    public static void main(String[] args) {
        new ScrapEpicGames().escanearJuegos();
    }
    public ScrapEpicGames() {
        items = new HashMap<>();
        escanearJuegos();
    }


public void escanearJuegos(){
    Document document;
try {
    document= Jsoup.connect(WEBSITE).get();
}catch (IOException ignored) {
    System.out.println("No hay conexion");
    return;
}
    Elements elements=document.getElementsByClass("weeklytopsellers_TableRow_2-RN6");
 /* for (Element element : elements) {//link videojuego
       String link ="https://www.g2a.com"+element.select("a").first().attr("href");
        System.out.println(link);

    }
*/

    }
    
}








