package br.com.soc.sistema.filter;

import br.com.soc.sistema.infra.OpcoesComboBuscarExames;

public class ExameFilter {
	private OpcoesComboBuscarExames opcoesCombo;
	private String valorBusca;

	public String getValorBusca() {
		return valorBusca;
	}

	public ExameFilter setValorBusca(String valorBusca) {
		this.valorBusca = valorBusca;
		return this;
	}

	public OpcoesComboBuscarExames getOpcoesCombo() {
		return opcoesCombo;
	}

	public ExameFilter setOpcoesCombo(String codigo) {
		this.opcoesCombo = OpcoesComboBuscarExames.buscarPor(codigo);
		return this;
	}	
	
	public boolean isNullOpcoesCombo() {
		return this.getOpcoesCombo() == null;
	}
	
	public static ExameFilter builder() {
		return new ExameFilter();
	}
}
