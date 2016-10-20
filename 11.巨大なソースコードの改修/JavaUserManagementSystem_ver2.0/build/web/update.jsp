<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="java.text.*"
        %>

<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)session.getAttribute("resultData");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
   
    <form action="UpdateResult" method="POST">
        名前:
        <input type="text" name="name" value="<%=udd.getName()%>">
        <br><br>

        生年月日:　
        <select name="year">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" <% SimpleDateFormat sdf = new SimpleDateFormat("yyyy"); String sdfOutput = sdf.format(udd.getBirthday()); if(Integer.parseInt(sdfOutput) == i){out.print("selected");}%>><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <% SimpleDateFormat sdf = new SimpleDateFormat("MM"); String sdfOutput = sdf.format(udd.getBirthday()); if(Integer.parseInt(sdfOutput) == i){out.print("selected");}%>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>" <% SimpleDateFormat sdf = new SimpleDateFormat("dd"); String sdfOutput = sdf.format(udd.getBirthday()); if(Integer.parseInt(sdfOutput) == i){out.print("selected");}%>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>"<%if(udd.getType() == i){out.print("checked");}%>><%=jh.exTypenum(i)%><br>
            <% } %>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%=udd.getTell()%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%out.print(udd.getComment());%></textarea><br><br>
        
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
    
        <form action="SearchResult" method="POST">
            <input type="submit" name="searchresult" value="検索結果画面に戻る" style="width:100px">
            <input type="hidden" name="mode" value="REINPUT">
        </form>
        <br>
        <%=jh.home()%>
    </body>
</html>
