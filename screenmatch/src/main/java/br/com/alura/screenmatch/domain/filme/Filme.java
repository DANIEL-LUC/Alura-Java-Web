package br.com.alura.screenmatch.domain.filme;

public class Filme {
    private String nome;
    private Integer duracaoEmMinutos;
    private Integer anoLancamento;
    private String genero;


    public Filme (DadosCadastrosFilmes dados){
        this.anoLancamento = dados.ano();
        this.genero = dados.genero();
        this.duracaoEmMinutos = dados.duracao();;
        this.nome = dados.nome();

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
}
