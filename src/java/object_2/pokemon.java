/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object_2;

/**
 *
 * @author ta9muro
 */

//オブジェクト指向 課題:基礎編
//1＆2問目

//ポケモン
    //役目・・・ポケモン
    //情報・・・名前、レベル、技
    //スキル・・・パンチ、キック、逃げる
    
//敵
    //役目・・・敵
    //情報・・・名前、レベル、技
    //スキル・・・パンチ、キック、逃げる
    
//主人公
    //役目・・・主人公
    //情報・・・性別、年齢
    //スキル・・・指示

//モンスタークラス
//・役目
//・情報
//・スキル

//3問目
public class pokemon {
   public String name=""; //名前
   public Integer levels=0; //レベル 
   public String skills=""; //技
   public void setPokemon(String a, Integer b, String c){name = a; levels = b; skills = c;}
   public void showName(){System.out.println(name);}
   public void showLevels(){System.out.println(levels);}
   public void showSkills(){System.out.println(skills);}   
}


