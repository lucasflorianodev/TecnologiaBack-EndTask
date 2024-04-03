import java.util.Random;
import java.util.Scanner;

public class Adivinhacao {
    public static void main(String[] args) {
        Random random = new Random();
        int numeroSorteado = random.nextInt(1001); // Sorteia um número entre 0 e 1000
        int tentativas = 0;

        Scanner scanner = new Scanner(System.in);
        int palpite;

        System.out.println("Bem-vindo ao jogo de adivinhação!");
        System.out.println("Tente adivinhar o número entre 0 e 1000.");

        do {
            System.out.print("Digite seu palpite: ");
            palpite = scanner.nextInt();
            tentativas++;

            if (palpite < numeroSorteado) {
                System.out.println("O número sorteado é maior.");
            } else if (palpite > numeroSorteado) {
                System.out.println("O número sorteado é menor.");
            }
        } while (palpite != numeroSorteado);

        System.out.println("Parabéns! Você acertou o número " + numeroSorteado + " em " + tentativas + " tentativas.");
    }
}