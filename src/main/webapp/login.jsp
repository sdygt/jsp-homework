<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<s:form action="login">
    <s:textfield name="userBean.username" label="username" />
    <s:textfield name="userBean.password" label="password" />
    <s:submit/>
</s:form>
</body>
</html>
