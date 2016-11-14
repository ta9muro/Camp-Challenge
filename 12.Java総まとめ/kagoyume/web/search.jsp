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
UserData ud2 = (UserData)session.getAttribute("resultJsonData_2");
int i = 0;

UserData ud3 = UserData.getInstance();
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
        <h2>検索キーワード: <%=ud2.getQuery()%>   
            検索結果数: <%=ud2.getTotalResultsAvailable()%>件
        </h2>
        <table border=1>
            <tr>
                <th colspan="2">商品名</th>
                <th>価格</th>
                
            </tr>
            <% for(i=0; i< ud.size(); i++) { %>
            <tr>
                <td><a href="item?number=<%=i%>"><img src="<%=ud.get(i).getProductPic()%>"></a></td>
                <td><a href="item?number=<%=i%>"><%=ud.get(i).getProductName()%></a></td>
                <td><%=ud.get(i).getPrice()%>円</td>
            </tr>
            <% } %>
        </table>
        <br>
        <%=ud3.login()%>
    </body>
    
</html>
