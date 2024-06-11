public class Telas {

    public void opcoesMenu() {
        System.out.println("\n-*=*_____________________________________________________________*=*-");
        System.out.println("\tUse os códigos a seguir como referência para solicitar" +
                "\n\ta conversão da moeda." +
                "\n\t\t1 - ARS = Peso Argentino \t>>> \tUYU = Peso Uruguaio" +
                "\n\t\t2 - UYU = Peso Uruguaio \t>>> \tARS = Peso Argentino" +
                "\n\t\t3 - CLP = Peso Chileno \t\t>>> \tPEN = Sol Peruano" +
                "\n\t\t4 - PEN = Sol Peruano \t\t>>> \tCLP = Peso Chileno" +
                "\n\t\t5 - COP = Peso Colombiano \t>>> \tBRL = Real Brasileiro" +
                "\n\t\t6 - BRL = Real Brasileiro \t>>> \tCOP = Peso Colombiano" +
                "\n\t\t*** Digite 0 para sair.");
        System.out.println("-*=*_____________________________________________________________*=*-");
    }

    public void imprimeResposta(ConversorMoeda moeda) {

        System.out.println("\n____________________________________________________________________");
        System.out.println("\t" + moeda.getMoedaBase() + " " + moeda.getValorAConverter() +
                " (" + moeda.nomePorExtenso(moeda.getMoedaBase()) + ") corresponde a\n\t" +
                moeda.getMoedaConverter()  + " " + moeda.getValorConvertido() +
                " (" + moeda.nomePorExtenso(moeda.getMoedaConverter()) + ")");
        System.out.println("____________________________________________________________________\n");
    }


}
