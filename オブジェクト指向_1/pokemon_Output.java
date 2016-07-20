/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object_2;

import object_2.pokemon;
import object_2.pokemon_2;

/**
 *
 * @author ta9muro
 */

//3問目
public class pokemon_Output {
    static public void main(String srgs[]){

//pokemon pikachu = new pikachu();//pikachuという名前のクラスが無いから怒られます。
pokemon pikachu = new pokemon(); // ポケモンクラスのインスタンスを生成し、ピカチューという名前の変数に格納しました。
pikachu.setPokemon("pikachu", 17, "kick");

pokemon mew = new pokemon();
mew.setPokemon("mew", 150, "punch");

pikachu.showName();
pikachu.showLevels();
pikachu.showSkills();

mew.showName();
mew.showLevels();
mew.showSkills();


System.out.println("------------- pokemon_2 --------------");


pokemon_2 clearPikachu = new pokemon_2();
clearPikachu.setPokemon("pikachu", 17, "kick");

pokemon_2 clearMew = new pokemon_2();
clearMew.setPokemon("mew", 150, "punch");

clearPikachu.showName();
clearPikachu.showLevels();
clearPikachu.showSkills();

clearPikachu.clearName();
clearPikachu.clearLevels();
clearPikachu.clearSkills();

clearPikachu.showName();
clearPikachu.showLevels();
clearPikachu.showSkills();


clearMew.showName();
clearMew.showLevels();
clearMew.showSkills();

clearMew.clearName();
clearMew.clearLevels();
clearMew.clearSkills();

clearMew.showName();
clearMew.showLevels();
clearMew.showSkills();


    }    
}

    
