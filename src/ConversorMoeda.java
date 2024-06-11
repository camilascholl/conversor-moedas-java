public class ConversorMoeda {
    private String moedaBase;
    private String moedaConverter;
    private Double precoMoeda;
    private Double valorConvertido;
    private Double valorAConverter;

    public ConversorMoeda(String moedaBase, String moedaConverter, Double precoMoeda, Double valorAConverter) {
        this.moedaBase = moedaBase;
        this.moedaConverter = moedaConverter;
        this.precoMoeda = precoMoeda;
        this.valorAConverter = valorAConverter;
        this.valorConvertido = valorAConverter * precoMoeda;
    }

    public void setValorAConverter(Double valorAConverter) {
        this.valorAConverter = valorAConverter;
        this.valorConvertido = valorAConverter * this.precoMoeda;
    }

    public Double getValorAConverter() {
        return valorAConverter;
    }

    public String getMoedaBase() {
        return moedaBase;
    }

    public String getMoedaConverter() {
        return moedaConverter;
    }

    public Double getValorConvertido() {
        return valorConvertido;
    }

    public String nomePorExtenso(String nome) {
        String nomePorExtenso = nome;

        switch (nome) {
            case "ARS":
                nomePorExtenso = "Peso Argentino";
                break;
            case "UYU":
                nomePorExtenso = "Peso Uruguaio";
                break;
            case "CLP":
                nomePorExtenso = "Peso Chileno";
                break;
            case "PEN":
                nomePorExtenso = "Sol Peruano";
                break;
            case "COP":
                nomePorExtenso = "Peso Colombiano";
                break;
            case "BRL":
                nomePorExtenso = "Real Brasileiro";
                break;
        }
        return nomePorExtenso;
    }

    @Override
    public String toString() {
        return "\n::::: " +
                "\n\tValor a converter: " + valorAConverter +
                "\n\tMoeda Base: " + nomePorExtenso(moedaBase) +
                ", \n\tMoeda para Converter: " + nomePorExtenso(moedaConverter) +
                ", \n\tValor Convertido: " + valorConvertido +
                "\n::::: \n";
    }
}
