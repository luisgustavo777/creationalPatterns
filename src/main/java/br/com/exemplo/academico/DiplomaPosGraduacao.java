package br.com.exemplo.academico;

/** Produto concreto: diploma de Pós-Graduação (mestrado/doutorado). */
public class DiplomaPosGraduacao implements Diploma {
    private final String nomeAluno;

    public DiplomaPosGraduacao(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    @Override
    public String gerarConteudo() {
        return "Diploma de PÓS-GRADUAÇÃO concedido a " + nomeAluno + " — Mestre.";
    }
}
