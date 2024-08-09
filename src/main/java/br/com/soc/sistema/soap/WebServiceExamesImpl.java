package br.com.soc.sistema.soap;

import javax.jws.WebService;

import br.com.soc.sistema.business.ExameBusiness;

@WebService(endpointInterface = "br.com.soc.sistema.soap.WebServiceExames" )
public class WebServiceExamesImpl implements WebServiceExames {

	private ExameBusiness business;
	
	public WebServiceExamesImpl() {
		this.business = new ExameBusiness();
	}
	
	@Override
	public String buscarExame(String codigo) {		
		return business.buscarExamePor(codigo).toString();
	}
}
