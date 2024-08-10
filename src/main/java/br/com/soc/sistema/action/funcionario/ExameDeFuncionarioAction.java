package br.com.soc.sistema.action.funcionario;

import br.com.soc.sistema.business.ExameBusiness;
import br.com.soc.sistema.business.ExameDeFuncionarioBusiness;
import br.com.soc.sistema.exception.NaoPodeExcluirException;
import br.com.soc.sistema.filter.ExameDeFuncionarioFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.ExameDeFuncionarioVo;
import br.com.soc.sistema.vo.ExameVo;
import br.com.soc.sistema.vo.ExamesDeFuncionarioVo;
import br.com.soc.sistema.vo.FuncionarioVo;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;
import java.util.Map;

public class ExameDeFuncionarioAction extends Action {
    private ExameDeFuncionarioBusiness business = new ExameDeFuncionarioBusiness();
    private ExameBusiness exameBusiness = new ExameBusiness();
    private ExameDeFuncionarioFilter filtro = new ExameDeFuncionarioFilter();
    private ExamesDeFuncionarioVo examesDeFuncionarioVo = new ExamesDeFuncionarioVo();
    private ExameDeFuncionarioVo exameInclusaoVo  = new ExameDeFuncionarioVo();
    private String idIntenoExameEditar;
    private String idIntenoExameExcluir;




    public ExameDeFuncionarioVo getExameInclusaoVo() {
        return exameInclusaoVo;
    }

    public void setExameInclusaoVo(ExameDeFuncionarioVo exameInclusaoVo) {
        this.exameInclusaoVo = exameInclusaoVo;
    }

    public ExameDeFuncionarioFilter getFiltro() {
        return filtro;
    }

    public void setFiltro(ExameDeFuncionarioFilter filtro) {
        this.filtro = filtro;
    }

    public ExameDeFuncionarioFilter mapDaSessaoF() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        System.out.println(session.get("funcionario"));
        FuncionarioVo funcionario = (FuncionarioVo) session.get("funcionario");
        filtro.setFuncionario(funcionario);
        return filtro;
    }

    public ExamesDeFuncionarioVo mapDaSessaoDeFVo() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        System.out.println(session.get("funcionario"));
        FuncionarioVo funcionario = (FuncionarioVo)session.get("funcionario");
        examesDeFuncionarioVo.setFuncionarioVo(funcionario);
        return examesDeFuncionarioVo;
    }

    public String todos() {
        mapDaSessaoF();
        examesDeFuncionarioVo = business.trazerTodosOsExamesDeFuncionario(filtro);

        for (ExameDeFuncionarioVo exame : examesDeFuncionarioVo.getExamesVo()) {
            System.out.println("Exame ID: " + exame.getRowid() + " - Interno ID: " + exame.getInternoId());
        }

        return SUCCESS;
    }

    public String novo() {
        mapDaSessaoF();

        return INPUT;
    }

    public String add() {
        mapDaSessaoDeFVo();
        try {
            business.verificarData(exameInclusaoVo, examesDeFuncionarioVo.getFuncionarioVo());
        }catch (NaoPodeExcluirException e){
            todos();
            addActionError("Você não pode adicionar novamente esse exame a este funcionário, para isso altere a data!");
            return ERROR;
        }
        business.salvarExame(exameInclusaoVo, examesDeFuncionarioVo.getFuncionarioVo());

        return todos();
    }

    public String editar() {
        try {
            mapDaSessaoDeFVo();
            System.out.println("TESTEEEEE: "+examesDeFuncionarioVo);
            business.verificarData(exameInclusaoVo, examesDeFuncionarioVo.getFuncionarioVo());
        }catch (NaoPodeExcluirException e){
            todos();
            addActionError("Você não pode adicionar novamente esse exame a este funcionário, para isso altere a data!");
            return ERROR;
        }
        business.editarExame(exameInclusaoVo, idIntenoExameEditar);

        return todos();
    }

    public String excluir() {
        business.excluirExame(idIntenoExameExcluir);

        return todos();
    }

    public List<ExameDeFuncionarioVo> getExames() {
        System.out.println("Exames de Funcionario sendo listado pela tela");
        return examesDeFuncionarioVo.getExamesVo();
    }

    public List<ExameVo> getExamesCadastrados() {
        System.out.println("Buscando exames da base");
        return exameBusiness.trazerTodosOsExames();
    }

    public String getIdIntenoExameEditar() {
        return idIntenoExameEditar;
    }

    public void setIdIntenoExameEditar(String idIntenoExameEditar) {
        this.idIntenoExameEditar = idIntenoExameEditar;
    }

    public String getIdIntenoExameExcluir() {
        return idIntenoExameExcluir;
    }

    public void setIdIntenoExameExcluir(String idIntenoExameExcluir) {
        this.idIntenoExameExcluir = idIntenoExameExcluir;
    }
}
