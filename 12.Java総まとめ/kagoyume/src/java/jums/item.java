/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author takuyamuroyama
 */
public class item extends HttpServlet {

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
        
        //ページ遷移の確認 2=商品詳細ページ
        HttpSession hs = request.getSession();
        hs.setAttribute("pageStatus", 2);
        
        try{
            
            UserData ud = new UserData();
            
            int number = Integer.parseInt(request.getParameter("number"));
            hs.setAttribute("number", number);
            
            ArrayList<UserData> detail = (ArrayList<UserData>)hs.getAttribute("resultJsonData");
            
            ud.setProductPic(detail.get(number).getProductPic());
            ud.setProductName(detail.get(number).getProductName());
            ud.setPrice(detail.get(number).getPrice());
            ud.setDescription(detail.get(number).getDescription());
            ud.setReviewRate(detail.get(number).getReviewRate());
            ud.setReviewCount(detail.get(number).getReviewCount());
            
            hs.setAttribute("ud",ud);
            
            log.getInstance().logData("商品詳細ページに遷移");
            request.getRequestDispatcher("/item.jsp").forward(request, response);
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
