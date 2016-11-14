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
public class loginCheck extends HttpServlet {

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
            HttpSession hs = request.getSession();

            UserData ud = new UserData();
            
            //フォワードからユーザー名とパスワード取得
            ud.setName(request.getParameter("name"));
            ud.setPassword(request.getParameter("password"));
            
            //DB専用のパラメータに変換のためマッピング
            UserDataDTO checkData = new UserDataDTO();
            ud.MappingToDB(checkData);
            
            //DBにて検索    
            UserDataDAO dao = new UserDataDAO();
            ArrayList<UserDataDTO> userInformation = dao.searchUser_t(checkData);
            
            
            if(userInformation.size() == 0){ //ログイン失敗時
                String msg = "ログイン失敗";
                log.getInstance().logData(msg);
                request.getRequestDispatcher("/loginError.jsp").forward(request, response);
            
            }else{ //ログイン成功時
                //DBから持ってきたユーザー情報をUserDataに格納
                for(int i=0; i<userInformation.size(); i++){
                    UserDataDTO udd = userInformation.get(i);
                    ud.UserInfoFromDB(udd);
                    
                    //ページ遷移判断 1=検索結果ページ 2=商品詳細ページ 3=商品追加ページ 4=カート内容ページ 5=商品購入内容ページ 6=商品購入完了ページ
                    if((Integer)hs.getAttribute("pageStatus") == 1){
                        
                        String url = "http://localhost:8080/kagoyume/search?searchword=";
                        String searchword = (String)hs.getAttribute("searchwordFromTopPage");
                        String value = "&btnSubmit=検索";
                        
                        //1 検索結果ページへリダイレクト
                        String setURL = url + searchword + value;
                        response.sendRedirect(setURL); 
                    
                    }else if((Integer)hs.getAttribute("pageStatus") == 2){
                        
                        String url = "http://localhost:8080/kagoyume/item?number=";
                        int number = (Integer)hs.getAttribute("number");
                        
                        //2 商品検索ページへリダイレクト
                        String setURL = url + number;
                        response.sendRedirect(setURL);
                    
                    }else if((Integer)hs.getAttribute("pageStatus") == 3){
                        
                        //3 商品追加ページへリダイレクト
                        String setURL = "http://localhost:8080/kagoyume/add";
                        response.sendRedirect(setURL);
                        
                    }else if((Integer)hs.getAttribute("pageStatus") == 4){
                        
                        //4 カート内容ページへリダイレクト
                        String setURL = "http://localhost:8080/kagoyume/cart";
                        response.sendRedirect(setURL);
                        
                    }else if((Integer)hs.getAttribute("pageStatus") == 5){
                        
                        //5 商品購入内容ページへリダイレクト
                        String setURL = "http://localhost:8080/kagoyume/buyConfirm?btnsubmit=購入画面へ";
                        response.sendRedirect(setURL);
                    }else{
                        
                        //6 商品購入完了ページ
                        String setURL = "http://localhost:8080/kagoyume/buyComplete";
                        response.sendRedirect(setURL);
                    
                    }
                    
                    String msg = "ログイン成功";
                    log.getInstance().logData(msg);
                }
            }
        
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
