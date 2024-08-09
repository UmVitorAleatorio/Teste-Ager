package br.com.soc.sistema.infra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import br.com.soc.sistema.exception.BusinessException;

public enum OpcoesComboBuscarFuncionarios {
    ID("1", "ID"),
    NOME("2", "NOME");

    private String codigo;
    private String descricao;
    private final static Map<String, OpcoesComboBuscarFuncionarios> opcoes = new HashMap<>();

    static {
        Arrays.asList(OpcoesComboBuscarFuncionarios.values())
        .forEach(
            opcao -> opcoes.put(opcao.getCodigo(), opcao)
        );
    }

    private OpcoesComboBuscarFuncionarios(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static OpcoesComboBuscarFuncionarios buscarPor(String codigo) throws IllegalArgumentException {
        if(codigo == null)
            throw new IllegalArgumentException("informe um código valido");

        OpcoesComboBuscarFuncionarios opcao = getOpcao(codigo)
                    .orElseThrow(() -> new BusinessException("Codigo informado nao existe"));

        return opcao;
    }

    private static Optional<OpcoesComboBuscarFuncionarios> getOpcao(String codigo) {
        return Optional.ofNullable(opcoes.get(codigo));
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}