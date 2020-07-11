<%--
  Created by IntelliJ IDEA.
  User: murilo
  Date: 01/07/2020
  Time: 08:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
    <link rel="stylesheet" href="static/css/style.css"/>
  </head>
  <body>

  <form action="ServletCadastrarUsuario" method="post">
    <div class="imgcontainer">
      <img src="static/img/img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <%--@declare id="uname"--%>
      <%--@declare id="psw"--%>
      <label for="uname"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="email" value="${usuario.email}" required>
      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="senha" value="${usuario.senha}" required>
        <label ><b>Nome</b></label>
        <input type="text" placeholder="Seu nome" name="nome" value="${usuario.nome}"required>
      <button type="submit">Salvar</button>
    </div>
    <div class="container" style="background-color:#f1f1f1">
      <span class="psw">Voltar <a href="index.jsp">Login!</a></span>
    </div>
  </form>
  </body>
</html>
