
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List - Contacts</title>
</head>
<body>

<div>

    <form action = "/contacts_war_exploded/contacts" method = "POST">
        First Name: <input type = "text" name = "first_name">
        <br />
        Last Name: <input type = "text" name = "last_name" />
        <input type = "submit" value = "Submit" />
    </form>

    <table>
        <h2>Contatos Cadastrados</h2>
        <tbody>
        <tr>
            <th scope="col">Email</th>
            <th scope="col">Nome</th>
        </tr>

        <jsp:useBean id="contatos" scope="request" type="java.util.List"/>
        <c:forEach items="${contatos}" var="contato">
            <tr>
                <td style="widht: 150px"><c:out value="${contato.email}"></c:out></td>
                <td style="widht: 150px"><c:out value="${contato.name}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
