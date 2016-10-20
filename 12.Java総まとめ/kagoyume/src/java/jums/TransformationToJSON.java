/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.*;


/**
 *
 * @author takuyamuroyama
 */
public class TransformationToJSON {

//インスタンスオブジェクトを返却させてコードの簡略化
public static TransformationToJSON getInstance(){
    return new TransformationToJSON();
}

public static ArrayList<UserData> getJsonNode(String url) throws Exception{

    
    JsonNode head = null;
    ArrayList<UserData> jsonData = new ArrayList<UserData>();
    
    try{
        JsonFactory jfactory = new JsonFactory();
        JsonParser parser = jfactory.createJsonParser(url);
        ObjectMapper mapper = new ObjectMapper();
        head = mapper.readTree(parser);
        JsonNode baseTree = head.get("ResultSet");
        JsonNode itemTree = baseTree.at("/0/Result/");

        //JSONArray jsonArray = new JSONArray();
        //ArrayList<HashMap><String, >
        
        for(int i=0; i<20; i++){  
            UserData ud = new UserData();
            ud.setProductName((itemTree.get(i).get(".Name")).asText()); //商品名
            ud.setPrice((itemTree.get(i).get(".Price._value")).asText()); //価格
            ud.setProductPic((itemTree.get(i).get(".Store.Image.Medium")).asText());
            ud.setProductPic((itemTree.get(i).get(".Store.Image.Medium")).asText());
            jsonData.add(ud);
        }
        
        UserData ud = new UserData();
        ud.setQuery((itemTree.get(19).get("Request.Query")).asText()); //検索ワード
        ud.setTotalResultsAvailable((baseTree.get("totalResultsAvailable")).asText()); //検索件数
        
            
    
    }catch(Exception e){
        throw new Exception(e);
    }finally{
        return jsonData;
    }
    
}

}
