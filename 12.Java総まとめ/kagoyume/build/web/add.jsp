<%-- 
    Document   : add
    Created on : 2016/10/30, 16:01:46
    Author     : takuyamuroyama
--%>
<%@page import="jums.UserData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    UserData ud = UserData.getInstance();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>カート追加ページ</title>
    </head>
    <body>
        <%=ud.login()%><br>
        <h1>カート追加完了</h1><br>
        <a href="cart">カートへ</a>
    </body>
</html>
