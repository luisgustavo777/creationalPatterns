package br.com.exemplo.academico;

/** Produto concreto: diploma de Graduação (bacharelado/licenciatura). */
public class DiplomaGraduacao implements Diploma {
    private final String nomeAluno;

    public DiplomaGraduacao(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    @Override
    public String gerarConteudo() {
        return "Diploma de GRADUAÇÃO concedido a " + nomeAluno + " — Bacharel.";
    }
}
