import java.util.Arrays;
import java.util.Scanner;

public class OrganizarLetras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String palavra = scanner.next();

        int[] valoresLetras = obterValoresLetras(palavra);
        int[] valoresOrdenados = valoresLetras.clone();
        Arrays.sort(valoresOrdenados);

        System.out.println("Array: " + Arrays.toString(valoresLetras));
        System.out.println("Array ordenado: " + Arrays.toString(valoresOrdenados));

        String palavraOrdenada = organizarPalavra(palavra, valoresLetras, valoresOrdenados);
        System.out.println("Saída: " + palavraOrdenada);
    }

    // Método para obter os valores das letras da palavra
    public static int[] obterValoresLetras(String palavra) {
        int[] valores = new int[palavra.length()];
        for (int i = 0; i < palavra.length(); i++) {
            valores[i] = palavra.charAt(i) - 'a' + 1;
        }
        return valores;
    }

    // Método para organizar a palavra de acordo com os valores das letras
    public static String organizarPalavra(String palavra, int[] valoresLetras, int[] valoresOrdenados) {
        StringBuilder palavraOrdenada = new StringBuilder();
        for (int i = 0; i < valoresOrdenados.length; i++) {
            int index = indexOf(valoresLetras, valoresOrdenados[i]);
            palavraOrdenada.append(palavra.charAt(index));
        }
        return palavraOrdenada.toString();
    }

    // Método auxiliar para encontrar o índice de um valor em um array
    public static int indexOf(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}