<%--
  Created by IntelliJ IDEA.
  User: rafa
  Date: 11.03.2023
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>NewBook</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/books" method="post">
      <label>Uzupełnij pola</label><br>
      <input type="hidden" name="id"/>
      <label for="isbn" id="isbn"/>
      <input type="text" name="isbn" placeholder="wpisz isbn"><br>
      <label for="title" id="title"/>
      <input type="text" name="title" placeholder="wpisz tytuł"><br>
      <label for="author" id="author"/>
      <input type="text" name="author" placeholder="wpisz autora"><br>
      <label for="publisher" id="publisher"/>
      <input type="text" name="publisher" placeholder="wpisz wydawcę"><br>
      <label for="type" id="type"/>
      <input type="text" name="type" placeholder="wpisz typ"><br>
      <input type="submit" value="Wyślij">

  </form>
  </body>
</html>
