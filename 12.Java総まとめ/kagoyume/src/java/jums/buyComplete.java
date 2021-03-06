/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author takuyamuroyama
 */
public class buyComplete extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        //ページ遷移の確認 6=購入完了ページ
        HttpSession hs = request.getSession();
        hs.setAttribute("pageStatus", 6);
        
        
        try{
            //udに格納したユーザー情報を持ってくる
            UserData ud = (UserData)hs.getAttribute("ud");
            
            //カート内にある現在の合計金額をudに格納する。※ユーザー情報の金額合計更新のための作業
            int moneyInCart = Integer.parseInt(hs.getAttribute("totalPrice").toString());
            ud.setTotal(moneyInCart);
            
            //DB専用のパラメータに変換するためにUserDataDTOにマッピング
            UserDataDTO udd = new UserDataDTO();
            ud.MappingToDB(udd);

            //DBにて合計金額の更新。
            UserDataDAO.getInstance().updateTotal(udd);
            
            
            //buy_tテーブル更新
            ud.setType(Integer.parseInt(request.getParameter("type")));
            ArrayList<UserData> mycart = (ArrayList)hs.getAttribute("mycart");
            
            for(int i=0; i<mycart.size(); i++){
                ud.MappingToDB(udd);
                UserDataDAO.getInstance().boughtProduct(udd);
            }
            
            hs.removeAttribute("mycart");
            
            String msg ="購入完了しました";
            log.getInstance().logData(msg);
            
            request.getRequestDispatcher("buyComplete.jsp").forward(request, response);
            
        }catch(Exception e){
            out.println(e.toString());
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
