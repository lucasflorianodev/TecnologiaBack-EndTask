import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class cliente {
    String nome;
    String cpf;
    String endereco;
    String dataNascimento;
    String telefone;

    public cliente(String nome, String cpf, String endereco, String dataNascimento, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }
}

class livro {
    String nome;
    String autor;
    int numPaginas;
    String editora;

    public livro(String nome, String autor, int numPaginas, String editora) {
        this.nome = nome;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.editora = editora;
    }

    public String getNome() {
        return null;
    }
}

class emprestimoDTO {
    Cliente cliente;
    livro livro;
    Date dataEmprestimo;
    Date dataDevolucao;

    public emprestimoDTO(Cliente cliente, livro livro, Date dataEmprestimo, Date dataDevolucao) {
        this.cliente = cliente;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }
}

class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<livro> livros = new ArrayList<>();
    static ArrayList<EmprestimoDTO> emprestimos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    static void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.print("Data de nascimento do cliente (formato: DD/MM/AAAA): ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Telefone do cliente: ");
        String telefone = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf, endereco, dataNascimento, telefone);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    static void cadastrarLivro() {
        System.out.print("Nome do livro: ");
        String nome = scanner.nextLine();
        System.out.print("Autor do livro: ");
        String autor = scanner.nextLine();
        System.out.print("Número de páginas do livro: ");
        int numPaginas = Integer.parseInt(scanner.nextLine());
        System.out.print("Editora do livro: ");
        String editora = scanner.nextLine();
        livro livro = new livro(nome, autor, numPaginas, editora);
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    static void pegarEmprestado() {
        System.out.println("Clientes:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        System.out.print("Selecione o número correspondente ao cliente: ");
        int clienteIndex = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.println("\nLivros disponíveis:");
        for (int i = 0; i < livros.size(); i++) {
            System.out.println((i + 1) + ". " + livros.get(i).nome);
        }
        System.out.print("Selecione o número correspondente ao livro: ");
        int livroIndex = Integer.parseInt(scanner.nextLine()) - 1;

        Date dataEmprestimo = new Date();
        Date dataDevolucao = new Date(dataEmprestimo.getTime() + 7 * 24 * 60 * 60 * 1000); // 7 dias em milissegundos
        EmprestimoDTO emprestimo = new EmprestimoDTO(clientes.get(clienteIndex), livros.get(livroIndex), dataEmprestimo, dataDevolucao);
        emprestimos.add(emprestimo);
        System.out.println("Livro emprestado com sucesso!");
    }

    static void exibirEmprestimos() {
        for (EmprestimoDTO emprestimo : emprestimos) {
            System.out.println("\nNome do cliente: " + emprestimo.cliente.nome);
            System.out.println("Nome do livro: " + emprestimo.livro.nome);
            System.out.println("Data de empréstimo: " + emprestimo.dataEmprestimo);
            System.out.println("Data de devolução: " + emprestimo.dataDevolucao);
        }
    }

    static void menu() {
        while (true) {
            System.out.println("\n1. Cadastrar cliente");
            System.out.println("2. Cadastrar livro");
            System.out.println("3. Pegar livro emprestado");
            System.out.println("4. Exibir empréstimos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1":
                    cadastrarCliente();
                    break;
                case "2":
                    cadastrarLivro();
                    break;
                case "3":
                    pegarEmprestado();
                    break;
                case "4":
                    exibirEmprestimos();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}