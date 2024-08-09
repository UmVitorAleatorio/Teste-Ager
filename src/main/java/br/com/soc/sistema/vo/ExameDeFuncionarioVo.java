package br.com.soc.sistema.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExameDeFuncionarioVo extends ExameVo{
    private String internoId;
    private LocalDate data;

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
        System.out.println("Tentando converter data: "+ data);
        this.data = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
