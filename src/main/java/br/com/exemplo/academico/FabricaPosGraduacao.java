package br.com.exemplo.academico;

public class FabricaPosGraduacao implements FabricaAbstrata {
    @Override
    public Historico criarHistorico(String nomeAluno) {
        return new HistoricoPosGraduacao(nomeAluno);
    }

    @Override
    public Diploma criarDiploma(String nomeAluno) {
        return new DiplomaPosGraduacao(nomeAluno);
    }
}
