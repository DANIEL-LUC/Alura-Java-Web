package br.com.alura.screenmatch.domain.filme;

import jakarta.persistence.*;

// anotações da JPA, mapeando a classe para a tabela do banco
@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer duracaoEmMinutos;
    private Integer anoLancamento;
    private String genero;

    // Construtor padrão sem argumentos exigido pelo JPA
    public Filme() {
    }

    public Filme(Long id, String nome, Integer duracaoEmMinutos, Integer anoLancamento, String genero) {
        this.id = id;
        this.nome = nome;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }

    public Filme (DadosCadastrosFilmes dados){
        this.anoLancamento = dados.ano();
        this.genero = dados.genero();
        this.duracaoEmMinutos = dados.duracao();;
        this.nome = dados.nome();

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", dureacaoEmMinutos=" + duracaoEmMinutos +
                ", anoLancamento=" + anoLancamento +
                ", gernero='" + genero + '\'' +
                '}';
    }

    public void atualizaDados(DadosAlteracaoFilmes dados) {
        this.nome = dados.nome();
        this.anoLancamento = dados.ano();
        this.duracaoEmMinutos = dados.duracao();
        this.genero = dados.genero();
    }
}
