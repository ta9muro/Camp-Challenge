<%@page import="javax.servlet.http.HttpSession" %>
<%@ page import="jums.UserDataBeans2"%>
<%
    //HttpSession hs = request.getSession();
    UserDataBeans2 userInfo = (UserDataBeans2)session.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.JumsHelper"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前:<%= userInfo.getName()%><br>
        生年月日:<%= userInfo.getYear() +"年"+ userInfo.getMonth() +"月"+ userInfo.getDay() + "日"%><br>
        種別:<%= userInfo.getType()%><br>
        電話番号:<%= userInfo.getTell()%><br>
        自己紹介:<%= userInfo.getComment()%><br>
        以上の内容で登録しました。<br>
        
        <%=JumsHelper.getInstance().home()%>
        
    </body>
</html>
