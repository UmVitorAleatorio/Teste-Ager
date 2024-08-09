package br.com.soc.sistema.soap;

import javax.jws.WebService;

import br.com.soc.sistema.business.FuncionarioBusiness;

@WebService(endpointInterface = "br.com.soc.sistema.soap.WebServiceFuncionarios")
public class WebServiceFuncionariosImpl implements WebServiceFuncionarios {

    private FuncionarioBusiness business;

    public WebServiceFuncionariosImpl() {
        this.business = new FuncionarioBusiness();
    }

    @Override
    public String buscarFuncionario(String codigo) {
        return business.buscarFuncionarioPor(codigo).toString();
    }
}
