/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.text.*;

/**
 *
 * @author takuyamuroyama
 */
public class UserDataBeans2 implements Serializable{
    private int userID;
    private String name;
    private Date birthday;
    private String year;
    private String month;
    private String day;
    private String tell;
    private int type;
    private String comment;
    private Timestamp newDate;
    
    public UserDataBeans2(){}
    public UserDataBeans2(int userID, String name, Date birthday, String tell, int type, String comment, Timestamp newDate){
    this.userID = userID;
    this.name = name;
    this.birthday = birthday;
    this.tell = tell;
    this.type = type;
    this.comment = comment;
    this.newDate = newDate;
    }
    
    public int getUserID(){return userID;}
    public void setUserID(int userID){this.userID = userID;}
    public String getYear(){return year;}
    public void setYear(String year){this.year = year;}
    public String getMonth(){return month;}
    public void setMonth(String month){this.month = month;}
    public String getDay(){return day;}
    public void setday(String day){this.day = day;}
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public Date getBirthday(){return birthday;}
    public void setBirthday(Date birthday){this.birthday = birthday;}
    public String getTell(){return tell;}
    public void setTell(String tell){this.tell = tell;}
    public int getType(){return type;}
    public void setType(int type){this.type = type;}
    public String getComment(){return comment;}
    public void setComment(String comment){this.comment = comment;}
    public Timestamp getNewDate(){return newDate;}
    public void setNewDate(Timestamp newDate){this.newDate = newDate;}
    
    
    //生年月日の登録情報をDate型から文字列型に変換
    public String ChangeStringFromDate(){
            String DATE_PATTERN = "yyyy-MM-dd";
            String str = new SimpleDateFormat(DATE_PATTERN).format(this.birthday);
            return str;
    }
    
}
