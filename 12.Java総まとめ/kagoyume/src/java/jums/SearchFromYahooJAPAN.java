/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.*;
import java.net.*;

/**
 *http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?appid=dj0zaiZpPVZuckdNd3hFTmwzRyZzPWNvbnN1bWVyc2VjcmV0Jng9NTY-&query=%E3%82%B3%E3%83%BC%E3%83%A9
 * @author takuyamuroyama
 * HTTP接続してYahooJAPANで検索した結果を得るクラス
 */
public class SearchFromYahooJAPAN {

//インスタンスオブジェクトを返却させてコードの簡略化
public static SearchFromYahooJAPAN getInstance(){
    return new SearchFromYahooJAPAN();
    }


public String getSearch(UserData ud) throws Exception{
    String searchResult = "";
    String requestURL = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?";
    String appID = "appid=dj0zaiZpPVZuckdNd3hFTmwzRyZzPWNvbnN1bWVyc2VjcmV0Jng9NTY-&";
    
    try{
        String urlString = requestURL + appID + "query=" + ud.getSearchword();
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.connect();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        
        String tmp = "";
        //1行ずつ、まとめて読み込む
        while((tmp = in.readLine()) != null){
            searchResult += tmp;
        }
        in.close(); 
        con.disconnect();
    }catch(Exception e){
        //e.printStackTrace();
        throw new Exception(e);
    }
    return searchResult;
}

}


