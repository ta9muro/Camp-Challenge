/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.sql.Timestamp;

/**
 *ユーザー情報を持ちまわるJavaBeans
 * DBのカラムと型に対応。
 * @author takuyamuroyama
 */

public class UserDataDTO {
    //user_tテーブル
    private int userID;
    private String name;
    private String password;
    private String mail;
    private String address;
    private int total;
    private Timestamp newDate;
    
    //buy_tテーブル
    private int buyID;
    //private int userID;
    //private int total;
    private int type;
    //private Timestamp newDate;
    
    public int getUserID(){
        return userID;
    }
    
    public void setUserID(int userID){
        this.userID = userID;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getMail(){
        return mail;
    }
    
    public void setMail(String mail){
        this.mail = mail;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public int getTotal(){
        return total;
    }
    
    public void setTotal(int total){
        this.total = total;
    }
    
    public Timestamp getNewDate(){
        return newDate;
    }
    
    public void setNewDate(Timestamp newDate){
        this.newDate = newDate;
    }
    
    public int getBuyID(){
        return buyID;
    }
    
    public void setBuyID(int buyID){
        this.buyID = buyID;
    }
    
    public int getType(){
        return type;
    }
    
    public void setType(int type){
        this.type = type;
    }
    
}
