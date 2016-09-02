<%-- 
    Document   : index
    Created on : 2016/08/27, 15:23:26
    Author     : takuyamuroyama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>takuzon</title>
    </head>
    <body>
        <h1>Welcome to Takuzon!</h1>
        <form action="Login" method="post">
            ユーザー名:<input type="text" name="name"><br>
            パスワード:<input type="password" name="pass"><br>
            <input type="submit" value="login">
        </form>
    </body>
</html>
