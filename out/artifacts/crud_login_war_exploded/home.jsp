<%--
  Created by IntelliJ IDEA.
  User: murilo
  Date: 06/07/2020
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>Sistema</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>Bem Vindo ao sistema!  <c:out value="${nomeUsuario}"/></h1>


<table>
    <c:forEach items="${listadeusuarios}" var="user">
        <tr >
            <td >
                <c:out value="${user.nome}"/>
            </td>
            <td>
                <c:out value="${user.email}"/>
            </td>
            <td>
                <c:out value="${user.senha}"/>
            </td>
            <td><a href="ServletControlerUsuario?acao=editar&email=${user.email}">EDIDAR</a></td>
            <td><a href="ServletControlerUsuario?acao=deletar&email=${user.email}">EXCLUIR</a></td>


        </tr>






    </c:forEach>




</table>





</body>
</html>
