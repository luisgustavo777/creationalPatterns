package br.com.exemplo.academico;

/** Produto concreto: histórico escolar de um curso de Graduação. */
public class HistoricoGraduacao implements Historico {
    private final String nomeAluno;

    public HistoricoGraduacao(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    @Override
    public String gerarConteudo() {
        return "Histórico de GRADUAÇÃO de " + nomeAluno
                + " — Disciplinas de graduação cursadas, carga horária 3200h.";
    }
}
