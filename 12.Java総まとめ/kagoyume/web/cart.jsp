<%--
    Document   : cart
    Created on : 2016/11/03, 23:12:45
    Author     : takuyamuroyama
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.UserData"%>
<%
    ArrayList<UserData> mycart = (ArrayList<UserData>)session.getAttribute("mycart");
    int cartTotal =0;
    
    UserData ud = UserData.getInstance();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=ud.login()%><br>
        <h1>マイカート中身</h1>
        <table border="1">
            <tr>
            <th colspan="2">商品</th>
            <th>価格</th>
            <th></th>
            </tr>
            
            <%for(int i=0; i<mycart.size(); i++) {%>
            <tr>
            <td><img src="<%=mycart.get(i).getProductPic()%>" alt=""></td>
            <td><%=mycart.get(i).getProductName()%>
            <td><%=mycart.get(i).getPrice()%>円</td>
            <td>
                <form action="Cart" method="POST">
                    <input type="submit" name="btnsubmit" value="削除">
                    <input type="hidden" name="delete" value="delete">
                </form>
            </td>
            </tr>
            
            <%cartTotal += Integer.valueOf(mycart.get(i).getPrice());%>
            
            <% } %>
        </table>
        
        <% if(cartTotal !=0){ %>
        合計金額<%=cartTotal%>円
        <form action="buyConfirm">
            <input type="submit" name="btnsubmit" value="購入画面へ">
        </form><br>
        
        <%}else{%>
        カートに中身がありません。
        <% } %>
    
    </body>
</html>
