package br.com.exemplo.academico;

public class Aluno {

    private final String nome;
    private final Historico historico;
    private final Diploma diploma;

    public Aluno(String nome, TipoCurso tipoCurso) {
        this.nome = nome;
        FabricaAbstrata fabrica = FactoryMethod.getInstance().obterFabrica(tipoCurso);
        this.historico = fabrica.criarHistorico(nome);
        this.diploma = fabrica.criarDiploma(nome);
    }

    public void emitirDocumentos() {
        System.out.println("Aluno: " + nome);
        System.out.println("  -> " + historico.gerarConteudo());
        System.out.println("  -> " + diploma.gerarConteudo());
    }

    public String getNome() {
        return nome;
    }

    public Historico getHistorico() {
        return historico;
    }

    public Diploma getDiploma() {
        return diploma;
    }
}
