package br.com.exemplo.academico;

import java.lang.reflect.InvocationTargetException;
import java.util.EnumMap;
import java.util.Map;

/**
 * Classe central do sistema. Une dois padrões:
 *
 * 1) SINGLETON — existe uma única instância de FactoryMethod em toda a
 *    aplicação (associação "1" consigo mesma no diagrama).
 *
 * 2) FACTORY METHOD — o método {@link #obterFabrica(TipoCurso)} decide,
 *    em tempo de execução, QUAL FabricaAbstrata concreta instanciar,
 *    usando reflexão (java.lang.Class / java.lang.Object) a partir do
 *    TipoCurso informado, em vez de a aplicação cliente fazer "new
 *    FabricaGraduacao()" ou "new FabricaPosGraduacao()" diretamente.
 */
public final class FactoryMethod {

    private static FactoryMethod instancia;

    // Cache das fábricas já construídas por reflexão (cada uma também
    // acaba se comportando como um singleton por tipo de curso).
    private final Map<TipoCurso, FabricaAbstrata> fabricasCriadas = new EnumMap<>(TipoCurso.class);

    private FactoryMethod() {
        // construtor privado: ninguém fora desta classe pode instanciá-la.
    }

    /** Ponto de acesso global do Singleton. */
    public static synchronized FactoryMethod getInstance() {
        if (instancia == null) {
            instancia = new FactoryMethod();
        }
        return instancia;
    }

    /**
     * Factory Method: devolve a FabricaAbstrata correta para o tipo de curso,
     * instanciando a classe concreta via reflexão (Class#getDeclaredConstructor
     * -> Object) e reaproveitando a instância em chamadas futuras.
     */
    public FabricaAbstrata obterFabrica(TipoCurso tipo) {
        return fabricasCriadas.computeIfAbsent(tipo, this::instanciarFabricaPorReflexao);
    }

    private FabricaAbstrata instanciarFabricaPorReflexao(TipoCurso tipo) {
        Class<? extends FabricaAbstrata> classeFabrica = tipo.getClasseFabrica();
        try {
            Object novaInstancia = classeFabrica.getDeclaredConstructor().newInstance();
            return (FabricaAbstrata) novaInstancia;
        } catch (InstantiationException | IllegalAccessException
                 | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalStateException(
                    "Não foi possível instanciar a fábrica para " + tipo, e);
        }
    }
}
