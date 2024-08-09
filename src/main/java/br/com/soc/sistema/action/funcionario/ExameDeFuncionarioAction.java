package br.com.soc.sistema.action.funcionario;

import br.com.soc.sistema.business.ExameBusiness;
import br.com.soc.sistema.business.ExameDeFuncionarioBusiness;
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

    public String todos() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        System.out.println(session.get("funcionario"));
        FuncionarioVo funcionario = (FuncionarioVo)session.get("funcionario");
        filtro.setFuncionario(funcionario);
        examesDeFuncionarioVo = business.trazerTodosOsExamesDeFuncionario(filtro);

        for (ExameDeFuncionarioVo exame : examesDeFuncionarioVo.getExamesVo()) {
            System.out.println("Exame ID: " + exame.getRowid() + " - Interno ID: " + exame.getInternoId());
        }

        return SUCCESS;
    }

    public String novo() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        System.out.println(session.get("funcionario"));
        FuncionarioVo funcionario = (FuncionarioVo)session.get("funcionario");
        filtro.setFuncionario(funcionario);
        System.out.println(funcionario);
        System.out.println(funcionario.getNome());

        return INPUT;
    }

    public String add() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        System.out.println(session.get("funcionario"));
        FuncionarioVo funcionario = (FuncionarioVo)session.get("funcionario");
        filtro.setFuncionario(funcionario);
        examesDeFuncionarioVo.setFuncionarioVo(funcionario);
        business.salvarExame(exameInclusaoVo, examesDeFuncionarioVo.getFuncionarioVo());

        return todos();
    }

    public String editar() {
        System.out.println("O que tem dentro do exameinclusao: "+exameInclusaoVo);
        System.out.println("Tentando ver a data: "+exameInclusaoVo.getData());
        System.out.println("Mostrando o idInterno: "+idIntenoExameEditar);
        System.out.println("Mostrando de outra maneira o id interno: "+idIntenoExameExcluir);
        System.out.println("Mostrando de outra maneira o id interno: "+exameInclusaoVo.getInternoId());
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
