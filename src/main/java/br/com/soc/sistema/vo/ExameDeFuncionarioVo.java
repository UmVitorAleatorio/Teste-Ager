package br.com.soc.sistema.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExameDeFuncionarioVo extends ExameVo{
    private String internoId;
    private LocalDate data;
    private Integer funcionarioId;
    private String funcionarioNome;

    public Integer getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Integer funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getFuncionarioNome() {
        return funcionarioNome;
    }

    public void setFuncionarioNome(String funcionarioNome) {
        this.funcionarioNome = funcionarioNome;
    }

    public String getInternoId() {
        return internoId;
    }

    public void setInternoId(String internoId) {
        this.internoId = internoId;
    }

    public String getDataFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(String data) {
        this.data = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public String toString() {
        return "ExameDeFuncionarioVo ["+" internoId = " + internoId + ", data = " + data + ", funcionarioId = " + funcionarioId + ", funcionarioNome = " + funcionarioNome + super.toString() + "]";
    }
}
