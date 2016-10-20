<%-- 
    Document   : search
    Created on : 2016/10/01, 17:30:50
    Author     : takuyamuroyama
--%>

<%@page import="java.util.ArrayList"
        import="jums.UserData"
        %>

<%
    ArrayList<UserData> ud = (ArrayList<UserData>)session.getAttribute("resultJsonData");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索結果画面</title>
    </head>
    <body>
        <h1>検索結果画面</h1>
        <table border=1>
            <tr>
                <th>商品名</th>
                <th>価格</th>
                <th>商品画像</th>
            </tr>
            <% for(UserData u: ud) { %>
            <tr>
                <td><%=u.getProductName()%></td>
                
            </tr>
            <% } %>
        
        </table>
    </body>
    
</html>
