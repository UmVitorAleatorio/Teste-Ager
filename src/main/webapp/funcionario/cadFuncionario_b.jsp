<%--
  Created by IntelliJ IDEA.
  User: vitor
  Date: 04/08/2024
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title><s:text name="label.titulo.pagina.consulta.funcionario"/></title>
        <link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
    </head>
    <body class="bg-secondary">
        <div class="container">
            <div class="row mt-5 mb-2">
                <div class="col-sm p-0">
                    <s:form action="/filtrarFuncionarios.action">
                        <div class="input-group">
                            <span class="input-group-text">
                                <strong><s:text name="label.buscar.por"/></strong>
                            </span>
                            <s:select
                                    cssClass="form-select"
                                    name="filtrar.opcoesCombo"
                                    list="listaOpcoesCombo"
                                    headerKey=""
                                    headerValue="Escolha..."
                                    listKey="%{codigo}"
                                    listValueKey="%{descricao}"
                                    value="filtrar.opcoesCombo.codigo"
                            />

                            <s:textfield cssClass="form-control" id="nome" name="filtrar.valorBusca"/>
                            <button class="btn btn-primary" type="submit"><s:text name="label.pesquisar"/></button>
                        </div>
                    </s:form>
                </div>
            </div>

            <div class="row">
                <table class="table table-light table-striped align-middle">
                    <thead>
                        <tr>
                            <th><s:text name="label.id"/></th>
                            <th><s:text name="label.nome"/></th>
                            <th class="text-end mt-5"><s:text name="label.acao"/></th>
                        </tr>
                    </thead>

                    <tbody>
                        <s:iterator value="funcionarios">
                            <tr>
                                <td>${rowid}</td>
                                <td>${nome}</td>
                                <td class="text-end">
                                    <s:url action="exameFuncionarios" var="exame">
                                        <s:param name="funcionarioVo.rowid" value="rowid"/>
                                        <s:param name="funcionarioVo.nome" value="nome"/>
                                    </s:url>

                                    <a href="${exame}" class="btn btn-info text-white">
                                        <s:text name="label.exames"/>
                                    </a>

                                    <s:url action="editarFuncionarios" var="editar">
                                        <s:param name="funcionarioVo.rowid" value="rowid"/>
                                    </s:url>

                                    <a href="${editar}" class="btn btn-warning text-white">
                                        <s:text name="label.editar"/>
                                    </a>

                                    <s:url action="excluirFuncionarios" var="excluir">
                                        <s:param name="funcionarioVo.rowid" value="rowid"/>
                                    </s:url>

                                    <a href="#confirmarExclusao${rowid}" class="btn btn-danger" data-bs-toggle="modal">
                                        <s:text name="label.excluir"/>
                                    </a>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>

                    <tfoot class="table-secondary">
                        <tr>
                            <td colspan="3">
                                <s:url action="novoFuncionarios" var="novo"/>

                                <a href="${novo}" class="btn btn-success">
                                    <s:text name="label.novo"/>
                                </a>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </div>
            <div>
                <s:url action="navegarExamesFuncionarios" var="exames"/>

                <a href="${exames}" class="btn btn-success">
                    <s:text name="label.ir.exames"/>
                </a>

            </div>
        </div>

        <s:iterator value="funcionarios">
            <div class="modal fade" id="confirmarExclusao${rowid}"
                 data-bs-backdrop="static" data-bs-keyboard="false"
                 tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title"><s:text name="label.modal.titulo"/></h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>

                        <div class="modal-body">
                            <span><s:text name="label.modal.corpo.funcionario"/></span>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" aria-label="Close">
                                <s:text name="label.nao"/>
                            </button>

                            <a href="<s:url action='excluirFuncionarios'><s:param name='funcionarioVo.rowid' value='%{rowid}'/></s:url>" class="btn btn-primary" style="width: 75px;">
                                <s:text name="label.sim"/>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </s:iterator>

        <script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
