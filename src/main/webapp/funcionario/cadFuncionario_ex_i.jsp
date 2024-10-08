<%--
  Created by IntelliJ IDEA.
  User: vitor
  Date: 07/08/2024
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title><s:text name="label.titulo.pagina.adicionar.exame.funcionario"/></title>
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
                            <th class="text-end mt-5"><s:text name="label.acao"/></th>
                        </tr>
                    </thead>

                    <tbody>
                        <s:iterator value="examesCadastrados">
                            <tr>
                                <td>${rowid}</td>
                                <td>${nome}</td>
                                <td class="text-end">
                                    <a href="#" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#novoExameModal" data-rowid="${rowid}" data-nome="${nome}">
                                        <s:text name="label.adicionar.exame.funcionario"/>
                                    </a>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
                <div class="row">
                    <div>
                        <s:url action="todosExameDeFunc" var="voltarTodos"/>
                        <a href="${voltarTodos}" class="btn btn-primary">Voltar para os exames de <s:property value="filtro.funcionario.nome"/></a>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="novoExameModal" tabindex="-1" aria-labelledby="novoExameLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="novoExameLabel"><s:text name="label.titulo.modal.adicionar.exame.funcionario"/></h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <s:form action="/addExameDeFunc.action">
                            <input type="hidden" name="exameInclusaoVo.rowid" id="exame_id">
                            <div class="mb-3">
                                <label for="exame_nome" class="form-label"><s:text name="label.nome.do.exame"/></label>
                                <input type="text" class="form-control" id="exame_nome" name="exameInclusaoVo.nome" readonly>
                            </div>
                            <div class="mb-3">
                                <label for="data" class="form-label"><s:text name="label.data.do.exame"/></label>
                                <s:textfield type="date" pattern="yyyy-MM-dd" cssClass="form-control" id="data" name="exameInclusaoVo.data" required="required"/>
                            </div>
                            <button type="submit" class="btn btn-primary"><s:text name="label.adicionar.exame.funcionario"/></button>
                        </s:form>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="alertaModal" tabindex="-1" aria-labelledby="alertaModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="alertaModalLabel"><s:text name="label.titulo.modal.alerta.exame.funcionario"/></h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <s:actionerror/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal"><s:text name="label.fechar.alerta"/></button>
                    </div>
                </div>
            </div>
        </div>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                <s:if test="hasActionErrors()">
                    var alertaModal = new bootstrap.Modal(document.getElementById('alertaModal'));
                    alertaModal.show();
                </s:if>
            });
        </script>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var novoExameModal = document.getElementById('novoExameModal');
                novoExameModal.addEventListener('show.bs.modal', function (event) {
                    var button = event.relatedTarget;
                    var rowid = button.getAttribute('data-rowid');
                    var nome = button.getAttribute('data-nome');

                    var modalTitle = novoExameModal.querySelector('.modal-title');
                    var inputRowid = novoExameModal.querySelector('#exame_id');
                    var inputNome = novoExameModal.querySelector('#exame_nome');

                    inputRowid.value = rowid;
                    inputNome.value = nome;
                });
            });
        </script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
    </body>
</html>
