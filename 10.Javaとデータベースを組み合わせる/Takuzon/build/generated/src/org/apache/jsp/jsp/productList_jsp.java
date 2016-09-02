package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Product;
import servlet.MainPage;
import java.util.ArrayList;

public final class productList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");

    ArrayList<Product> productList = (ArrayList<Product>)session.getAttribute("productData");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Product List Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>商品登録一覧</h1><br>\n");
      out.write("        <table border=\"\" width=\"\" cellspacing=\"\" cellpadding=\"\">\n");
      out.write("            <tr>\n");
      out.write("                <th align=\"center\" valign=\"middle\"><font color=\"2e8b57\">商品コード</font></th>\n");
      out.write("                <th align=\"center\" valign=\"middle\"><font color=\"2e8b57\">商品名</font></th>\n");
      out.write("                <th align=\"center\" valign=\"middle\"><font color=\"2e8b57\">カテゴリ</font></th>\n");
      out.write("                <th align=\"center\" valign=\"middle\"><font color=\"2e8b57\">価格</font></th>\n");
      out.write("                <th align=\"center\" valign=\"middle\"><font color=\"2e8b57\">数量</font></th>\n");
      out.write("                <th align=\"center\" valign=\"middle\"><font color=\"2e8b57\">登録者</font></th>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            ");

                for(int i=0; i<productList.size(); i++){
                    Product dbData = productList.get(i);
                    
                    out.println("<tr><td>" + dbData.getCode() + "<td>");
                    out.println("<td>" + dbData.getName() + "</td>");
                    out.println("<td>" + dbData.getCategory() + "</td>");
                    out.println("<td>" + dbData.getPrice() + "</td>");
                    out.println("<td>" + dbData.getPrice() + "</td>");
                    out.println("<td>" + dbData.getUser() + "</td></tr>");
                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        <a href=\"mainPage.jsp\">続けて登録する</a>\n");
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
