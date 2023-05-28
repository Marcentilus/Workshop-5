
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodawanie książki</title>
</head>
<body>
<h3>Formularz dodawania książki</h3><br>
<br>
<div>
    <form:form method="post" modelAttribute="book">
        <p>Podaj autora</p><br>
        <form:input path="author"/><br>
        <form:errors path="author" cssClass="error"/><br>
        <p>Podaj ISBN</p><br>
        <form:input path="isbn"/><br>
        <form:errors path="isbn" cssClass="error"/><br>
        <p>Podaj wydawcę</p><br>
        <form:input path="publisher"/><br>
        <form:errors path="publisher" cssClass="error"/><br>
        <p>Podaj tytuł</p><br>
        <form:input path="title"/><br>
        <form:errors path="title" cssClass="error"/><br>
        <p>Podaj typ</p>
        <form:input path="type"/><br>
        <form:errors path="type" cssClass="error"/><br>
        <input type="submit" value="Zapisz">

    </form:form>
</div>

  
  </body>
</html>
