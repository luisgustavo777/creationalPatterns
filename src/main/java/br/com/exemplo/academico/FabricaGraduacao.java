package br.com.exemplo.academico;

public class FabricaGraduacao implements FabricaAbstrata {
    @Override
    public Historico criarHistorico(String nomeAluno) {
        return new HistoricoGraduacao(nomeAluno);
    }

    @Override
    public Diploma criarDiploma(String nomeAluno) {
        return new DiplomaGraduacao(nomeAluno);
    }
}
