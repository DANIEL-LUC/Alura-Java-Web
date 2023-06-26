package br.com.alura.screenmatch.domain.filme;

public class Filme {
    private String nome;
    private Integer dureacaoEmMinutos;
    private Integer anoLancamento;
    private String genero;


    public Filme (DadosCadastrosFilmes dados){
        this.anoLancamento = dados.ano();
        this.genero = dados.genero();
        this.dureacaoEmMinutos = dados.duracao();;
        this.nome = dados.nome();

    }

    public String getNome() {
        return nome;
    }

    public Integer getDureacaoEmMinutos() {
        return dureacaoEmMinutos;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getGernero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", dureacaoEmMinutos=" + dureacaoEmMinutos +
                ", anoLancamento=" + anoLancamento +
                ", gernero='" + genero + '\'' +
                '}';
    }
}
