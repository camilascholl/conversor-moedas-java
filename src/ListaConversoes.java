import java.util.ArrayList;
import java.util.List;

public class ListaConversoes {
    private List<ConversorMoeda> listaConversoes = new ArrayList<>();

    public void adicionarConversao(ConversorMoeda moeda) {
        listaConversoes.add(moeda);
    }

    public List<ConversorMoeda> getListaConversoes() {
        return listaConversoes;
    }
}
