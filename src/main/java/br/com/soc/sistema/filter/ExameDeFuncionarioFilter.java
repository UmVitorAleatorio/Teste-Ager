package br.com.soc.sistema.filter;

import br.com.soc.sistema.infra.OpcoesComboBuscarExameDeFuncionarios;
import br.com.soc.sistema.vo.FuncionarioVo;

public class ExameDeFuncionarioFilter {
    private OpcoesComboBuscarExameDeFuncionarios opcoesCombo;
    private String valorBusca;
    private FuncionarioVo funcionario;

    public FuncionarioVo getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioVo funcionario) {
        this.funcionario = funcionario;
    }

    public String getValorBusca() {
        return valorBusca;
    }

    public ExameDeFuncionarioFilter setValorBusca(String valorBusca) {
        this.valorBusca = valorBusca;
        return this;
    }

    public OpcoesComboBuscarExameDeFuncionarios getOpcoesCombo() {
        return opcoesCombo;
    }

    public ExameDeFuncionarioFilter setOpcoesCombo(String codigo) {
        this.opcoesCombo = OpcoesComboBuscarExameDeFuncionarios.buscarPor(codigo);
        return this;
    }

    public boolean isNullOpcoesCombo() {
        return this.getOpcoesCombo() == null;
    }

    public static ExameDeFuncionarioFilter builder() {
        return new ExameDeFuncionarioFilter();
    }
}
