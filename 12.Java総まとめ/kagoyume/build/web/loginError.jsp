<%-- 
    Document   : loginError
    Created on : 2016/11/13, 17:51:53
    Author     : takuyamuroyama
--%>
<%@page import="jums.UserData"%>

<%
    UserData ud = UserData.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login error page</title>
    </head>
    <body>
        <%=ud.top()%>
        <h1>ログイン失敗</h1>
        
        <form action="login" method="POST">
            <input type="submit" name="backpage" value="戻る">
        </form>
    </body>
</html>
