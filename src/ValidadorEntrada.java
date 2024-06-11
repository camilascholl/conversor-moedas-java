import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidadorEntrada {

    // Método para ler um inteiro do usuário
    // Método para ler um inteiro do usuário
    static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine(); // Limpa o buffer de entrada
            }
        }
    }
}
