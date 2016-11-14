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
        JsonNode itemTree = baseTree.get("0").get("Result");
        
        for(int i=0; i<20; i++){
            UserData ud = new UserData();
            String count = Integer.toString(i);
            ud.setProductName(itemTree.get(count).get("Name").asText()); //商品名
            ud.setPrice(itemTree.get(count).get("Price").get("_value").asText()); //商品値段
            ud.setProductPic(itemTree.get(count).get("Image").get("Medium").asText()); //商品画像
            ud.setDescription(itemTree.get(count).get("Description").asText()); //商品説明
            ud.setCode(itemTree.get(count).get("Code").asText()); //商品コード
            ud.setReviewRate(itemTree.get(count).get("Review").get("Rate").asText()); //レビュー平均
            ud.setReviewCount(itemTree.get(count).get("Review").get("Count").asText()); //レビュー件数
            jsonData.add(ud);
        }
    
    }catch(Exception e){
            throw new Exception(e);
    }finally{
        return jsonData;
    }
    
}

}
