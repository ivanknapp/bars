<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html>
<html>
<head>
    <%--<%@ page isELIgnored="false" %>--%>
    <%--<meta charset="UTF-8">--%>
    <title>Spring 5 MVC - Hello World Example</title>
</head>
<body>
    <h2>${bar.id}</h2>
    <h2>${bar.name}</h2>
    <h4>district is : ${bar.district}</h4>
    <h4>address is : ${bar.address}</h4>
</body>
</html>