package br.com.soc.sistema.action.relatorio;

import br.com.soc.sistema.business.ExameDeFuncionarioBusiness;
import br.com.soc.sistema.business.RelatorioBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.ExameDeFuncionarioVo;
import com.opensymphony.xwork2.ActionContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RelatorioAction extends Action {
    private String dataInicial;
    private String dataFinal;
    ExameDeFuncionarioBusiness exameDeFuncionarioBusiness = new ExameDeFuncionarioBusiness();
    RelatorioBusiness exameRelatorioBusiness = new RelatorioBusiness();

    List<ExameDeFuncionarioVo> exames = new ArrayList<>();

    public String iniciar() {
        exames = exameDeFuncionarioBusiness.listarTodos();
        salvaNaSessao();
        return SUCCESS;
    }

    private void salvaNaSessao() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("examesRelatorio", exames);
    }

    private void pegarDaSessao() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        List<ExameDeFuncionarioVo> examesRelatorio = (List<ExameDeFuncionarioVo>) session.get("examesRelatorio");
        exames = examesRelatorio;
    }

    public String  filtrar() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataInicioConvertida = LocalDate.parse(dataInicial, formatter);
        LocalDate dataFinalConvertida = LocalDate.parse(dataFinal, formatter);


        exames = exameDeFuncionarioBusiness.buscarTodosEntreDatas(dataInicioConvertida, dataFinalConvertida);
        salvaNaSessao();
        return SUCCESS;
    }

    public String montar() {
        pegarDaSessao();
        exameRelatorioBusiness.montarArquivo(exames);
        return SUCCESS;
    }

    public ExameDeFuncionarioBusiness getExameDeFuncionarioBusiness() {
        return exameDeFuncionarioBusiness;
    }

    public void setExameDeFuncionarioBusiness(ExameDeFuncionarioBusiness exameDeFuncionarioBusiness) {
        this.exameDeFuncionarioBusiness = exameDeFuncionarioBusiness;
    }

    public List<ExameDeFuncionarioVo> getExames() {
        return exames;
    }

    public void setExames(List<ExameDeFuncionarioVo> exames) {
        this.exames = exames;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public RelatorioBusiness getExameRelatorioBusiness() {
        return exameRelatorioBusiness;
    }

    public void setExameRelatorioBusiness(RelatorioBusiness exameRelatorioBusiness) {
        this.exameRelatorioBusiness = exameRelatorioBusiness;
    }
}
