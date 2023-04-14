package Scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ScrapJuegos {
    private final Map<String, String> items = new HashMap<>();
protected static final String WEBSITE = "https://www.g2a.com/es/top-list/pc-games?banner=topbar";//ingresar a la url

     public ScrapJuegos() {
obtenerElementos(conexionPagina());
    }


public Document conexionPagina(){
    Document document;
try {
    document= Jsoup.connect(WEBSITE).get();
    return document;
}catch (IOException ignored) {
    System.out.println("No hay conexion");
    return null;
}
    }
    public void obtenerElementos(Document document) {

        Elements elements = document.getElementsByClass("indexes__Body-h6zdws-4 indexes__StyledBody2-h6zdws-61 kqyZuB iJPNT");
        for (Element element : elements) {//link videojuego
            String link = "https://www.g2a.com" + Objects.requireNonNull(element.select("a").first()).attr("href");
            items.put(link, "video");

        }
        System.out.println(items);

    }

}









