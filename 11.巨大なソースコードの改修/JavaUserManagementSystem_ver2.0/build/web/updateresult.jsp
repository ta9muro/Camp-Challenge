<%@page import="jums.JumsHelper"
        import="java.text.*"
        import="jums.UserDataDTO"
        import="jums.UserDataBeans"
        %>

<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <h1>変更結果</h1><br>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear() +"年"+ udb.getMonth() +"月"+ udb.getDay() %><br>
        種別:<%= jh.exTypenum(udb.getType())%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        以上の内容で登録しました。<br>
        
        <form action="ResultDetail" method="POST">
            <input type="submit" name="resultdetail" value="詳細情報画面に戻る" style="width:100px">
        </form>
    <%=jh.home()%>
    </body>
</html>
