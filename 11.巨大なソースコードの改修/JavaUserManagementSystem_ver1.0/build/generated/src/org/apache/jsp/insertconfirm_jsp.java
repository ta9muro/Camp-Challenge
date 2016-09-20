package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import jums.JumsHelper;
import jums.UserDataBeans2;

public final class insertconfirm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

    HttpSession hs = request.getSession();

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JUMS登録確認画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
      jums.UserDataBeans2 udb = null;
      synchronized (session) {
        udb = (jums.UserDataBeans2) _jspx_page_context.getAttribute("udb", PageContext.SESSION_SCOPE);
        if (udb == null){
          udb = new jums.UserDataBeans2();
          _jspx_page_context.setAttribute("udb", udb, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");

            //セッションスコープから登録情報を取得
            UserDataBeans2 userInfo = (UserDataBeans2)session.getAttribute("udb");
            
            String errorMsg2 = "";
            
            if(userInfo.getName().equals("")){
                errorMsg2 += "【JavaBeans使用】名前が記入されていません。";
            }
            
            if(userInfo.getType() == 0){
                errorMsg2 += "【JavaBeans使用】名前が記入されていません。";
                //int型の場合は初期値を代入していない場合、デフォルトは0になる
            }
            
            if(userInfo.getTell().equals("")){
                errorMsg2 += "【JavaBeans使用】電話番号が記入されていません。";
            }
            
            if(userInfo.getComment().equals("")){
                errorMsg2 += "【JavaBeans使用】名前が記入されていません。";
            }
            
           
            
            if(udb.getName().equals("")){
                errorMsg2 += "【JavaBeans使用】名前が記入されていません。";
            }
            
            if(udb.getTell().equals("")){
                errorMsg2 += "【JavaBeans使用】名前が記入されていません。";
            }
            
            if(udb.getComment().equals("")){
                errorMsg2 += "【JavaBeans使用】名前が記入されていません。";
            }
            
            if(errorMsg2.length() != 0){
                out.print(errorMsg2);
            }
         
            
        
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
 if((!userInfo.getName().equals("")) && (userInfo.getType() != 0) && (!userInfo.getTell().equals("")) && (!userInfo.getComment().equals(""))){ 
      out.write("\n");
      out.write("        \n");
      out.write("        <p>【JavaBeans使用バージョン】下記が登録するユーザー情報です</p>\n");
      out.write("        \n");
      out.write("        【JavaBeans使用】名前: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((jums.UserDataBeans2)_jspx_page_context.findAttribute("udb")).getName())));
      out.write("<br>\n");
      out.write("        【JavaBeans使用】電話番号: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((jums.UserDataBeans2)_jspx_page_context.findAttribute("udb")).getTell())));
      out.write("<br>\n");
      out.write("        【JavaBeans使用】コメント: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((jums.UserDataBeans2)_jspx_page_context.findAttribute("udb")).getComment())));
      out.write("<br>\n");
      out.write("        ");
 }
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
 /*String errorMsg = "";
        
        if(hs.getAttribute("name").equals("")){
        errorMsg+= "名前が記入されていません。" + "<br>";
        } 
        
        if(hs.getAttribute("year").equals("") || hs.getAttribute("month").equals("") || hs.getAttribute("day").equals("")){
        errorMsg+= "生年月日が記入されていません。" + "<br>";
        }
        
        if(hs.getAttribute("type") == null){
        errorMsg+= "識別が記入されていません。" + "<br>";
        } 
        
        
        if(hs.getAttribute("tell").equals("")){
        errorMsg+= "電話番号が記入されていません。" + "<br>";
        }
        
        if(hs.getAttribute("comment").equals("")){
        errorMsg+= "自己紹介が記入されていません。"  + "<br>";
        } 
            
        if(errorMsg.length() != 0){
         out.println(errorMsg);   
        } */
      out.write("\n");
      out.write("        \n");
      out.write("    ");
 if((!hs.getAttribute("name").equals("")) && (!hs.getAttribute("year").equals("") && !hs.getAttribute("month").equals("") && !hs.getAttribute("day").equals(""))
            && (hs.getAttribute("type") != null) && (!hs.getAttribute("tell").equals("")) && (!hs.getAttribute("comment").equals(""))){ 
      out.write("\n");
      out.write("        <h1>登録確認</h1>\n");
      out.write("        名前:");
      out.print( hs.getAttribute("name"));
      out.write("<br>\n");
      out.write("        生年月日:");
      out.print( hs.getAttribute("year")+"年"+hs.getAttribute("month")+"月"+hs.getAttribute("day")+"日");
      out.write("<br>\n");
      out.write("        種別:");
      out.print( hs.getAttribute("type"));
      out.write("<br>\n");
      out.write("        電話番号:");
      out.print( hs.getAttribute("tell"));
      out.write("<br> \n");
      out.write("        自己紹介:");
      out.print( hs.getAttribute("comment"));
      out.write("<br>\n");
      out.write("        上記の内容で登録します。よろしいですか？\n");
      out.write("        <form action=\"insertresult\" method=\"POST\">\n");
      out.write("            <input type=\"submit\" name=\"yes\" value=\"はい\">\n");
      out.write("            <input type=\"hidden\" name=\"ac\" value=\"");
      out.print( hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("        </form>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        \n");
      out.write("        <form action=\"insert\" method=\"POST\">\n");
      out.write("            <input type=\"submit\" name=\"no\" value=\"登録画面に戻る\">\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        ");
      out.print(JumsHelper.getInstance().home());
      out.write("\n");
      out.write("        \n");
      out.write("        ");

        //セッションスコープそのものをクリア
        //session.invalidate();
        
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
