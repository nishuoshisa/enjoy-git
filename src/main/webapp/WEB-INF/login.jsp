<%--
  Created by IntelliJ IDEA.
  User: 胡梦娟
  Date: 2018/11/21
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
    <script type="application/javascript" src="/js/jquery-3.0.0.js"></script>
    <script type="application/javascript" src="/js/bootstrap-3.3.4.js"></script>
    <link rel="stylesheet" href="/css/bootstrap-3.3.4.css">
</head>


<body>
<div class="container">
<form action="/student" method="post" id="formlogin">
<div class="input-group">
    <label>用户名:</label>
    <input class="form-control" name="sname" id="name">
</div>
    <div class="input-group">
        <label>用户密码:</label>
        <input class="form-control" name="password" id="password">
    </div>
<input type="button" onclick="checkLogin()" value="提交">
</form>
</div>
<script type="application/javascript">
    function checkLogin() {
        var name=$("#name").val();
        var password=$("#password").val();
        var student={};
        student.name=name;
        student.password=password;
        $.ajax({
            type:'post',
            url:'/login/checkLogin',
            data:student,
            dataType:'json',
            success:function (result) {
               if(result.code==400){
                   alert(result.msg);
                   return;
               }
               if(result.code==200){
                   alert(result.msg);
                   $("#formlogin").submit();
               }
            },
            error:function () {
                alert("网络异常，请稍后再试")
            }
        })

    }
</script>
</body>
</html>
