<%--<%@page contentType="text/html; Charset=UTF-8" language="java" %>--%>
<%@page pageEncoding="UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="${pageContext.request.contextPath}/login" method="get">
    用户名：<input type="text" name="username"><br>
    密&nbsp&nbsp码:<input type="password" name="password"><br>
    <input type="submit">
</form>
</body>
</html>
