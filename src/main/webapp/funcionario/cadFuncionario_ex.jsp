<%--
  Created by IntelliJ IDEA.
  User: vitor
  Date: 05/08/2024
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title><s:text name="label.titulo.pagina.exame.funcionario"/></title>
        <link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
    </head>
    <body class="bg-secondary">
        <div class="container">
            <div class="row mt-5 mb-2">
                <div class="col-sm p-0 bg-light border rounded-top text-center">
                     <h1><s:property value="filtro.funcionario.nome"/></h1>
                </div>
            </div>

            <div class="row">
                <table class="table table-light table-striped align-middle">
                    <thead>
                        <tr>
                            <th><s:text name="label.id"/></th>
                            <th><s:text name="label.nome"/></th>
                            <th><s:text name="label.data"/></th>
                            <th class="text-end mt-5"><s:text name="label.acao"/></th>
                        </tr>
                    </thead>

                    <s:iterator value="exames">
                    <tbody>
                            <tr>
                                <td>${rowid}</td>
                                <td>${nome}</td>
                                <td>${dataFormatada}</td>
                                <td class="text-end">
                                    <a href="#" class="btn btn-warning text-white" data-bs-toggle="modal" data-bs-target="#editarExameModal${internoId}"
                                       data-rowid="<s:property value='rowid'/>" data-nome="<s:property value='nome'/>" data-data="<s:property value='data'/>"
                                       data-internoId="<s:property value='internoId'/>">
                                        <s:text name="label.editar"/>
                                    </a>

                                    <s:url action="excluirExameDeFunc" var="excluir">
                                        <s:param name="idIntenoExameExcluir" value="internoId"/>
                                    </s:url>

                                    <a href="#confirmarExclusao${internoId}" class="btn btn-danger" data-bs-toggle="modal">
                                        <s:text name="label.excluir"/>
                                    </a>
                                </td>
                            </tr>
                    </s:iterator>
                    </tbody>

                    <tfoot class="table-secondary">
                        <tr>
                            <td colspan="5">
                                <s:url action="novoExameDeFunc" var="novo"/>

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

                <s:url action="navegarFuncionariosExames" var="funcionarios"/>

                <a href="${funcionarios}" class="btn btn-success">
                    <s:text name="label.ir.funcionarios"/>
                </a>
            </div>
        </div>

        <s:iterator value="exames">
            <div class="modal fade" id="confirmarExclusao${internoId}"
                 data-bs-backdrop="static" data-bs-keyboard="false"
                 tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title"><s:text name="label.modal.titulo"/></h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>

                        <div class="modal-body">
                            <span><s:text name="label.modal.corpo.exame"/></span>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" aria-label="Close">
                                <s:text name="label.nao"/>
                            </button>

                            <a href="<s:url action='excluirExameDeFunc'><s:param name='idIntenoExameExcluir' value='%{internoId}'/></s:url>" class="btn btn-primary" style="width: 75px;">
                                <s:text name="label.sim"/>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </s:iterator>

        <s:iterator value="exames">
            <div class="modal fade" id="editarExameModal${internoId}" tabindex="-1" aria-labelledby="editarExameLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="editarExameLabel">Editar Exame do Funcionário</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <s:form action="editarExameDeFunc" method="post">
                                <input type="hidden" name="exameInclusaoVo.rowid" id="exame_id">
                                <input type="hidden" name="idIntenoExameEditar" id="idInternoExameEditar"/>

                                <div class="mb-3">
                                    <label for="nome" class="form-label">Nome do Exame</label>
                                    <input type="text" class="form-control" id="nome" name="exameInclusaoVo.nome" readonly>
                                </div>

                                <div class="mb-3">
                                    <label for="data" class="form-label">Data do Exame</label>
                                    <input type="date" class="form-control" id="data" name="exameInclusaoVo.data" required>
                                </div>

                                <button type="submit" class="btn btn-primary">Editar</button>
                            </s:form>
                        </div>
                    </div>
                </div>
            </div>
        </s:iterator>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var editarExameModal = document.querySelectorAll('.modal.fade');

                editarExameModal.forEach(function (modal) {
                    modal.addEventListener('show.bs.modal', function (event) {
                        var button = event.relatedTarget;
                        var rowid = button.getAttribute('data-rowid');
                        var nome = button.getAttribute('data-nome');
                        var data = button.getAttribute('data-data');
                        var internoId = button.getAttribute('data-internoId');

                        var modalBodyInputRowid = modal.querySelector('#exame_id');
                        var modalBodyInputNome = modal.querySelector('#nome');
                        var modalBodyInputData = modal.querySelector('#data');
                        var modalBodyInputInternoId = modal.querySelector('#idInternoExameEditar');

                        modalBodyInputRowid.value = rowid;
                        modalBodyInputNome.value = nome;
                        modalBodyInputData.value = data;
                        modalBodyInputInternoId.value = internoId;
                    });
                });
            });
        </script>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
