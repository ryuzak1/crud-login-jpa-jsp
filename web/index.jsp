<%--
  Created by IntelliJ IDEA.
  User: murilo
  Date: 01/07/2020
  Time: 08:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
  <head>
    <title>Login</title>
    <link rel="stylesheet" href="static/css/style.css"/>
  </head>
  <body>

  <form method="post" action="ServletValidarUsuario">
    <div class="imgcontainer">
      <img src="static/img/img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <%--@declare id="uname"--%>
      <%--@declare id="psw"--%>
      <label for="uname"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="email" id="email" required>
      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="senha" required>
      <button type="submit">Login</button>
    </div>
    <div class="container" style="background-color:#f1f1f1">
      <button type="button" class="cancelbtn">Cancelar</button>
      <span class="psw">Criar <a href="criar-conta.jsp">Conta!</a></span>
    </div>
  </form>

  </body>
</html>
