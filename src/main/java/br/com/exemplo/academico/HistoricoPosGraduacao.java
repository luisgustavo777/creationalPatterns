package br.com.exemplo.academico;

/** Produto concreto: histórico escolar de um curso de Pós-Graduação. */
public class HistoricoPosGraduacao implements Historico {
    private final String nomeAluno;

    public HistoricoPosGraduacao(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    @Override
    public String gerarConteudo() {
        return "Histórico de PÓS-GRADUAÇÃO de " + nomeAluno
                + " — Disciplinas do stricto sensu, dissertação aprovada.";
    }
}
