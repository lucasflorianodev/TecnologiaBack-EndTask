import java.time.LocalDate;
import java.util.Date;

class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private LocalDate dataNascimento;
    private String telefone;

    public Cliente(String nome, String cpf, String endereco, LocalDate dataNascimento, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public Cliente(String nome, String cpf, String endereco, String dataNascimento, String telefone) {
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }
}

class Livro {
    private String nome;
    private String autor;
    private int quantidadePaginas;
    private String editora;

    public Livro(String nome, String autor, int quantidadePaginas, String editora) {
        this.nome = nome;
        this.autor = autor;
        this.quantidadePaginas = quantidadePaginas;
        this.editora = editora;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public String getEditora() {
        return editora;
    }
}

class Emprestimo {
    private Cliente cliente;
    private livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Cliente cliente, livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.cliente = cliente;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
}

class EmprestimoDTO {
    public cliente cliente;
    public cliente livro;
    private String nomeCliente;
    private livro nomeLivro;
    public Date dataEmprestimo;
    public Date dataDevolucao;

    public EmprestimoDTO(Cliente nomeCliente, livro nomeLivro, Date dataEmprestimo, Date dataDevolucao) {
        this.nomeCliente = nomeCliente.toString();
        this.nomeLivro = nomeLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public EmprestimoDTO(String clienteNome, String livroNome, LocalDate dataEmprestimo, LocalDate dataDevolucao) {

    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public livro getNomeLivro() {
        return nomeLivro;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }
}

public class main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", "123.456.789-00", "Rua A", LocalDate.of(1990, 5, 15), "9999-9999");
        livro livro = new livro("Java for Beginners", "John Doe", 300, "Tech Publishing");
        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataDevolucao = dataEmprestimo.plusDays(14); // Supondo que o prazo de devolução seja de 14 dias
        Emprestimo emprestimo = new Emprestimo(cliente, livro, dataEmprestimo, dataDevolucao);


        EmprestimoDTO emprestimoDTO = new EmprestimoDTO(cliente.getNome(), livro.getNome(), dataEmprestimo, dataDevolucao);

        System.out.println("Nome do Cliente: " + emprestimoDTO.getNomeCliente());
        System.out.println("Nome do Livro: " + emprestimoDTO.getNomeLivro());
        System.out.println("Data de Empréstimo: " + emprestimoDTO.getDataEmprestimo());
        System.out.println("Data de Devolução: " + emprestimoDTO.getDataDevolucao());
    }
}