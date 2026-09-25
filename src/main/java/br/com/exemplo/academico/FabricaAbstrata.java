package br.com.exemplo.academico;

/**
 * «interface» FabricaAbstrata — o Abstract Factory da família de produtos
 * acadêmicos (Historico + Diploma). Cada modalidade de curso (Graduação,
 * Pós-Graduação) implementa esta interface para produzir seus documentos
 * de forma consistente entre si.
 */
public interface FabricaAbstrata {
    Historico criarHistorico(String nomeAluno);
    Diploma criarDiploma(String nomeAluno);
}
