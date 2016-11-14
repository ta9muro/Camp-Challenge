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
public class TransformationToJSON_2 {

//インスタンスオブジェクトを返却させてコードの簡略化
public static TransformationToJSON_2 getInstance(){
    return new TransformationToJSON_2();
}

public static UserData getJsonNode(String url) throws Exception{

    
    JsonNode head = null;
    UserData ud = new UserData();
    
    try{
        JsonFactory jfactory = new JsonFactory();
        JsonParser parser = jfactory.createJsonParser(url);
        ObjectMapper mapper = new ObjectMapper();
        head = mapper.readTree(parser);
        
        JsonNode baseTree = head.get("ResultSet");
        JsonNode itemTree = baseTree.get("0").get("Result");
        
        ud.setQuery(itemTree.get("Request").get("Query").asText()); //検索ワード
        ud.setTotalResultsAvailable(baseTree.get("totalResultsAvailable").asText()); //検索件数
    
    }catch(Exception e){
            throw new Exception(e);
    }finally{
        return ud;
    }
    
}

}
