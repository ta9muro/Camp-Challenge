<%-- 
    Document   : buyConfirm
    Created on : 2016/11/06, 15:36:22
    Author     : takuyamuroyama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.UserData"%>
<%@page import="java.util.ArrayList"%>

<%
    HttpSession hs = request.getSession();
    ArrayList<UserData> mycart = (ArrayList<UserData>)session.getAttribute("mycart");
    UserData ud = UserData.getInstance();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>buy confirm page</title>
    </head>
    <body>
        
        <%=ud.login()%>
        
        <h1>購入内容</h1>
        <table border="1">
            <tr>
                <th>商品名</th>
                <th>価格</th>
            </tr>
            
            <%for(int i=0; i<mycart.size(); i++){%>
            <tr>
                <td><%=mycart.get(i).getProductName()%></td>
                <td><%=mycart.get(i).getPrice()%>円</td>
                <% } %>
            </tr>
        </table>
                
                合計金額<%=hs.getAttribute("totalPrice")%>円
                <br><br>
                発送方法
                <form action="buyComplete" method="POST">
                    <% for(int i=1; i<=5; i++) {%>
                    <input type="radio" name="type" value="<%=i%>" checked="checked"><%=UserData.getInstance().selectType(i)%>
                    <% } %>
                    <br><br>
                    <input type="submit" name="btnSubmit" value="上記の内容で購入する">
                </form><br>
                    
                    <form action="cart" method="POST">
                        <input type="submit" name="btnSubmit2" value="カートに戻る">
                    </form>
                    
    </body>
</html>
