<%-- 
    Document   : productList
    Created on : 2016/08/31, 20:24:46
    Author     : takuyamuroyama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Product, servlet.MainPage" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<Product> productList = (ArrayList<Product>)session.getAttribute("productData");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List Page</title>
    </head>
    <body>
        <h1>商品登録一覧</h1><br>
        <table border="1" width="500" cellspacing="0" cellpadding="5">
            <tr>
                <th align="center" valign="middle"><font color="2e8b57">商品コード</font></th>
                <th align="center" valign="middle"><font color="2e8b57">商品名</font></th>
                <th align="center" valign="middle"><font color="2e8b57">カテゴリ</font></th>
                <th align="center" valign="middle"><font color="2e8b57">価格</font></th>
                <th align="center" valign="middle"><font color="2e8b57">数量</font></th>
                <th align="center" valign="middle"><font color="2e8b57">登録者</font></th>
            </tr>
            
            <%
                for(int i=0; i<productList.size(); i++){
                    Product dbData = productList.get(i);
                    
                    out.println("<tr><td>" + dbData.getCode() + "</td>");
                    out.println("<td>" + dbData.getName() + "</td>");
                    out.println("<td>" + dbData.getCategory() + "</td>");
                    out.println("<td>" + dbData.getPrice() + "</td>");
                    out.println("<td>" + dbData.getQuantity() + "</td>");
                    out.println("<td>" + dbData.getUser() + "</td></tr>");
                }
            %>
        </table>
        
        <a href="jsp/mainPage.jsp">続けて登録する</a><br>
        <a href="/Takuzon/Logout">ログアウト</a>
    </body>
</html>
