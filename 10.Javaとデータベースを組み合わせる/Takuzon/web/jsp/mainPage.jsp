<%-- 
    Document   : mainPage
    Created on : 2016/08/28, 14:23:20
    Author     : takuyamuroyama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlet.MainPage, model.Product" %>
<%@page import="java.util.ArrayList" %>

<%
    //セッションスコープからインスタンスを取得
    ArrayList<Product> ap = (ArrayList<Product>)session.getAttribute("productData");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
    </head>
    <body>
        <h1>商品登録</h1>
        <form action="/Takuzon/MainPage" method="post">
        商品コード: <input type="text" name="code"><br>
        商品名: <input type="text" name="name"><br>
        カテゴリ: <input type="text" name="category"><br>   
        価格: <input type="text" name="price"><br>
        数量: <input type="text" name="quantity"><br>
        登録者: <input type="text" name="user"><br>
        <input type="submit" value="登録"><br>
        </form>
        <a href="/Takuzon/Logout">ログアウト</a>
    </body>
</html>
