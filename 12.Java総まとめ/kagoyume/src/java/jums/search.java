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
import java.util.*;
import java.text.*;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;


/**
 *
 * @author takuyamuroyama
 */
public class search extends HttpServlet {

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
        
        PrintWriter out = response.getWriter();
        
        try{
            response.setContentType("text/html;charset=UTF-8");
            
        
            request.setCharacterEncoding("UTF-8");
        
            //フォームから検索ワードをUserDataに格納
            UserData ud = new UserData();
            String searchwordFromTopPage = request.getParameter("searchword");
            ud.setSearchword(searchwordFromTopPage);
            
            if(searchwordFromTopPage == null && searchwordFromTopPage.equals("")){
            String errorMsg="検索ワードが未入力です。";
            out.println(errorMsg);
            }
            
            //検索ワードをもってHTTP接続
            String url = SearchFromYahooJAPAN.getInstance().getSearch(ud) ;
            
            //JSONへ変換
            ArrayList<UserData> resultJsonData = TransformationToJSON.getInstance().getJsonNode(url);
            
            HttpSession session = request.getSession();
            session.setAttribute("resultJsonData", resultJsonData);
           
            String msg = "入力した検索ワード: " + searchwordFromTopPage + " searchに遷移しました。";
            log.getInstance().logData(msg);
            
            request.getRequestDispatcher("/search.jsp").forward(request, response);
        }catch(Exception e){
            //request.setAttribute("error", e.getMessage());
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
