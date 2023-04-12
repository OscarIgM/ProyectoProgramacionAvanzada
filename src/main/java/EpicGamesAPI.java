import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class EpicGamesAPI {
    public static void main(String[] args) {
      /*  String url = "https://api.rawg.io/api/games?key=f0aa1af8a7a14edd81a1640d274584cb";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ListaJuegos gameList = restTemplate.getForObject(url, ListaJuegos.class, entity);

        System.out.println(gameList);*/
        Controlador controlador = new Controlador();
       // Vista vista = new Vista(controlador);
    }
}