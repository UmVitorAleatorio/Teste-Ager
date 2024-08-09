package br.com.soc.sistema.infra;

import br.com.soc.sistema.exception.BusinessException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum OpcoesComboBuscarExameDeFuncionarios {
    ID_FUNC("1", "ID DO FUNCIONARIO"),
    ID_EXAM("2", "ID DO EXAME"),
    DATA_EX("3", "DATA DO EXAME"),
    NOME_EX("4", "NOME DO EXAME");

    private String codigo;
    private String descricao;
    private final static Map<String, OpcoesComboBuscarExameDeFuncionarios> opcoes = new HashMap<>();

    static {
        Arrays.asList(OpcoesComboBuscarExameDeFuncionarios.values())
                .forEach(
                        opcao -> opcoes.put(opcao.getCodigo(), opcao)
                );
    }

    private OpcoesComboBuscarExameDeFuncionarios(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static OpcoesComboBuscarExameDeFuncionarios buscarPor(String codigo) throws IllegalArgumentException {
        if (codigo == null)
            throw new IllegalArgumentException("informe um codigo valido");

        OpcoesComboBuscarExameDeFuncionarios opcao = getOpcao(codigo)
                .orElseThrow(() -> new BusinessException("Codigo informado nao existe"));

        return opcao;
    }

    private static Optional<OpcoesComboBuscarExameDeFuncionarios> getOpcao(String codigo) {
        return Optional.ofNullable(opcoes.get(codigo));
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}