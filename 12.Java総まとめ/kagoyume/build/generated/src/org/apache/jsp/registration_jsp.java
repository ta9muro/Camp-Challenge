package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.UserData;
import javax.servlet.http.HttpSession;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

    HttpSession hs = request.getSession();
    UserData ud = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        ud = (UserData)hs.getAttribute("ud");
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>新規会員登録ページ</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>新規会員登録</h1>\n");
      out.write("        <form action=\"registrationconfirm\" method=\"POST\">\n");
      out.write("            ユーザー名: <input type=\"text\" name=\"name\" value=\"");
if(reinput){out.print(ud.getName());}
      out.write("\"><br>\n");
      out.write("            パスワード: <input type=\"password\" name=\"password\" value=\"");
if(reinput){out.print(ud.getPassword());}
      out.write("\"><br>\n");
      out.write("            メールアドレス: <input type=\"text\" name=\"mail\" value=\"");
if(reinput){out.print(ud.getMail());}
      out.write("\"><br>\n");
      out.write("            住所: <input type=\"text\" name=\"address\" value=\"");
if(reinput){out.print(ud.getAddress());}
      out.write("\"><br>\n");
      out.write("            <input type=\"submit\" name=\"btnSubmit\" value=\"確認画面へ\">\n");
      out.write("        </form>\n");
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
