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
public class add extends HttpServlet {

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
        
        try{
            request.setCharacterEncoding("UTF-8");
            
            //ページ遷移の確認 3=商品追加ページ
            HttpSession hs = request.getSession();
            hs.setAttribute("pageStatus", 3);
            
            UserData ud = (UserData)hs.getAttribute("ud");
            
            //このページに遷移した時ｍmycartにデータが入っていた場合と入っていなかった場合
            if(hs.getAttribute("mycart")==null){
                ArrayList<UserData> mycart = new ArrayList<UserData>();
                mycart.add(ud);
                hs.setAttribute("mycart", mycart);
            }else{
                ArrayList<UserData> mycart = (ArrayList<UserData>)hs.getAttribute("mycart");
                mycart.add(ud);
                hs.setAttribute("mycart", mycart);
            }
            
            String msg = "カートに商品追加";
            log.getInstance().logData(msg);
            
            request.getRequestDispatcher("add.jsp").forward(request, response);
        
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
