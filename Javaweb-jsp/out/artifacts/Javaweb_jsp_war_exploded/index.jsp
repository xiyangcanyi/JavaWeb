<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="error/500.jsp" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%-- JSTL表达式
用来将程序的输出到客户端
<%=变量或者表达式%>--%>

<%=new java.util.Date()%>
  <hr>
<%--  jsp脚本片段--%>
  <%
    int sum=0;
    for(int i=1;i<=100;i++){
      sum+=i;
    }
    out.println("<h1>Sum="+sum+"</h1>");
  %>
<%!
  static {
    System.out.println("Loading Servlet!");
  }

  private int globalVar = 0;

  public void kuang(){
    System.out.println("进入了方法Kuang！");
  }
%>
<%
  int i=1/0;
%>
  </body>
</html>
