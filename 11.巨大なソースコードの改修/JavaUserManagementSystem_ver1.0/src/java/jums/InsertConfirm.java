package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import java.util.*;
import jums.UserDataBeans2; //JavaBeans
import java.text.*; //Date型を使用するため



/**
 * insertconfirm.jspと対応するサーブレット
 * フォーム入力された情報はここでセッションに格納し、以降持ちまわることになる
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertConfirm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //response.setContentType("text/html;charsset=UTF-8");
        //PrintWriter out = response.getWriter();
        try{
            HttpSession session = request.getSession(); //HttpSessionインスタンスの取得
            request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            //フォームからの入力を取得
            String name = request.getParameter("name");
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String type = request.getParameter("type");
            String tell = request.getParameter("tell");
            String comment = request.getParameter("comment");
            
            //----------------- ここから JavaBeansを使用するためのコーディング1 -----------------
            
            //JavaBeansのセッションスコープに保存するインスタンスの生成
            UserDataBeans2 udb = new UserDataBeans2();
            
            udb.setName(name);
            udb.setType(Integer.parseInt(type));
            udb.setTell(tell);
            udb.setComment(comment);
            udb.setYear(year);
            udb.setMonth(month);
            udb.setday(day);
            
            //セッションスコープに登録情報（インスタンス）を保存
            session.setAttribute("udb", udb);
            
            String dateStr = year + "-" + month + "-" + day;
            //生年月日を文字列からデータ型へ変換
            if (!dateStr.equals("--")){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date dt = sdf.parse(dateStr);
                udb.setBirthday(dt);
            }
            
            if((name == null) && (dateStr.equals("--")) && (type == null) && (tell == null) && (comment == null)){
                throw new Exception("入力が不完全です");
            }

           
            //----------------- ここまで JavaBeansを使用するためのコーディング1 -----------------
            

            
            
            session.setAttribute("name", name);
            session.setAttribute("year", year);
            session.setAttribute("month",month);
            session.setAttribute("day", day);
            session.setAttribute("type", type);
            session.setAttribute("tell", tell);
            session.setAttribute("comment", comment);
            System.out.println("Session updated!!");

       
            //直リンク防止のためのセッションを新しく作成
            /*HttpSession session2 = request.getSession();
            session2.setAttribute("ac2",(int) (Math.random() * 1000));*/
            request.getRequestDispatcher("/insertconfirm.jsp").forward(request, response);
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
