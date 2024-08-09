<%--
  Created by IntelliJ IDEA.
  User: vitor
  Date: 04/08/2024
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title><s:text name="label.titulo.pagina.edicao.funcionario"/></title>
        <link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
    </head>
    <body class="bg-secondary">

        <div class="container">
            <s:form action="/salvarEdicaoFuncionarios.action">

                <div class="card mt-5">
                    <div class="card-header">
                        <div class="row">
                            <div class="col-sm-5">
                                <s:url action="todosFuncionarios" var="todos"/>
                                <a href="${todos}" class="btn btn-success" >Funcionarios</a>
                            </div>

                            <div class="col-sm">
                                <h5 class="card-title">Editar Funcionario</h5>
                            </div>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="row align-items-center">
                            <label for="id" class="col-sm-1 col-form-label text-center">
                            Código:
                            </label>

                            <div class="col-sm-2">
                                <s:textfield cssClass="form-control" id="id" name="funcionarioVo.rowid" readonly="true"/>
                            </div>
                        </div>

                        <div class="row align-items-center mt-3">
                            <label for="nome" class="col-sm-1 col-form-label text-center">
                                Nome:
                            </label>

                            <div class="col-sm-5">
                                <s:textfield cssClass="form-control" id="nome" name="funcionarioVo.nome" required="required"/>
                            </div>
                        </div>
                    </div>

                    <div class="card-footer">
                        <div class="form-row">
                            <button class="btn btn-primary col-sm-4 offset-sm-1">Salvar</button>
                            <button type="button" class="btn btn-secondary col-sm-4 offset-sm-2" onclick="limparFormulario()">Limpar Formulário</button>
                        </div>
                    </div>
                </div>
            </s:form>
        </div>

        <script>
            function limparFormulario() {
                var campoNome = document.getElementById('nome');
                campoNome.value = '';
            }
        </script>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
