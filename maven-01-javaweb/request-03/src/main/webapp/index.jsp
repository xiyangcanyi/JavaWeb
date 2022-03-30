<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
<div style="text-align: center">
<%--    required--%>
    <form action="${pageContext.request.contextPath}/login" method="get">
        用户名：<input type="text" name="username" required><br>
        密&nbsp&nbsp&nbsp&nbsp码：<input type="password" name="password" required><br>
        爱好：
        <input type="checkbox" name="hobby" value="编程" checked>编程
        <input type="checkbox" name="hobby" value="女生">女生
        <br>
        <input type="submit" value="登录">
    </form>

</div>

</body>
</html>
