/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import model.User;
import java.sql.*; //DB使うためのインポート文
import servlet.Login;

import javax.servlet.http.HttpSession; //セッションスコープ取得のためのインポート文
import javax.servlet.RequestDispatcher; //フォワードのためのインポート文



/**
 *
 * @author takuyamuroyama
 */
public class Login extends HttpServlet {

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
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("name");
        String userPassword = request.getParameter("pass");
        
        if((userName == null || userName.length() == 0) || (userPassword == null || userPassword.length() == 0)){
                String errorMsg="ユーザー名もしくはパスワードを記入してください。";
                out.println(errorMsg);
        }
        
   
        //ここからDB
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //DB準備
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "takuya", "password");
            
            db_st = db_con.prepareStatement("SELECT * FROM UserInfo WHERE (name LIKE ?) && (password LIKE ?) ");
            db_st.setString(1, userName);
            db_st.setString(2, userPassword);
            db_data = db_st.executeQuery();  //検索系SQLの送信
            
            ArrayList<User> userInformation = new ArrayList<User>();
            
            while(db_data.next()){
                User info = new User(db_data.getString("name"), db_data.getString("password"));
                userInformation.add(info);
            }
            
            HttpSession session = request.getSession();
            session.setAttribute("userInformation", userInformation);
                
            
            
            db_data.close();
            db_st.close();
            db_con.close();
        
        //ログイン成功＆失敗ページへ
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/loginResult.jsp");
        dispatcher.forward(request, response);
        
        }catch(SQLException e_sql){
            out.println("【DBに関連するエラー】接続時にエラーが発生しました: " + e_sql.toString());
        }catch(Exception e){
            out.println("【DB以外のエラー】接続時にエラーが発生しました: " + e.toString());
        }finally{
            if(db_con != null){
                try{
                    db_con.close();
                }catch(Exception e_con){
                    System.out.println(e_con.getMessage());
                }
            }
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
