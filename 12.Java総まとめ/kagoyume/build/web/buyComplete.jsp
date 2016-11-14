<%-- 
    Document   : buyComplete
    Created on : 2016/11/06, 17:43:01
    Author     : takuyamuroyama
--%>
<%@page import="jums.UserData"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.ArrayList"%>

<%
    UserData ud = UserData.getInstance();
    //HttpSession hs = request.getSession();
    //ArrayList<UserData> mycart = (ArrayList<UserData>)hs.getAttribute("mycart");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>buyconfirm page</title>
    </head>
    <body>
        <%=ud.login()%><br>
        <h1>購入が完了しました</h1><br>
        
        <%=ud.top()%>
    </body>
</html>
