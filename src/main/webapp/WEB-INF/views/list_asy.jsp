<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("APP_PATH",request.getContextPath());
    pageContext.setAttribute("APP_URL",request.getRequestURL().toString());
%>
<html>
<head>
    <title>用户列表asy</title>
    <!--
        不以/开始的相对路径，找资源以当前资源的路径为准
        以/开始的相对路径，找资源以服务器的路径为准
    -->
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- 用户新增模态框 -->
<div class="modal fade" id="userAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">用户新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="uname" class="col-sm-2 control-label">用户姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="uname" name="uname">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addr" class="col-sm-2 control-label">用户地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="addr"  name="addr">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="deptId" class="col-sm-2 control-label">所属部门</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="deptId" id="deptId">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                        </div>
                    </div>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-offset-2 col-sm-10">--%>
<%--                            <div class="checkbox">--%>
<%--                                <label>--%>
<%--                                    <input type="checkbox"> Remember me--%>
<%--                                </label>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="btn_save">保存</button>
            </div>
        </div>
    </div>
</div>

    <div class="container">
        <!--标题-->
        <div class="row">
            <div class="col-md-12">
                <h1>SSM-增删改查asy</h1>
            </div>
        </div>
        <!--按钮-->
        <div class="row">
            <div class="col-md-4 col-md-offset-8">
                <button class="btn btn-primary" id="add_btn">新增</button>
                <button class="btn btn-danger">删除</button>
            </div>
        </div>
        <!--表格-->
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover" id="user_table">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>用户编号</th>
                            <th>地址</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>

            </div>
        </div>
        <!--分页-->
        <div class="row">
            <!--分页文字信息-->
            <div class="col-md-6" id="page_info_area">

            </div>
            <!--分页条信息-->
            <div class="col-md-6" id="nav_area">

            </div>
        </div>
    </div>
<script type="text/javascript">
    $(function(){
        to_page(1);
    });

    function to_page(pn){
        $.ajax(
            {
                url:"${APP_PATH}/user/getAllUserJson",
                data:"pageNum="+pn,
                type:"get",
                datatype: "json",
                success:function (jsonstr) {
                    result = $.parseJSON(jsonstr);
                    build_user(result);
                    build_page(result);
                    build_nav(result);
                }
            }
        )
    }
    
    function build_user(result){
        $("#user_table tbody").empty();
        var users = result.data.pageInfo.list;
        $.each(users,function (index,item) {
            //alert(item.uname);
            var uid = $("<td></td>").append(item.uid);
            var uname = $("<td></td>").append(item.uname);
            var uaddr = $("<td></td>").append(item.addr);
            var uCreatetime = $("<td></td>").append(item.createtime);
            var optBtn = $("<td></td>");
            var addBtn = $("<button></button>").addClass("btn btn-primary btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
            var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
            optBtn.append(addBtn).append(" ").append(delBtn)
            $("<tr></tr>").append(uid)
                .append(uname)
                .append(uaddr)
                .append(uCreatetime)
                .append(optBtn).appendTo("#user_table tbody");
        })
    }

    
    function build_page(result) {
        $("#page_info_area").empty();
        var pageInfo = result.data.pageInfo;
        var pageNum = pageInfo.pageNum;
        var pages = pageInfo.pages;
        var total = pageInfo.total;
        $("#page_info_area").append("当前第"+pageNum+"页，总共"+pages+"页，总共"+total+"记录");
    }

    function build_nav(result) {
        $("#nav_area").empty();
        var pageInfo = result.data.pageInfo;
        var ul = $("<ul></ul>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if(!pageInfo.hasPreviousPage){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            firstPageLi.click(function (){
                to_page(1);
            });
            prePageLi.click(function (){
                to_page(pageInfo.pageNum -1);
            });
        }

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if(!pageInfo.hasNextPage){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            nextPageLi.click(function (){
                to_page(pageInfo.pageNum +1);
            });
            lastPageLi.click(function (){
                to_page(pageInfo.pages);
            });
        }
        //1,2,3,4,5
        ul.append(firstPageLi).append(prePageLi);
        var navigatepageNums = result.data.pageInfo.navigatepageNums;
        $.each(navigatepageNums,function (index,item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if(pageInfo.pageNum == item){
                numLi.addClass("active");
            }
            numLi.click(function(){
                to_page(item);
            });
            ul.append(numLi);
        });
        ul.append(nextPageLi).append(lastPageLi);
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#nav_area");
    }


    //新增按钮事件
    $("#add_btn").click(function () {
        $("#userAddModal").modal({
            backdrop:"static"
        });
    });

    $("#btn_save").click(function () {

    });
    function saveBaseInfo() {

    }

    //查询部门信息
    function getDept(){
        $.ajax({
            url:"${APP_PATH}/depts",
            type:"GET",
            success:function (result) {
                console.log(result);
                //$("#userAddModal select").append();
            }
        });
    }
</script>
</body>
</html>
