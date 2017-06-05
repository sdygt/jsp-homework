<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Register</title>
</head>
<body>
<h2>Register </h2>

<s:form action="register">
    <s:textfield name="userBean.username" label="username"/>
    <s:textfield name="userBean.password" label="password"/>
    <s:submit/>
</s:form>
</body>
</html>
