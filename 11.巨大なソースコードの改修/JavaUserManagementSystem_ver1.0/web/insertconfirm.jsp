
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.text.*" %>
<%@ page import="jums.JumsHelper"%>
<%@ page import="jums.UserDataBeans2"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        
        <%
            //セッションスコープから登録情報を取得
            UserDataBeans2 userInfo = (UserDataBeans2)session.getAttribute("udb");
            
            String errorMsg2 = "";
            
            if(userInfo.getName().equals("")){
                errorMsg2 += "【JavaBeans使用】名前が記入されていません。" + "<br>";
            }
            
            if(userInfo.getBirthday() == null){
                errorMsg2 += "【JavaBeans使用】生年月日が記入されていません。" + "<br>";
            }
            
            if(userInfo.getType() == 0){
                errorMsg2 += "【JavaBeans使用】種別が記入されていません。" + "<br>";
                //int型の場合は初期値を代入していない場合、デフォルトは0になる
            }
            
            if(userInfo.getTell().equals("")){
                errorMsg2 += "【JavaBeans使用】電話番号が記入されていません。" + "<br>";
            }
            
            if(userInfo.getComment().equals("")){
                errorMsg2 += "【JavaBeans使用】自己紹介文が記入されていません。" + "<br>";
            }
            
            
            if(errorMsg2.length() != 0){
                out.print(errorMsg2);
            }
         
            
        %>
        
        
        <% if((!userInfo.getName().equals("")) && (userInfo.getBirthday() != null) && (userInfo.getType() != 0) && (!userInfo.getTell().equals("")) && (!userInfo.getComment().equals(""))){ %>
        
        <h1>登録確認</h1>
        名前:<%= userInfo.getName()%><br>
        生年月日:<%= userInfo.ChangeStringFromDate()%><br>
        種別:<%= userInfo.getType()%><br>
        電話番号:<%= userInfo.getTell()%><br> 
        自己紹介:<%= userInfo.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="submit" name="yes" value="はい">
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
        </form>
        <% } %>
        
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        
        <%=JumsHelper.getInstance().home()%>
    
    </body>
</html>
