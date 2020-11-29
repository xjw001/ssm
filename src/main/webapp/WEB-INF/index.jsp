<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/5/1
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="static/js/jquery-1.11.3.min.js"></script>
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
    <div align="middle">
        <button type="button" class="btn btn-primary" onclick="window.location.href = '${pageContext.request.contextPath}/user/getAllUser'">查询-同步</button>
        <button type="button" class="btn btn-primary" onclick="window.location.href = '${pageContext.request.contextPath}/user/getAllUserAsy'">查询-异步</button>
    </div>
</body>
</html>
