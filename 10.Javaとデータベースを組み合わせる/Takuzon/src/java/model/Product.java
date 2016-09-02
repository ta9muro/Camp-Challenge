/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author takuyamuroyama
 */
public class Product implements Serializable{
    private String code; //商品コード
    private String name; //商品名
    private String category; //カテゴリ
    private String price; //価格
    private String quantity; //数量
    private String user; //ユーザー
    
    public Product(){}
    public Product(String code, String name, String category, String price, String quantity, String user){
        this.code = code;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.user = user;
    }
    
    public String getCode(){return code;}
    public String getName(){return name;}
    public String getCategory(){return category;}
    public String getPrice(){return price;}
    public String getQuantity(){return quantity;}
    public String getUser(){return user;}
}
