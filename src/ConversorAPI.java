import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorAPI {
   
    public void converter(ListaConversoes listaConversoes, String consultaMoeda, String moedaBase, double valorAConverter) {
        String apiKey = "8e2606c4e1a019065a981b27";
        String endereco =  "https://v6.exchangerate-api.com/v6/8e2606c4e1a019065a981b27/latest/USD" + consultaMoeda + "/" + moedaBase + "/" + valorAConverter;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            MoedasParaConverter moedasParaConverter = new Gson().fromJson(json, MoedasParaConverter.class);

            // Assumindo que o JSON tenha um formato semelhante a {"conversion_rates": {"USD": 1.0, "BRL": 5.25, ...}}
            double taxaDeCambio = moedasParaConverter.getConversionRates().get(consultaMoeda);
            double valorConvertido = valorAConverter * taxaDeCambio;

            ConversorMoeda moeda = new ConversorMoeda(consultaMoeda, moedaBase, valorAConverter, valorConvertido);

            Telas tela = new Telas();
            tela.imprimeResposta(moeda);

            listaConversoes.adicionarConversao(moeda);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro com o endereço da busca!");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


class MoedasParaConverter {
    private Map<String, Double> conversion_rates;

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }
}


class ConversorMoeda {
    private String consultaMoeda;
    private String moedaBase;
    private double valorAConverter;
    private double valorConvertido;

    public ConversorMoeda(String consultaMoeda, String moedaBase, double valorAConverter, double valorConvertido) {
        this.consultaMoeda = consultaMoeda;
        this.moedaBase = moedaBase;
        this.valorAConverter = valorAConverter;
        this.valorConvertido = valorConvertido;
    }

}


class Telas {
    public void imprimeResposta(ConversorMoeda moeda) {
        System.out.println("Valor convertido: " + moeda.getValorConvertido());
    }
}


class ListaConversoes {
    private List<ConversorMoeda> conversoes = new ArrayList<>();

    public void adicionarConversao(ConversorMoeda conversao) {
        conversoes.add(conversao);
    }

}
