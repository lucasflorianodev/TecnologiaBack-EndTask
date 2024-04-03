import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aluno {
    private String nome;
    private int nota1;
    private int nota2;
    private int nota3;

    public Aluno(String nome, int nota1, int nota2, int nota3) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getNome() {
        return nome;
    }

    public int getNota1() {
        return nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public int getNota3() {
        return nota3;
    }

    public double calcularMedia() {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();
        List<String> aprovados = new ArrayList<>();
        List<String> reprovados = new ArrayList<>();
        int aprovadosCount = 0;
        int reprovadosCount = 0;

        while (true) {
            System.out.print("Digite o nome do aluno ou 'sair' para encerrar: ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite a nota 1: ");
            int nota1 = scanner.nextInt();
            System.out.print("Digite a nota 2: ");
            int nota2 = scanner.nextInt();
            System.out.print("Digite a nota 3: ");
            int nota3 = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após a última nota

            Aluno aluno = new Aluno(nome, nota1, nota2, nota3);
            alunos.add(aluno);

            double media = aluno.calcularMedia();
            if (media >= 6) {
                aprovados.add(nome);
                aprovadosCount++;
            } else {
                reprovados.add(nome);
                reprovadosCount++;
            }
        }

        System.out.println("\nQuantidade de alunos aprovados: " + aprovadosCount);
        System.out.println("Quantidade de alunos reprovados: " + reprovadosCount);

        System.out.println("\nAlunos aprovados:");
        for (String aluno : aprovados) {
            System.out.println(aluno);
        }

        System.out.println("\nAlunos reprovados:");
        for (String aluno : reprovados) {
            System.out.println(aluno);
        }
    }
}