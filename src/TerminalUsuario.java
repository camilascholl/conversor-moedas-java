import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TerminalUsuario {

    public void solicitaDados() throws IOException, InterruptedException {
        int menu = -1;
        String consultaMoeda = "";
        String moedaBase = "";
        double valorAConverter = -1;
        ListaConversoes listaConversoes = new ListaConversoes();
        Telas tela = new Telas();
        tela.opcoesMenu();

        Scanner leitura = new Scanner(System.in);

        while (menu != 0) {
            menu = ValidadorEntrada.lerInteiro(leitura, "\nDigite o código da conversão: ");

            if (menu == 0) {
                List<ConversorMoeda> conversoes = listaConversoes.getListaConversoes();
                System.out.println(conversoes);
                System.exit(0);
            }
            switch (menu) {
                case 1:
                    consultaMoeda = "ARS";
                    moedaBase = "UYU";
                    break;
                case 2:
                    consultaMoeda = "UYU";
                    moedaBase = "ARS";
                    break;
                case 3:
                    consultaMoeda = "CLP";
                    moedaBase = "PEN";
                    break;
                case 4:
                    consultaMoeda = "PEN";
                    moedaBase = "CLP";
                    break;
                case 5:
                    consultaMoeda = "COP";
                    moedaBase = "BRL";
                    break;
                case 6:
                    consultaMoeda = "BRL";
                    moedaBase = "COP";
                    break;
                default:
                    System.out.println("\nCódigo inválido.\n");
                    continue;
            }

            while (true) {
                System.out.print("Digite o valor a ser convertido: ");
                try {
                    valorAConverter = leitura.nextDouble();
                    break; // Sai do loop se o valor for válido
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido. Por favor, digite um número decimal.");
                    leitura.nextLine(); // Limpa o buffer de entrada
                }
            }

            ConversorAPI conversorAPI = new ConversorAPI();
            conversorAPI.converter(listaConversoes, consultaMoeda, moedaBase, valorAConverter);
            tela.opcoesMenu();
        }


    }
}