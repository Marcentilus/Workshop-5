
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Usuwanie</title>
</head>
<body>
<h1>Czy na pewno chcesz usunąć książkę ${title}</h1><br>
<div>
<a href="http://localhost:8080/admin/books/delete/${id}">Usuń</a>
<a href="http://localhost:8080/admin/books/show-list">Anuluj</a>
</div>
  </body>
</html>
