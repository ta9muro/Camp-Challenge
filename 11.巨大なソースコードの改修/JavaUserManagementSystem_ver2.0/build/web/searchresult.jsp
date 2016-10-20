<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="jums.UserDataDAO"
        import="javax.servlet.http.HttpSession"
        import="jums.UserDataBeans"
        import="java.util.ArrayList"
        %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    
    
    //UserDataDTO notUdd = (UserDataDTO)session.getAttribute("outputData");
    //ArrayList<UserDataDTO> allData = new ArrayList<UserDataDTO>();
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>)session.getAttribute("resultData");    
     
    /*
    UserDataDTO udd = (UserDataDTO)request.getAttribute("resultData");
    
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        udd = (UserDataDTO)session.getAttribute("resultData");
    }
    */
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr> 
            
                <% for(UserDataDTO u: udd){ %>
                <tr>
                <td><a href="ResultDetail?id=<%= u.getUserID()%>"><%= u.getName()%></a></td>
                <td><%=u.getBirthday()%></td>
                <td><%= u.getType()%></td>
                <td><%= u.getNewDate()%></td></tr>
                <% } %>
            
        </table>
    </body>
    <%=jh.home()%>
</html>
