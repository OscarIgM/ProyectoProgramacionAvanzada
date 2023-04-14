import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ListaJuegos {

    private int cuenta;
    private ListaJuegos[] results;



    public ListaJuegos[] getResults() {
        return results;
    }

    public void setResults(ListaJuegos[] results) {
        this.results = results;
    }
}
