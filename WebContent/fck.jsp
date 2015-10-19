 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>FCKeditor.java2.4 for FCKeditor2.6.3Beate text</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="../fckeditor/fckconfig.js"></script>

</head>
<body>
    <form action="result.jsp" method="post">
    <FCK:editor instanceName="bruce">
    <jsp:attribute name="value">
    请输入您的内容.....
    </jsp:attribute>
</FCK:editor>
<input type="submit" value="提交">
    </form>
    
</body>
</html>