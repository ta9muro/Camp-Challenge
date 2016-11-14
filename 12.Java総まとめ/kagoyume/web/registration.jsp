<%-- 
    Document   : registration
    Created on : 2016/10/02, 17:09:01
    Author     : takuyamuroyama
--%>

<%@page import="jums.UserData"
        import="javax.servlet.http.HttpSession"
        %>

<%
    HttpSession hs = request.getSession();
    
    UserData ud = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        ud = (UserData)hs.getAttribute("ud");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規会員登録ページ</title>
    </head>
    <body>
        <h1>新規会員登録</h1>
        <form action="registrationconfirm" method="POST">
            ユーザー名: <input type="text" name="name" value="<%if(reinput){out.print(ud.getName());}%>"><br>
            パスワード: <input type="password" name="password" value="<%if(reinput){out.print(ud.getPassword());}%>"><br>
            メールアドレス: <input type="text" name="mail" value="<%if(reinput){out.print(ud.getMail());}%>"><br>
            住所: <input type="text" name="address" value="<%if(reinput){out.print(ud.getAddress());}%>"><br>
            <input type="submit" name="btnSubmit" value="確認画面へ">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
        </form>
    </body>
</html>
