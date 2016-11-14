/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import base.DBManager;
import java.sql.*;
import java.util.ArrayList;

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
        
        System.out.println("insert completed");
    
    }catch(SQLException e){
        System.out.println(e.getMessage());
        throw new SQLException(e);
    }finally{
        if(con != null){
            con.close();
        }
    }
}


 /**
 *ログイン判断用メソッドを行う。arraylistで返却。
 */
public ArrayList<UserDataDTO> searchUser_t(UserDataDTO udd)throws SQLException{
    Connection con = null;
    PreparedStatement st = null;
    
    try{
        con = DBManager.getConnection();
        st = con.prepareStatement("SELECT * FROM user_t WHERE name = ? and password = ?");
        st.setString(1, udd.getName());
        st.setString(2, udd.getPassword());
        ResultSet rs = st.executeQuery();
                   
        UserDataDTO udDTO = new UserDataDTO();
        ArrayList<UserDataDTO> userInformation = new ArrayList<UserDataDTO>();
        
        while(rs.next()){
            udDTO.setUserID(rs.getInt("userID"));
            udDTO.setName(rs.getString("name"));
            udDTO.setPassword(rs.getString("password"));
            udDTO.setMail(rs.getString("mail"));
            udDTO.setAddress(rs.getString("address"));
            udDTO.setTotal(rs.getInt("total"));
            udDTO.setNewDate(rs.getTimestamp("newDate"));
            userInformation.add(udDTO);
        }
        
        System.out.println("search completed");
        return userInformation;
        
    }catch(SQLException e){
        System.out.println(e.getMessage());
        throw new SQLException(e);
    }finally{
        if(con != null){
            con.close();
        }
    }
}


 /**
 *商品購入メソッド
 */
public void boughtProduct(UserDataDTO udd)throws SQLException{
    Connection con = null;
    PreparedStatement st = null;
    
    try{
        con = DBManager.getConnection();
        st = con.prepareStatement("INSERT INTO buy_t(userID, total, type, buyDate) VALUES(?,?,?,?)");
        st.setInt(1, udd.getUserID());
        st.setInt(2, udd.getTotal());
        st.setInt(3, udd.getType());
        st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
        st.executeUpdate();
        
        System.out.println("bought completed");
    }catch(Exception e){
        System.out.println(e.getMessage());
        throw new SQLException(e);
    }finally{
        if(con != null){
            con.close();
        }
    }
}


/**
 *カート合計金額の更新メソッド
 */
public void updateTotal(UserDataDTO udd)throws SQLException{
    Connection con = null;
    PreparedStatement st = null;
    
    try{
        con = DBManager.getConnection();
        st = con.prepareStatement("UPDATE user_t SET total = ? WHERE userID = ?");
        st.setInt(1, udd.getUserID());
        st.setInt(2, udd.getTotal());
        st.executeUpdate();
        
        System.out.println("update total completed");
    }catch(Exception e){
        System.out.println(e.getMessage());
        throw new SQLException(e);
    }finally{
        if(con != null){
            con.close();
        }
    }
}

/**
 *ユーザーデータを更新するメソッド
 */
public void updateUser_t(UserDataDTO udd)throws SQLException{
    Connection con = null;
    PreparedStatement st = null;
    
    try{
        con = DBManager.getConnection();
        st = con.prepareStatement("UPDATE user_t SET name = ?, password = ?, mail =?, address =?, newDate =? WHERE userID =?");
        
        st.setString(1, udd.getName());
        st.setString(2, udd.getPassword());
        st.setString(3, udd.getMail());
        st.setString(4, udd.getAddress());
        st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
        st.executeUpdate();
        
        System.out.println("update user_t completed");
    }catch(Exception e){
    System.out.println(e.getMessage());
    throw new SQLException(e);
    }finally{
        if(con != null){
            con.close();
        }
    }
}

}




