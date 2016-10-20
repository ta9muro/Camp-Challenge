<%-- 
    Document   : registrationconfirm
    Created on : 2016/10/02, 19:10:07
    Author     : takuyamuroyama
--%>
<%@page import="jums.UserData"
        import="javax.servlet.http.HttpSession"
        %>

<%
    HttpSession hs = request.getSession();
    UserData ud = (UserData)hs.getAttribute("ud");
    
    


%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規会員登録確認ページ</title>
    </head>
    <body>
        <h1>新規会員登録確認</h1>
        ユーザー名: <%= ud.getName()%><br>
        パスワード: <%= ud.getPassword()%><br>
        メールアドレス: <%= ud.getMail()%><br>
        住所: <%=ud.getAddress()%>
        上記の内容で登録します。よろしいですか？
        <form action="registrationcomplete" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>
        
        <form action="registration" method="POST">
            <input type="submit" name="no" value="いいえ">
            <input type="hidden" name="mode" value="REINPUT">
        </form>
    </body>
</html>
