package br.com.soc.sistema.action.funcionario;

import br.com.soc.sistema.business.FuncionarioBusiness;
import br.com.soc.sistema.filter.FuncionarioFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesComboBuscarFuncionarios;
import br.com.soc.sistema.vo.FuncionarioVo;
import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class FuncionarioAction extends Action {
    private List<FuncionarioVo> funcionarios = new ArrayList<>();
    private FuncionarioBusiness business = new FuncionarioBusiness();
    private FuncionarioFilter filtrar = new FuncionarioFilter();
    private FuncionarioVo funcionarioVo = new FuncionarioVo();

    public String todos() {
        funcionarios.addAll(business.trazerTodosOsFuncionarios());
        System.out.println(funcionarios);

        return SUCCESS;
    }

    public String filtrar() {
        if(filtrar.isNullOpcoesCombo())
            return REDIRECT;

        funcionarios = business.filtrarFuncionarios(filtrar);

        return SUCCESS;
    }

    public String novo() {
        if(funcionarioVo.getNome() == null)
            return INPUT;

        business.salvarFuncionario(funcionarioVo);

        return REDIRECT;
    }

    public String editar() {
        if (funcionarioVo.getRowid() == null)
            return REDIRECT;

        funcionarioVo = business.buscarFuncionarioPor(funcionarioVo.getRowid());

        return UPDATE;
    }

    public String exame() {
        if (funcionarioVo.getRowid() == null)
            return REDIRECT;

        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("funcionario", funcionarioVo);
        return EXAME;
    }

    public String salvarEdicao() {
        if (funcionarioVo.getRowid() == null)
            return REDIRECT;

        business.editarPorId(funcionarioVo);
        return REDIRECT;
    }

    public String excluir() {
        if (funcionarioVo.getRowid() == null)
            return REDIRECT;

        business.excluirPorId(funcionarioVo.getRowid());
        return REDIRECT;
    }

    public String navegarExames(){
        return NAVEGAR_EXAMES;
    }


    public  List<OpcoesComboBuscarFuncionarios> getListaOpcoesCombo() {
        return Arrays.asList(OpcoesComboBuscarFuncionarios.values());
    }

    public List<FuncionarioVo> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<FuncionarioVo> funcionario) {
        this.funcionarios = funcionario;
    }

    public FuncionarioFilter getFiltrar() {
        return filtrar;
    }

    public void setFiltrar(FuncionarioFilter filtrar) {
        this.filtrar = filtrar;
    }

    public FuncionarioVo getFuncionarioVo() {
        return funcionarioVo;
    }

    public void setFuncionarioVo(FuncionarioVo funcionarioVo) {
        this.funcionarioVo = funcionarioVo;
    }
}
