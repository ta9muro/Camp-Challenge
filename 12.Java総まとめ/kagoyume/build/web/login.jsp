<%-- 
    Document   : login
    Created on : 2016/10/02, 16:22:00
    Author     : takuyamuroyama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログインページ</title>
    </head>
    <body>
        <h1>ログイン</h1>
        <form action="login" method="GET">
        ユーザー名: <input type="text" name="name"><br>
        パスワード: <input type="password" name="password"><br>
        <input type="submit" value="login">
        </form>
    </body>
</html>
