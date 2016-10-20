/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.File;
import java.util.*;
import java.io.*;
import java.text.*;

/**
 *ログ記録するためのクラス
 * @author takuyamuroyama
 * throws Exception 呼び出し元にcatchさせるためにスロー 
 */
public class log {
    
    //インスタンスオブジェクトを返却ためのコード
    public static log getInstance(){
        return new log();
    }
    
    public static void logData(String msg) throws Exception{
        //ログを残すためのファイル
        File logFile = new File("/Users/takuyamuroyama/NetBeansProjects/kagoyume/log.txt");
        
        try{
            //現在時刻
            Date inputDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
            String inputDateLog = sdf.format(inputDate);
            
            FileWriter writeLogFile = new FileWriter(logFile, true);
            BufferedWriter bw = new BufferedWriter(writeLogFile);
            
            bw.write(inputDateLog);  //時間ログ入力
            bw.newLine();
            bw.write(msg); //進捗メッセージログ入力
            bw.newLine();
            bw.close();
        }catch(Exception e){
            throw new Exception(e);
        }
    }
}
