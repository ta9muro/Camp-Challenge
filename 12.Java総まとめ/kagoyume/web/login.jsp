<%-- 
    Document   : login
    Created on : 2016/10/02, 16:22:00
    Author     : takuyamuroyama
--%>

<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログインページ</title>
    </head>
    <body>
        <h1>ログイン</h1>
        <form action="loginCheck" method="GET">
        ユーザー名: <input type="text" name="name"><br>
        パスワード: <input type="password" name="password"><br>
        <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
        <input type="submit" name="btnsubmit" value="ログイン">
        </form>
 
        <br>
        
        <form action="registration" method="POST">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            <input type="submit" name="btnsubmit2" value="新規会員登録">
        </form>
    </body>
</html>
