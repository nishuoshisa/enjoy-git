<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 胡梦娟
  Date: 2018/11/21
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生列表</title>
    <script type="application/javascript" src="/js/jquery-3.0.0.js"></script>
    <script type="application/javascript" src="/js/bootstrap-3.3.4.js"></script>
    <script type="application/javascript" src="/js/jqPaginator.js"></script>
    <link rel="stylesheet" href="/css/bootstrap-3.3.4.css">

</head>
<body>
<form action="/student" method="post" id="frm">
    学生名：<input type="text" name="name" id="name" value="${name}">
    学生年龄：<input type="text" name="age"   id="age" value="${age}">
    <input type="hidden" name="pageNum" id="pageNum">
    <input type="submit"  value="查询"  >
</form>
<div class="container">
    <a href="/student/add">新增学生</a>  </div>
<table class="table">
    <thead>
        <tr>
            <th>学生id</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>密码</th>
            <th>操作</th>
        </tr>
    </thead>
    <c:forEach items="${pageInfo.list}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.age}</td>
            <td>${s.password}</td>
            <td><a class="btn btn-success" href="/student/getStudentById/${s.id}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
                <a class="btn btn-danger" href="/student/deleteStudent/${s.id}">删除</a> </td>
        </tr>
    </c:forEach>

</table>
    <div class="pagination-layout">

        <div class="pagination">
            <ul class="pagination">

            </ul>


        </div>
    </div>

    <script type="application/javascript">
        window.onload = function() {
            var if_firstime = true;
            $(".pagination")
                .jqPaginator(
                    {
                        totalPages : ${pageInfo.pages},
                        visiblePages : 4,
                        currentPage : ${pageInfo.pageNum},
                        first : '<li class="first"><a href="javascript:void(0);">第一页</a></li>',
                        prev : '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
                        next : '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
                        last : '<li class="last"><a href="javascript:void(0);">最后一页</a></li>',
                        page : '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',

                        onPageChange : function(num) {

                            if (if_firstime) {
                                if_firstime = false;
                            } else if (!if_firstime) {
                                changePage(num);
                            }
                        }

                    })

        }
        function changePage(num) {
            $("#pageNum").val(num);
            $("#frm").submit();
        }


    </script>
</body>
</html>
