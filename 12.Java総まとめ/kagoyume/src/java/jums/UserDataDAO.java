/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import base.DBManager;
import java.sql.*;

/**
 *ユーザー情報を格納するテーブルに対しての操作処理
 * @author takuyamuroyama
 */
public class UserDataDAO {
    
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
 /**
 *データの挿入処理を行う。現在時刻は挿入直前に生成
 * 
 * 
 */
public void insertUser_t(UserDataDTO udd) throws SQLException{
    Connection con = null;
    PreparedStatement st = null;
    
    try{
        con = DBManager.getConnection();
        st = con.prepareStatement("INSERT INTO user_t(name, password, mail, address, total, newDate) VALUES(?,?,?,?,?,?)");
        st.setString(1, udd.getName());
        st.setString(2, udd.getPassword());
        st.setString(3, udd.getMail());
        st.setString(4, udd.getAddress());
        st.setInt(5, udd.getTotal());
        st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
        st.executeUpdate();
    }catch(SQLException e){
        throw new SQLException(e);
    }finally{
        if(con != null){
            con.close();
        }
    }
}
    
    
}




