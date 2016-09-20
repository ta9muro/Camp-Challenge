package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import jums.JumsHelper;
import jums.UserDataBeans2;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession hs = request.getSession();
    UserDataBeans2 userInfo = (UserDataBeans2)session.getAttribute("udb");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JUMS登録画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <form action=\"insertconfirm\" method=\"POST\">\n");
      out.write("        名前:\n");
      out.write("        <input type=\"text\" name=\"name\" value=\"");
if(hs.getAttribute("name") != null){out.print(hs.getAttribute("name"));}
      out.write("\">\n");
      out.write("        <br><br>\n");
      out.write("\n");
      out.write("        生年月日:　\n");
      out.write("        <select name=\"year\">\n");
      out.write("            <option value=\"\">----</option>\n");
      out.write("            ");

                //nullは値が空の場合。equals("")は「----」を選択した場合。
                Integer y = 0;
                if (hs.getAttribute("year") != null && !hs.getAttribute("year").equals("")) {
                    y = Integer.parseInt((String)hs.getAttribute("year"));
                    //数字列を文字列に変換。
                }
                    
            for(int i=1950; i<=2010; i++){
            
      out.write("\n");
      out.write("            <option value=\"");
      out.print(i);
      out.write('"');
      out.write(' ');
 if(y == i) { out.print("selected"); }
      out.write('>');
      out.write(' ');
      out.print(i);
      out.write(" </option>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </select>年\n");
      out.write("        \n");
      out.write("        <select name=\"month\">\n");
      out.write("            <option value=\"\">--</option>\n");
      out.write("            \n");
      out.write("            ");

                Integer y2 = 0;
                if(hs.getAttribute("month") != null && !hs.getAttribute("month").equals("")){
                    y2 = Integer.parseInt((String)hs.getAttribute("month"));
                }
    
            for(int i = 1; i<=12; i++){
            
      out.write("\n");
      out.write("           <option value=\"");
      out.print(i);
      out.write('"');
 if(y2 == i){out.print("selected");} 
      out.write('>');
      out.write(' ');
      out.print(i);
      out.write("</option>\n");
      out.write("           ");
 } 
      out.write("\n");
      out.write("        </select>月\n");
      out.write("        \n");
      out.write("        <select name=\"day\">\n");
      out.write("            <option value=\"\" selected>--</option>\n");
      out.write("            \n");
      out.write("            ");

                Integer y3 = 0;
                if(hs.getAttribute("day") != null && !hs.getAttribute("day").equals("")){
                    y3 = Integer.parseInt((String)userInfo.getDay());
                }
                
            for(int i = 1; i<=31; i++){
            
      out.write("\n");
      out.write("            <option value=\"");
      out.print(i);
      out.write('"');
      out.write(' ');
 if(y3 == i){out.print("selected");} 
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("            \n");
      out.write("        </select>日\n");
      out.write("        <br><br>\n");
      out.write("\n");
      out.write("        種別:\n");
      out.write("        <br>\n");
      out.write("        <input type=\"radio\" name=\"type\" value=\"1\" ");
 if((hs.getAttribute("type")) != null && (hs.getAttribute("type").equals("1"))){out.print("checked");}
      out.write(">エンジニア<br>\n");
      out.write("        <input type=\"radio\" name=\"type\" value=\"2\" ");
 if((hs.getAttribute("type")) != null && (hs.getAttribute("type").equals("2"))){out.print("checked");}
      out.write(">営業<br>\n");
      out.write("        <input type=\"radio\" name=\"type\" value=\"3\" ");
 if((hs.getAttribute("type")) != null && (hs.getAttribute("type").equals("3"))){out.print("checked");}
      out.write(">その他<br>\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("        電話番号:\n");
      out.write("        <input type=\"text\" name=\"tell\" value=\"");
if(hs.getAttribute("tell") != null){out.print(hs.getAttribute("tell"));}
      out.write("\">\n");
      out.write("        <br><br>    \n");
      out.write("\n");
      out.write("        自己紹介文\n");
      out.write("        <br>\n");
      out.write("        <textarea name=\"comment\" rows=10 cols=50 style=\"resize:none\" wrap=\"hard\">");
if((hs.getAttribute("comment")) != null){out.print(hs.getAttribute("comment"));}
      out.write("</textarea><br><br>\n");
      out.write("        \n");
      out.write("        <input type=\"hidden\" name=\"ac\"  value=\"");
      out.print( hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("        <input type=\"submit\" name=\"btnSubmit\" value=\"確認画面へ\">\n");
      out.write("    </form>\n");
      out.write("        <br>\n");
      out.write("        ");
      out.print(JumsHelper.getInstance().home());
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
