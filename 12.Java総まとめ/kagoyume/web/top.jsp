<%-- 
    Document   : top
    Created on : 2016/10/01, 17:44:54
    Author     : takuyamuroyama
--%>

<%@page import="jums.UserData"
        %>

<%
    UserData ud = UserData.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Top Page</title>
    </head>
    <body>
        <h1>カゴいっぱいの夢</h1>
        <h3>金額取引が絶対に発生しない、お金のことを考えずに好きなだけ買い物ができる<br>
            いくらでもどんなものでも購入するECサイトです。<br>
            ストレス発散に、どうぞお使い下さい。</h3>
        <form action="search" method="GET">
        Yahoo shopping商品検索
            <input type="text" name="searchword">
            <input type="submit" name="btnSubmit" value="検索">
        </form>
        <br>
        <%=ud.login()%> 
    </body>
</html>
