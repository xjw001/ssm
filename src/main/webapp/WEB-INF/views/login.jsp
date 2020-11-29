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
    <style>
        body{
            background:url("../../static/timg.jpg") no-repeat;
            background-size: 100%;
        }
    </style>

</head>
<body class="parent">


<div class="modal-dialog" style="margin-top: 10%;">
    <div class="modal-content">
        <div class="modal-header">

            <h4 class="modal-title text-center" id="myModalLabel">登录</h4>
        </div>
        <form name="form" method="post" action="/doLogin">
            <div class="modal-body" id = "model-body">
                <div class="form-group">

                    <input type="text" name="userName" class="form-control"placeholder="用户名" autocomplete="off">
                </div>
                <div class="form-group">

                    <input type="password" name="password" class="form-control" placeholder="密码" autocomplete="off">
                </div>
            </div>

            <div class="modal-footer">
                <div class="form-group">
                    <button type="submit" class="btn btn-primary form-control" onclick="">登录</button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-default form-control">注册</button>
                </div>

            </div>
        </form>
    </div><!-- /.modal-content -->
</div><!-- /.modal -->

</body>
</html>
