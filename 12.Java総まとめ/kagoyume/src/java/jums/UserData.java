package jums;

import java.io.Serializable;

/**
 * 
 * 
 * @author takuyamuroyama
 */
public class UserData implements Serializable{
    
    //新規会員情報
    private String name;
    private String password;
    private String mail;
    private String address;
    //検索ワード情報
    private String searchword;
    private String searchResult;
    //Yahoo APIから持ってきた情報
    private String totalResultsAvailable;
    private String query;
    private String productName;
    private String price;
    private String productPic;
    
    
    public UserData(){
        this.name = "";
        this.password = "";
        this.mail = "";
        this.address = "";
        
        this.searchword = "";
        this.searchResult = "";
        
        this.totalResultsAvailable = "";
        this.productName = "";
        this.price = "";
        this.productPic = "";
        this.query = "";
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
            this.productName = productName;
        }
    }
    
    public String getPrice(){
        return price;
    }
    
    public void setPrice(String price){
        if(price.trim().length()==0){
            this.price = price;
        }
    }
    
    public String getProductPic(){
        return productPic;
    }
    
    public void setProductPic(String productPic){
        if(productPic.trim().length()==0){
            this.productPic = productPic;
        }
    }

    //ログインページ
    private final String loginURL = "login.jsp";
    
    public static UserData getInstance(){
        return new UserData();
    }
    
    public String login(){
        return "<a href=\""+loginURL+"\">ログイン</a>";
    }
    
    //UserDataDTOへのマッピング
    public void MapingToUDD(UserDataDTO udd){
        udd.setName(this.name);
        udd.setPassword(this.password);
        udd.setMail(this.mail);
        udd.setAddress(this.address);
    }
    
    //新規会員登録ページにて入力が不足している箇所があった場合
    
}
