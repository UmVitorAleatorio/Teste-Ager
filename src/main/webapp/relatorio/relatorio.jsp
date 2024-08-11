<%--
  Created by IntelliJ IDEA.
  User: vitor
  Date: 10/08/2024
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title><s:text name="label.titulo.pagina.relatorio"/></title>
    <link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
</head>
    <body class="bg-secondary">
        <div class="container">
            <div class="row mt-5 mb-2">
                <div class="col-sm p-0">
                    <s:form action="filtrarRelatorios" method="post">
                        <div class="row">
                            <div class="col-md-5 text-center text-light">
                                <label for="dataInicial" class="form-label"><s:text name="label.data.de"/></label>
                            </div>
                            <div class="col-md-2"></div>
                            <div class="col-md-5 text-center text-light">
                                <label for="dataFinal" class="form-label"><s:text name="label.data.ate"/></label>
                            </div>
                        </div>
                        <div class="row align-items-center">
                            <div class="col-md-5">
                                <s:textfield name="dataInicial" type="date" required="true" cssClass="form-control"/>
                            </div>
                            <div class="col-md-2 text-center">
                                <button type="submit" class="btn btn-primary">
                                    <s:text name="label.pesquisar"/>
                                </button>
                            </div>
                            <div class="col-md-5">
                                <s:textfield name="dataFinal" type="date" required="true" cssClass="form-control"/>
                            </div>
                        </div>
                    </s:form>
                </div>
            </div>

            <div class="row">
                <table class="table table-light table-striped align-middle">
                    <thead>
                        <tr>
                            <th><s:text name="label.id.funcionario"/></th>
                            <th><s:text name="label.nome.funcionario"/></th>
                            <th><s:text name="label.id.exame"/></th>
                            <th><s:text name="label.nome.exame"/></th>
                            <th><s:text name="label.data.exame"/></th>
                        </tr>
                    </thead>

                    <tbody>
                        <s:iterator value="exames">
                            <tr>
                                <td><s:property value="funcionarioId"/></td>
                                <td><s:property value="funcionarioNome"/></td>
                                <td><s:property value="rowid"/></td>
                                <td><s:property value="nome"/></td>
                                <td><s:property value="data"/></td>
                            </tr>
                        </s:iterator>
                    </tbody>

                    <tfoot class="bg-secondary">
                        <tr>
                            <td colspan="5">
                                <s:url action="montarRelatorios" var="excelUrl"/>

                                <a href="${excelUrl}" class="btn btn-success">
                                    <s:text name="label.baixar.relatorio"/>
                                </a>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </div>
            <div class="mb-3">
                <s:url action="navegarFuncionariosExames" var="funcionarios"/>

                <a href="${funcionarios}" class="btn btn-success">
                    <s:text name="label.ir.funcionarios"/>
                </a>

                <s:url action="navegarExamesFuncionarios" var="exames"/>

                <a href="${exames}" class="btn btn-success">
                    <s:text name="label.ir.exames"/>
                </a>
            </div>
        </div>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
