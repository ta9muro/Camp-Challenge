<%-- 
    Document   : registrationcomlete
    Created on : 2016/10/02, 18:31:29
    Author     : takuyamuroyama
--%>
<%@page import="jums.UserData"
        import="javax.servlet.http.HttpSession"
        %>

<%
    //HttpSession hs = request.getSession();
    //UserData ud = (UserData)hs.getAttribute("ud");
    UserData ud = (UserData)request.getAttribute("ud");
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
        住所: <%=ud.getAddress()%><br>
        以上の内容で登録しました。<br>
        
        <a href="top.jsp">トップページへ戻る</a>
    </body>
</html>
