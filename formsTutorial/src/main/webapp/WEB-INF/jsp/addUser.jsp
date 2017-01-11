<%--
  Created by IntelliJ IDEA.
  User: davidronaldson
  Date: 10/01/2017
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<form:form method="POST" modelAttribute="defaultUser" enctype="multipart/form-data">
    <form:input path="firstname"/>
    <form:errors path="firstname" cssClass="error"></form:errors>
    <form:input path="age"/>
    <form:errors path="age" cssClass="error"></form:errors>
    <form:select path="country" items="${countries}"/>
    <form:checkbox path="married"/>
    <input type="file" name="file"
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
