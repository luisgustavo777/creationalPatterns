package br.com.exemplo.academico;

/**
 * Demonstração unificando Abstract Factory + Factory Method + Singleton:
 * o sistema de secretaria acadêmica emite Histórico e Diploma para alunos
 * de Graduação e de Pós-Graduação sem que o código cliente conheça as
 * classes concretas das fábricas nem dos documentos.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Secretaria Acadêmica — Emissão de Documentos ===\n");

        Aluno ana = new Aluno("Ana Beatriz", TipoCurso.GRADUACAO);
        ana.emitirDocumentos();

        System.out.println();

        Aluno carlos = new Aluno("Carlos Eduardo", TipoCurso.POS_GRADUACAO);
        carlos.emitirDocumentos();

        System.out.println();

        Aluno outraGraduanda = new Aluno("Fernanda Lima", TipoCurso.GRADUACAO);
        outraGraduanda.emitirDocumentos();

        System.out.println("\n=== Verificando o Singleton do FactoryMethod ===");
        FactoryMethod instancia1 = FactoryMethod.getInstance();
        FactoryMethod instancia2 = FactoryMethod.getInstance();
        System.out.println("As duas referências apontam para o mesmo objeto? "
                + (instancia1 == instancia2));

        System.out.println("\n=== Verificando reaproveitamento da fábrica de Graduação ===");
        FabricaAbstrata fabricaAna = FactoryMethod.getInstance().obterFabrica(TipoCurso.GRADUACAO);
        FabricaAbstrata fabricaFernanda = FactoryMethod.getInstance().obterFabrica(TipoCurso.GRADUACAO);
        System.out.println("Mesma instância de FabricaGraduacao reaproveitada? "
                + (fabricaAna == fabricaFernanda));
    }
}
