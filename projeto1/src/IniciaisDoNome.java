import java.util.Scanner;

public class IniciaisDoNome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome completo: ");
        String nomeCompleto = scanner.nextLine();

        String iniciais = obterIniciais(nomeCompleto);

        System.out.println("As iniciais do nome são: " + iniciais);
    }

    // Método para obter as iniciais do nome
    public static String obterIniciais(String nomeCompleto) {
        String[] partesDoNome = nomeCompleto.split(" ");
        StringBuilder iniciais = new StringBuilder();

        for (String parte : partesDoNome) {
            if (!parte.isEmpty()) {
                iniciais.append(parte.charAt(0)).append(".");
            }
        }

        return iniciais.toString();
    }
}