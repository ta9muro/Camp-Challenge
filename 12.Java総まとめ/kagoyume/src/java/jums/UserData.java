package jums;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * 
 * @author takuyamuroyama
 */
public class UserData implements Serializable{
    
    //会員情報 user_t
    private int userID;
    private String name;
    private String password;
    private String mail;
    private String address;
    private int total;
    private Timestamp newDate;
    
    //購入管理 buy_t
    private int buyID;
    private int type; //発送方法
    private Timestamp buyDate;
    
    //検索ワード情報
    private String searchword;
    private String searchResult;
    
    //Yahoo APIから持ってきた情報
    private String totalResultsAvailable;
    private String query;
    private String productName;
    private String price;
    private String productPic;
    private String description;
    private String code; //商品コード
    private String reviewRate;
    private String reviewCount;
    
    
    public UserData(){
        this.userID = 0;
        this.name = "";
        this.password = "";
        this.mail = "";
        this.address = "";
        this.total = 0;
        
        this.buyID = 0;
        this.type = 0;
        
        this.searchword = "";
        this.searchResult = "";
        
        this.totalResultsAvailable = "";
        this.query = "";
        this.productName = "";
        this.price = "";
        this.productPic = "";
        this.description = "";
        this.code = "";
        this.reviewRate = "";
        this.reviewCount = "";
    }
    
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
        //未入力の場合は空文字をセット
        if(name.trim().length() == 0){
            this.name = "";
        }else{
            this.name = name;
        }
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        if(password.trim().length() == 0){
            this.password = "";
        }else{
            this.password = password;
        }
    }
    
    public String getMail(){
        return mail;
    }
    
    public void setMail(String mail){
        if(mail.trim().length()==0){
            this.mail = "";
        }else{
            this.mail = mail;
        }
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        if(address.trim().length()==0){
            this.address = "";
        }else{
            this.address = address;
        }
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
    
    public Timestamp getBuyDate(){
        return buyDate;
    }
    
    public void setBuyDate(Timestamp buyDate){
        this.buyDate = buyDate;
    }
    
    //検索ワード
    public String getSearchword(){
        return searchword;
    }
    
    public void setSearchword(String searchword){
        if(searchword.trim().length()==0){
            this.searchword = "";
        }else{
            this.searchword = searchword;
        }
    }
    
    public String getSearchResult(){
        return searchResult;
    }
    
    public void setSearchResult(String searchResult){
        if(searchResult.trim().length()==0){
            this.searchResult = "";
        }else{
            this.searchResult = searchResult;
        }
    }
    
    
    //Yahoo APIから持ってくる情報
    public String getTotalResultsAvailable(){
        return totalResultsAvailable;
    }
    
    public void setTotalResultsAvailable(String totalResultsAvailable){
        if(totalResultsAvailable.trim().length()==0){
            this.totalResultsAvailable = "";
        }else{
            this.totalResultsAvailable = totalResultsAvailable;
        }
    }
    
    public String getQuery(){
        return query;
    }
    
    public void setQuery(String query){
        if(query.trim().length()==0){
            this.query = "";
        }else{
            this.query = query;
        }
    }
    
    public String getProductName(){
        return productName;
    }
    
    public void setProductName(String productName){
        if(productName.trim().length()==0){
            this.productName = "";
        }else{
            this.productName = productName;
        }
    }
    
    public String getPrice(){
        return price;
    }
    
    public void setPrice(String price){
        if(price.trim().length()==0){
            this.price = "";
        }else{
            this.price = price;
        }
    }
    
    public String getProductPic(){
        return productPic;
    }
    
    public void setProductPic(String productPic){
        if(productPic.trim().length()==0){
            this.productPic = "";
        }else{
            this.productPic = productPic;
        }
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        if(description.trim().length()==0){
            this.description = "";
        }else{
            this.description = description;
        }
    }
    
    public String getCode(){
        return code;
    }
    
    public void setCode(String code){
        if(code.trim().length()==0){
            this.code = "";
        }else{
            this.code = code;
        }
    }
    
    public String getReviewRate(){
        return reviewRate;
    }
    
    public void setReviewRate(String reviewRate){
        if(reviewRate.trim().length()==0){
            this.reviewRate = "";
        }else{
            this.reviewRate = reviewRate;
        }
    }
    
    public String getReviewCount(){
        return reviewCount;
    }
    
    public void setReviewCount(String reviewCount){
        if(reviewCount.trim().length()==0){
            this.reviewCount = "";
        }else{
            this.reviewCount = reviewCount;
        }
    }
    
    
    public static UserData getInstance(){
        return new UserData();
    }

    //ログインページへ
    private final String loginURL = "http://localhost:8080/kagoyume/login";
    
    public String login(){
        return "<a href=\""+loginURL+"\">ログイン</a>";
    }
    
    //トップページへ
    private final String topURL = "http://localhost:8080/kagoyume/top.jsp";
    
    public String top(){
        return "<a href=\""+topURL+"\">トップへ</a>";
    }

    //郵送方法 buyConfirm.jspにて使用
    public String selectType(int i){
        switch(i){
            case 1:
                return "楽びん";
            case 2:
                return "クロネコ宅急便";
            case 3:
                return "ゆうパック";
            case 4:
                return "レターパック";
            case 5:
                return "その他";
        }
        return "";
    }

    // DBへマッピングするためのメソッド
    public void MappingToDB(UserDataDTO udd){
        udd.setName(this.name);
        udd.setPassword(this.password);
        udd.setMail(this.mail);
        udd.setTotal(this.total);
        udd.setAddress(this.address);
        udd.setBuyID(this.buyID);
        udd.setType(this.type);
    }
    
    //DBから取り出したユーザー情報を格納するためのメソッド
    public void UserInfoFromDB(UserDataDTO udd){
        this.setUserID(udd.getUserID());
        this.setName(udd.getName());
        this.setPassword(udd.getPassword());
        this.setMail(udd.getMail());
        this.setAddress(udd.getAddress());
        this.setTotal(udd.getTotal());
        this.setNewDate(udd.getNewDate());
    }

    
}
