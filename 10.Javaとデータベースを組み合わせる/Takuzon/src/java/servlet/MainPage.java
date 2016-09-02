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

import java.sql.*;
import java.util.ArrayList;
import model.Product;

import javax.servlet.http.HttpSession;  //セッションスコープ取得のためのインポート文
import javax.servlet.RequestDispatcher; //フォワードのためのインポート文

/**
 *
 * @author takuyamuroyama
 */
public class MainPage extends HttpServlet {

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
        
        //リクエストパラメータから取得
        request.setCharacterEncoding("UTF-8");
        String productCode = request.getParameter("code");
        String productName = request.getParameter("name");
        String category = request.getParameter("category");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String user = request.getParameter("user");
        
        String errorMsg = "";
        
        if(productCode == null || productCode.length() == 0){
            errorMsg += "商品コードを記入してください。 ";
        }
        
        if(productName == null || productName.length() == 0){
            errorMsg += "商品名を記入してください。 ";
        }
        
        if(category == null || category.length() == 0){
            errorMsg += "カテゴリを記入してください。 ";
        }
        
        if(price == null || price.length() ==0 ){
            errorMsg += "価格を記入してください。 ";
        }
        
        if(quantity == null || quantity.length() == 0){
            errorMsg += "数量を記入してください。 ";
        }
        
        if(user == null || user.length() == 0){
            errorMsg += "登録者を記入してください。 ";
        }
        
        if(errorMsg.length() != 0){
            out.println(errorMsg);
        }

        
        //ここからDB
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "takuya", "password");
            
            db_st = db_con.prepareStatement("INSERT INTO ProductList(productCode, productName, category, price, quantity, user) VALUES(?,?,?,?,?,?) ");
            db_st.setString(1, productCode);
            db_st.setString(2, productName);
            db_st.setString(3, category);
            db_st.setString(4, price);
            db_st.setString(5, quantity);
            db_st.setString(6, user);
            db_st.executeUpdate();
            
            
            db_st = db_con.prepareStatement("SELECT * FROM ProductList");
            db_data = db_st.executeQuery();
            
            //Productクラスを型に配列作成
            ArrayList<Product> productData = new ArrayList<Product>();
            
            //DB一行ずつ各カラムのデータを引数に入れる
            while(db_data.next()){
                Product data = new Product(db_data.getString("productCode"), db_data.getString("productName"), db_data.getString("category"), db_data.getString("price"), db_data.getString("quantity"), db_data.getString("user"));
                productData.add(data);
            }

        //配列productDataをセッションスコープに保存
        HttpSession session = request.getSession();
        session.setAttribute("productData", productData);
        
        db_data.close();
        db_st.close();
        db_con.close();

        //mainPage.jspへフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/productList.jsp");
        dispatcher.forward(request, response);
        
        
        
            
            
            
        
        }catch(SQLException e_sql){
            out.println("【DBに関連するエラー】接続時にエラーが発生しました: " + e_sql.toString());
        }catch(Exception e){
            out.println("【DB以外のエラー】接続時にエラーが発生しました: " +e.toString());
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

    
