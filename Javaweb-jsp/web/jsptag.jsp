<%--
  Created by IntelliJ IDEA.
  User: 赵耀鹏
  Date: 2022/3/15
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:forward page="jsptag2.jsp">
    <jsp:param name="name" value="zyp"/>
    <jsp:param name="age" value="10"/>
</jsp:forward>
</body>
</html>
