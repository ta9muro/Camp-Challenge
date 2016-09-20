package jums;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.*;

import jums.UserDataBeans2;
import jums.UserDataDTO;
import java.sql.*;

/**
 * insertresultと対応するサーブレット
 * フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

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
        
        //セッションスタート
        HttpSession session = request.getSession();
        
        try{
            //HttpSession session2 = request.getSession();
            request.setCharacterEncoding("UTF-8");
            String accesschk2 = request.getParameter("ac");
            if(accesschk2 == null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk2)){
                throw new Exception("不正なアクセスです");
            }
             
            
            //DTO（Data Table Object）に格納。
            UserDataBeans2 userInfo = (UserDataBeans2)session.getAttribute("udb");
            UserDataDTO userdata = new UserDataDTO();
            userdata.setName(userInfo.getName());
            userdata.setBirthday(userInfo.getBirthday());
            userdata.setType(userInfo.getType());
            userdata.setTell(userInfo.getTell());
            userdata.setComment(userInfo.getComment());
            //userdata.setName((String)session.getAttribute("name"));
            //userdata.setBirthday((Date)session.getAttribute("birthday"));
            //userdata.setType(Integer.parseInt((String)session.getAttribute("type")));
            //userdata.setTell((String)session.getAttribute("tell"));
            //userdata.setComment((String)session.getAttribute("comment"));
            
            //DBへデータの挿入
            UserDataDAO.getInstance().insert(userdata);
            
            //セッションスコープを削除
            session.invalidate();
            //結果表示画面のためのリクエストパラメータとして保存（リクエストパラメータは送信したら勝手に消滅する）
            UserDataBeans2 udb = new UserDataBeans2();
            request.setAttribute("udb", udb);
            
            request.getRequestDispatcher("/insertresult.jsp").forward(request, response);
        
        }catch(Exception e){
            //データ挿入に失敗したらエラーページにエラー文を渡して表示
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
