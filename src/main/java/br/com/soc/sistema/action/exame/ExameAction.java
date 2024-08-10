package br.com.soc.sistema.action.exame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.soc.sistema.business.ExameBusiness;
import br.com.soc.sistema.exception.NaoPodeExcluirException;
import br.com.soc.sistema.filter.ExameFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesComboBuscarExames;
import br.com.soc.sistema.vo.ExameVo;

public class ExameAction extends Action {
	private List<ExameVo> exames = new ArrayList<>();
	private ExameBusiness business = new ExameBusiness();
	private ExameFilter filtrar = new ExameFilter();
	private ExameVo exameVo = new ExameVo();
	
	public String todos() {
		exames.addAll(business.trazerTodosOsExames());	

		return SUCCESS;
	}
	
	public String filtrar() {
		if(filtrar.isNullOpcoesCombo())
			return REDIRECT;
		
		exames = business.filtrarExames(filtrar);
		
		return SUCCESS;
	}
	
	public String novo() {
		if(exameVo.getNome() == null)
			return INPUT;
		
		business.salvarExame(exameVo);
		
		return REDIRECT;
	}
	
	public String editar() {
		if(exameVo.getRowid() == null)
			return REDIRECT;

		exameVo = business.buscarExamePor(exameVo.getRowid());

		return UPDATE;
	}

	public String salvarEdicao(){
		if(exameVo.getRowid() == null)
			return REDIRECT;

		business.editarPorId(exameVo);
		return REDIRECT;
	}

	public String excluir() {
		if(exameVo.getRowid() == null)
			return REDIRECT;

        try {
			business.verificarPorFuncionarios(exameVo.getRowid());
		}catch (NaoPodeExcluirException e){
			todos();
			addActionError("Você não pode excluir esse exame porque há funcionários ligados a ele.");
			return ERROR;
		}

		business.excluirPorId(exameVo.getRowid());

		return REDIRECT;
	}

	public String navegarFuncionarios(){
		return NAVEGAR_FUNCIONARIOS;
	}
	
	public List<OpcoesComboBuscarExames> getListaOpcoesCombo(){
		return Arrays.asList(OpcoesComboBuscarExames.values());
	}
	
	public List<ExameVo> getExames() {
		return exames;
	}

	public void setExames(List<ExameVo> exames) {
		this.exames = exames;
	}

	public ExameFilter getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(ExameFilter filtrar) {
		this.filtrar = filtrar;
	}

	public ExameVo getExameVo() {
		return exameVo;
	}

	public void setExameVo(ExameVo exameVo) {
		this.exameVo = exameVo;
	}
}
