<%-- 
    Document   : item
    Created on : 2016/10/08, 13:05:25
    Author     : takuyamuroyama
--%>

<%@page import="java.util.ArrayList"
        import="jums.UserData"
        %>

<%
    UserData ud = (UserData)session.getAttribute("ud");
    UserData ud2 = UserData.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品詳細ページ</title>
    </head>
    <body>
        <%=ud.login()%><br>
        <h1>商品詳細</h1>
        <table border="1">
            <tr>
                <th colspan="2">商品名</th>
                <th>価格</th>
                <th>概要</th>
                <th>評価レート</th>
                <th>評価数</th>
            </tr>
            <tr>
                <td><img src="<%=ud.getProductPic()%>" alt=""></td><br>
                <td><%=ud.getProductName()%></td><br>
                <td><%=ud.getPrice()%>円</td><br>
                <td><%=ud.getDescription()%></td><br>
                <td><%=ud.getReviewRate()%></td><br>
                <td><%=ud.getReviewCount()%></td><br>
            </tr>
        </table>
        <form action="add" method="POST">
            <input type="submit" name="add" value="カートに追加" style="width:100px">
            <input type="hidden" name="mode" value="REINPUT">
        </form>
    </body>
</html>

        