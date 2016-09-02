<%-- 
    Document   : loginResult
    Created on : 2016/08/28, 0:39:14
    Author     : takuyamuroyama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.User, servlet.Login" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<User> userData = (ArrayList<User>)session.getAttribute("userInformation");
    //User userData = (User)session.getAttribute("userInformation");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Takuzon Login</title>
    </head>
    <body>
        
        <%
            for(int i=0; i<userData.size(); i++){
                User ud = userData.get(i);
                
                if(ud != null){
                    out.println("ログイン成功しました" + "<br>");
                    out.println("ようこそ" + ud.getName() + "さん" + "<br>");
                    out.println("<a href=\"jsp/mainPage.jsp\">" + "商品登録ページへ" + "</a>");
                    //macの場合、文字列の"のエスケープは \" で反映する
                }else{
                    out.println("ログインに失敗しました");
                    out.println("<a href=\"index.jsp\">" + "TOPへ" + "</a>");
                }
            }
        
        %>ちょっと荒いですが、、一応全部完成しました。
        登録する方向でいけば一通り完了してイメージとおりの結果にはなります。エラー処理はしていないですが。。
        で、明日と月曜日は残業ときいているので来れるか現時点不明です。。
        週末に入るので、、もう９月入っているので
        このまま進捗できちんと最後までいけるのかかなり心配で不安なんですけど
        どう進めますか？
        ちょっとブラックジャックはまだですけど、、
        ブラックジャックに戻るのか、次へ進むのか。
        
    </body>
</html>
