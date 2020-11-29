<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("APP_PATH",request.getContextPath());
    pageContext.setAttribute("APP_URL",request.getRequestURL().toString());
%>
<html>
<head>
    <title>用户列表</title>
    <!--
        不以/开始的相对路径，找资源以当前资源的路径为准
        以/开始的相对路径，找资源以服务器的路径为准
    -->
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <!--标题-->
        <div class="row">
            <div class="col-md-12">
                <h1>SSM-增删改查</h1>
            </div>
        </div>
        <!--按钮-->
        <div class="row">
            <div class="col-md-4 col-md-offset-8">
                <button class="btn btn-primary">新增</button>
                <button class="btn btn-danger">删除</button>
            </div>
        </div>
        <!--表格-->
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover">
                    <tr>
                        <th>#</th>
                        <th>用户编号</th>
                        <th>地址</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    <C:forEach items="${pageInfo.list}" var="user">
                        <tr>
                            <th>${user.uid}</th>
                            <th>${user.uname}</th>
                            <th>${user.addr}</th>
                            <th>${user.createtime}</th>
                            <th>
                                <button class="btn btn-primary btn-sm">
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                    编辑
                                </button>
                                <button class="btn btn-danger btn-sm">
                                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                    删除
                                </button>
                            </th>
                        </tr>
                    </C:forEach>
                </table>

            </div>
        </div>
        <!--分页-->
        <div class="row">
            <!--分页文字信息-->
            <div class="col-md-6">
                当前第${pageInfo.pageNum}页，总共${pageInfo.pages}页，总共${pageInfo.total}记录
            </div>
            <!--分页条信息-->
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="${APP_PATH}/user/getAllUser?pageNum=1">首页</a>
                        </li>
                        <!--上一页-->
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <li>
                                <a href="${APP_PATH}/user/getAllUser?pageNum=${pageInfo.pageNum -1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                            <c:if test="${page_num == pageInfo.pageNum}">
                                <li class="active"><a href="#">${page_num}</a></li>
                            </c:if>
                            <c:if test="${page_num != pageInfo.pageNum}">
                                <li><a href="${APP_PATH}/user/getAllUser?pageNum=${page_num}">${page_num}</a></li>
                            </c:if>
                        </c:forEach>
                        <!--下一页-->
                        <c:if test="${pageInfo.hasNextPage}">
                            <li>
                                <a href="${APP_PATH}/user/getAllUser?pageNum=${pageInfo.pageNum + 1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <li>
                            <a href="${APP_PATH}/user/getAllUser?pageNum=${pageInfo.pages}">末页</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</body>
</html>
