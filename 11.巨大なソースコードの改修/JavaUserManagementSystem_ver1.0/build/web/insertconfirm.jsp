<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="jums.JumsHelper"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <% String errorMsg = "";%>
        
        <%if(hs.getAttribute("name").equals("")){
        errorMsg+= "名前が記入されていません。" + "<br>";
        } %>
        
        <%if(hs.getAttribute("year").equals("") || hs.getAttribute("month").equals("") || hs.getAttribute("day").equals("")){
        errorMsg+= "生年月日が記入されていません。" + "<br>";
        } %>
        
        <%if(hs.getAttribute("type") == null){
        errorMsg+= "識別が記入されていません。" + "<br>";
        } %>
        
        
        <%if(hs.getAttribute("tell").equals("")){
        errorMsg+= "電話番号が記入されていません。" + "<br>";
        } %>
        
        <%if(hs.getAttribute("comment").equals("")){
        errorMsg+= "自己紹介が記入されていません。"  + "<br>";
        } %>
            
        <%if(errorMsg.length() != 0){
         out.println(errorMsg);   
        }%>
        
    <% if((!hs.getAttribute("name").equals("")) && (!hs.getAttribute("year").equals("") && !hs.getAttribute("month").equals("") && !hs.getAttribute("day").equals(""))
            && (hs.getAttribute("type") != null) && (!hs.getAttribute("tell").equals("")) && (!hs.getAttribute("comment").equals(""))){ %>
        <h1>登録確認</h1>
        名前:<%= hs.getAttribute("name")%><br>
        生年月日:<%= hs.getAttribute("year")+"年"+hs.getAttribute("month")+"月"+hs.getAttribute("day")+"日"%><br>
        種別:<%= hs.getAttribute("type")%><br>
        電話番号:<%= hs.getAttribute("tell")%><br>
        自己紹介:<%= hs.getAttribute("comment")%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>
        <% } %>
        
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        
        <%=JumsHelper.getInstance().home()%>
        
        <%
        //セッションスコープそのものをクリア
        session.invalidate();
        %>
    </body>
</html>
