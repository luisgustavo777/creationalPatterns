package br.com.exemplo.academico;

/** Modalidades de curso reconhecidas pelo FactoryMethod. */
public enum TipoCurso {
    GRADUACAO(FabricaGraduacao.class),
    POS_GRADUACAO(FabricaPosGraduacao.class);

    private final Class<? extends FabricaAbstrata> classeFabrica;

    TipoCurso(Class<? extends FabricaAbstrata> classeFabrica) {
        this.classeFabrica = classeFabrica;
    }

    public Class<? extends FabricaAbstrata> getClasseFabrica() {
        return classeFabrica;
    }
}
