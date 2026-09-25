package br.com.exemplo.academico;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FactoryMethodTest {

    @Test
    void getInstanceSempreDevolveOMesmoObjeto() {
        assertSame(FactoryMethod.getInstance(), FactoryMethod.getInstance());
    }

    @Test
    void obterFabricaDevolveAFabricaCorretaParaCadaTipoDeCurso() {
        FabricaAbstrata fabricaGraduacao = FactoryMethod.getInstance().obterFabrica(TipoCurso.GRADUACAO);
        FabricaAbstrata fabricaPos = FactoryMethod.getInstance().obterFabrica(TipoCurso.POS_GRADUACAO);

        assertTrue(fabricaGraduacao instanceof FabricaGraduacao);
        assertTrue(fabricaPos instanceof FabricaPosGraduacao);
    }

    @Test
    void alunoRecebeHistoricoEDiplomaDaModalidadeCorreta() {
        Aluno aluno = new Aluno("Ana Beatriz", TipoCurso.GRADUACAO);

        assertTrue(aluno.getHistorico() instanceof HistoricoGraduacao);
        assertTrue(aluno.getDiploma() instanceof DiplomaGraduacao);
    }
}
