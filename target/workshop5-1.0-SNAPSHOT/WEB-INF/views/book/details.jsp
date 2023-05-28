<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>

    <title>Book List</title>

</head>

<body>
<form:form action="/admin/books/book-details?search" method="GET" modelAttribute="book">
    <a href="http://localhost:8080/admin/books/add">Dodaj książkę</a>
    <label for="search" id="searchLabel">Wyszukaj:</label>
    <input type="search" name="search" id="search"/>
    <input type="submit" value="search">
</form:form><br>


<table border="1"><br>

    <thead>

    <th>isbn</th>

    <th>title</th>

    <th>author</th>

    <th>publisher</th>

    </thead>

    <tbody>


        <tr>
            <td><c:out value="${book.id}"/></td>

            <td><c:out value="${book.isbn}"/></td>

            <td><c:out value="${book.title}"/></td>

            <td><c:out value="${book.author}"/></td>

            <td><c:out value="${book.publisher}"/></td>

            <td><c:out value="${book.type}"/></td>

            <td><a href="http://localhost:8080/admin/books/edit/${book.id}">Edytuj książkę</a></td>
            <td><a href="http://localhost:8080/admin/books/confirm-cancel/${book.id}/${book.title}">Usuń książkę</a></td>
        </tr>



    </tbody>

</table>

</body>

</html>