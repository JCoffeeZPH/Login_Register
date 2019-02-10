<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/10
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <title>注册界面</title>
    <style type="text/css">
        body{
            background-repeat: no-repeat;
            background-position: center;
        }
    </style>
    <script type="text/javascript">
        function ajax(){
            var ajax = new XMLHttpRequest();
            var username = document.getElementById("username").value;
            var url = "Ajax_Servlet";
            ajax.open("post",url,true);
            ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            ajax.onreadystatechange = function(){
                if(ajax.readyState == 4 && ajax.status == 200){
                    var text = ajax.responseText;
                    var spanText = document.getElementById("checkusername");
                    spanText.innerHTML = text;
                }
            }
            ajax.send("username=" + username);
        }
    </script>
</head>
<body>
<div style="text-align:center;margin-top: 120px">
    <form action="/RegisterServlet" method="post">
        <table style="margin-left:40%">
            <caption>用户注册</caption>
            <tr>
                <td>用户名：</td>
                <td><input name="username" type="text" size="20" id="username" onblur="ajax();"><span id="checkusername"></span></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input name="password" type="password" size="20"></td>
            </tr>
            <tr>
                <td>手机号码:</td>
                <td><input name="phonenumber" type="text" size="20"></td>
            </tr>
            <tr>
                <td>身份证号：</td>
                <td><input name="idnumber" type="text" size="20"></td>
            </tr>
        </table>
        <input type="submit" value="注册">
        <input type="reset" value="重置">
    </form>
    <br>
    <a href="/login.jsp">登录</a>
    </form>
</div>
</body>
</html>
