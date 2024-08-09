package br.com.soc.sistema.vo;


import java.util.ArrayList;
import java.util.List;

public class ExamesDeFuncionarioVo {
    private List<ExameDeFuncionarioVo> examesVo = new ArrayList<>();
    private FuncionarioVo funcionarioVo;


    public List<ExameDeFuncionarioVo> getExamesVo() {
        return examesVo;
    }

    public void setExamesVo(List<ExameDeFuncionarioVo> examesVo) {
        this.examesVo = examesVo;
    }

    public FuncionarioVo getFuncionarioVo() {
        return funcionarioVo;
    }

    public void setFuncionarioVo(FuncionarioVo funcionarioVo) {
        this.funcionarioVo = funcionarioVo;
    }

    @Override
    public String toString() {
        return "ExameFuncionario [examesVo=" + examesVo + ", funcionarioVo=" + funcionarioVo + "]";
    }
}
