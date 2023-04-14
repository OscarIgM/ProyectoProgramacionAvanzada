import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ScrapEpicGames {

    private Map<String, String> items;

    public static void main(String[] args) {
        new ScrapEpicGames().escanearJuegos();
    }
    public ScrapEpicGames() {
        items = new HashMap<>();
        escanearJuegos();
    }

    protected static final String WEBSITE = "https://www.g2a.com/es/top-list/pc-games?banner=topbar";//ingresar a la url

public void escanearJuegos(){
    Document document;
try {
    document= Jsoup.connect(WEBSITE).get();
}catch (IOException ignored) {
    System.out.println("No hay conexion");
    return;
}
    Elements elements=document.getElementsByClass("indexes__Media-h6zdws-9 indexes__StyledMedia3-h6zdws-65 bwAgok fWrwgL");
    System.out.println(elements);
    for (Element element : elements) {

    }


    }
    
}







}
